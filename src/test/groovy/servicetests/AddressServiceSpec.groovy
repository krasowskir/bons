package servicetests

import com.example.bons.Application
import com.example.bons.controller.AddressController
import com.example.bons.controller.dto.AddressDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.jdbc.JdbcTestUtils
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification

import javax.sql.DataSource

import static org.springframework.boot.test.util.TestPropertyValues.of

@Testcontainers
@SpringBootTest(classes = Application.class)
@ContextConfiguration(initializers = [Initializer.class])
class AddressServiceSpec extends Specification {

    @Autowired
    DataSource dataSource

    @Autowired
    AddressController addressController

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

        and:
        JdbcTestUtils.countRowsInTable(jdbcTemplate, 'address') == 0

        when:
        def result = addressController.createAddress(new AddressDTO('test', 'testLastName', 'teststreet-2', '10707', 'berlin', '0123456789'))

        then:
        JdbcTestUtils.countRowsInTable(jdbcTemplate, 'address') == 1

        and:
        result.lastName == 'testLastName'
    }
}
