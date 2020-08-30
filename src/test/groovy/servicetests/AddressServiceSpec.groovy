package servicetests

import com.example.bons.Application
import com.example.bons.controller.dto.AddressDTO
import com.example.bons.entity.Address
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.core.ParameterizedTypeReference
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.config.HypermediaRestTemplateConfigurer
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.jdbc.JdbcTestUtils
import org.springframework.web.client.RestTemplate
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification

import javax.sql.DataSource

import static org.springframework.boot.test.util.TestPropertyValues.of

@Testcontainers
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = [Initializer.class])
class AddressServiceSpec extends Specification {

    @LocalServerPort
    int port;

    @Autowired
    DataSource dataSource

    @Autowired
    HypermediaRestTemplateConfigurer configurer

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        def postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
                .withDatabaseName("int-test-db")
                .withUsername("sa")
                .withPassword("sa")

        void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            postgreSQLContainer.start()
            of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    def 'storing an address is possible'() {
        given:
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource)
        TestRestTemplate restTemplate = new TestRestTemplate()

        and:
        JdbcTestUtils.countRowsInTable(jdbcTemplate, 'address') == 0

        when:
        def result = restTemplate.postForObject("http://localhost:" + port + "/api/addresses",
                new AddressDTO('test', 'testLastName', 'teststreet-2', '10707', 'berlin', '0123456789'), Address.class)

        then:
        JdbcTestUtils.countRowsInTable(jdbcTemplate, 'address') == 1

        and:
        result.lastName == 'testLastName'
    }

    def 'fetching an address is possible'() {
        given:
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource)
        RestTemplate restTemplate = configurer.registerHypermediaTypes(new RestTemplate())

        and:
        JdbcTestUtils.countRowsInTable(jdbcTemplate, 'address') == 0

        when:
        restTemplate.postForObject("http://localhost:" + port + "/api/addresses",
                new AddressDTO('test', 'testLastName', 'teststreet-2', '10707', 'berlin', '0123456789'), Address.class)

        def result = restTemplate.exchange("http://localhost:" + port + "/api/addresses", HttpMethod.GET,
                new HttpEntity<Object>(new AddressDTO('test', 'testLastName', 'teststreet-2', '10707', 'berlin', '0123456789')),
                new ParameterizedTypeReference<CollectionModel<Address>>() {}, new HashMap<String, String>())

        then:
        JdbcTestUtils.countRowsInTable(jdbcTemplate, 'address') > 0

        and:
        result != null
        with(result.body[0]) {
            lastName == 'testLastName'
            firstName == "test"
        }
    }
}
