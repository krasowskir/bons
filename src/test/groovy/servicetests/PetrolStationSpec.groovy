//package servicetests
//
//import com.example.bons.Application
//import com.example.bons.controller.dto.AddressDTO
//import com.example.bons.entity.Address
//import com.example.bons.entity.PetrolStation
//import com.fasterxml.jackson.databind.ObjectMapper
//import org.junit.Rule
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.boot.web.server.LocalServerPort
//import org.springframework.context.ApplicationContextInitializer
//import org.springframework.context.ConfigurableApplicationContext
//import org.springframework.hateoas.config.HypermediaRestTemplateConfigurer
//import org.springframework.jdbc.core.JdbcTemplate
//import org.springframework.restdocs.JUnitRestDocumentation
//import org.springframework.test.context.ContextConfiguration
//import org.springframework.test.jdbc.JdbcTestUtils
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.web.client.RestTemplate
//import org.testcontainers.containers.PostgreSQLContainer
//import org.testcontainers.spock.Testcontainers
//import spock.lang.Specification
//
//import javax.sql.DataSource
//
//import static org.springframework.boot.test.util.TestPropertyValues.of
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
//
//@AutoConfigureMockMvc
//@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
//@Testcontainers
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(initializers = [Initializer.class])
//class PetrolStationSpec extends Specification {
//
//    @LocalServerPort
//    int port;
//
//    @Autowired
//    DataSource dataSource
//
//    @Autowired
//    HypermediaRestTemplateConfigurer configurer
//
//    @Autowired
//    MockMvc mockMvc
//
//    @Autowired
//    JdbcTemplate jdbcTemplate
//
//    @Autowired
//    RestTemplate restTemplate
//
//    ObjectMapper mapper = new ObjectMapper()
//
//    @Rule
//    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation()
//
//    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
//
//        def postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
//                .withDatabaseName("int-test-db")
//                .withUsername("sa")
//                .withPassword("sa")
//
//        void initialize(ConfigurableApplicationContext configurableApplicationContext) {
//            postgreSQLContainer.start()
//            of(
//                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
//                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
//                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
//            ).applyTo(configurableApplicationContext.getEnvironment());
//        }
//    }
//
//    def 'it is possible to create petrol stations'(){
//
//        given: 'an address that is created first'
//        def createdAddress = restTemplate.postForObject("http://localhost:" + port + "/api/addresses",
//                new AddressDTO('test', 'testLastName', 'teststreet-2', '10707', 'berlin', '0123456789'), Address.class)
//        JdbcTestUtils.countRowsInTable(jdbcTemplate, 'address') == 1
//
//        and: 'a petrol station with that address'
//        def shell = new PetrolStation(name: 'Shell',telephone: '03089076543',taxIdentificationNumberOfStation: '09011234578908665', taxIdentificationNumberOfCompany: '09011987654321',bonNumber: '5462917638', stNr: '1234628', USTIdentNr: '4231232343',address: createdAddress)
//
//        when: 'calling POST on /api/petrolStations with a petrolstation in request body'
//        def result = mockMvc.perform(post('/api/petrolStations').content(mapper.writeValueAsBytes(shell)))
//
//        then: 'the resource is created'
//        result.andExpect(status().is2xxSuccessful())
//
//        and: 'the entry is persisted in the db'
//        JdbcTestUtils.countRowsInTable(jdbcTemplate, 'petrolstation') == 1
//    }
//
//    def 'petrol station GET operations should work as expected'(){
//
//        given: 'a petrol station'
//        def shell = new PetrolStation(name: 'Shell',telephone: '03089076543',taxIdentificationNumberOfStation: '09011234578908665', taxIdentificationNumberOfCompany: '09011987654321',bonNumber: '5462917638', stNr: '1234628', USTIdentNr: '4231232343')
//
//
//        when:
//        def result = mockMvc.perform(get('/api/petrolStations'))
//
////        def result = restTemplate.exchange("http://localhost:" + port + "/api/addresses", HttpMethod.GET,
////                new HttpEntity<Object>(new AddressDTO('test', 'testLastName', 'teststreet-2', '10707', 'berlin', '0123456789')),
////                new ParameterizedTypeReference<CollectionModel<Address>>() {}, new HashMap<String, String>())
//
//        then:
//        result.andExpect(status().is2xxSuccessful())
//
//        and:
//        result != null
//    }
//}
