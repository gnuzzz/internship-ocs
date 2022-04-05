package ru.digitalleague.ocs.internship.lesson16;

import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CartsServiceTestContainersTest {

    private PostgreSQLContainer postgresql;
    private EntityManagerFactory factory;
    private CatalogService catalogService;
    private UsersService usersService;
    private CartsService cartsService;

    @BeforeAll
    public void setUpAll() throws Exception {
        postgresql = new PostgreSQLContainer("postgres:13")
                .withDatabaseName("postgres")
                .withUsername("postgres")
                .withPassword("postgres");
        postgresql.start();

        var flyway = Flyway.configure()
                .locations("filesystem:./src/main/resources/db/migration/", "filesystem:./src/test/resources/db/migration/")
                .dataSource(
                        postgresql.getJdbcUrl(),
                        postgresql.getUsername(),
                        postgresql.getPassword()
                )
                .placeholderReplacement(false)
                .load();
        flyway.info();
        flyway.migrate();

        var properties = new HashMap<String, String>();
        properties.put("javax.persistence.jdbc.url", postgresql.getJdbcUrl());
        properties.put("javax.persistence.jdbc.user", postgresql.getUsername());
        properties.put("javax.persistence.jdbc.password", postgresql.getPassword());
        factory = Persistence.createEntityManagerFactory("defaultPersistenceUnit", properties);
    }

    @AfterAll
    public void tearDownAll() {
        factory.close();
        postgresql.stop();
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = factory.createEntityManager();
        var catalogRepository = new JPACatalogRepository(em);
        catalogService = new CatalogService(catalogRepository);
        var usersRepository = new JPAUsersRepository(em);
        usersService = new UsersService(usersRepository);
        var cartsRepository = new JPACartsRepository(em);
        cartsService = new CartsService(cartsRepository);
    }

    @Test
    public void test() throws Exception {
        var email = "vpupkin@test.com";
        var user = usersService.getUser(email);
        assertThat(user.getEmail()).isEqualTo(email);
    }

}
