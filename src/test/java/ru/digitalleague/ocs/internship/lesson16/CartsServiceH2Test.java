package ru.digitalleague.ocs.internship.lesson16;

import org.easymock.EasyMock;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

public class CartsServiceH2Test {

    @BeforeAll
    public static void setUpAll() throws Exception {
        Class.forName("org.h2.Driver");
        var flyway = Flyway.configure()
                .locations("filesystem:./src/main/resources/db/migration/", "filesystem:./src/test/resources/db/migration/")
                .dataSource(
                        "jdbc:h2:mem:test_db;MODE=PostgreSQL",
                        "sa",
                        ""
                )
                .placeholderReplacement(false)
                .load();
        flyway.info();
        flyway.migrate();
    }

    @Test
    public void test() {
//        //do nothing
//        try {
//            CartsService cartsService = EasyMock.createNiceMock(CartsService.class);
//            expect(cartsService.getCart(anyObject())).andReturn(new Cart16());
//            replay(cartsService);
//            var cart = cartsService.getCart(null);
//            System.out.println(cart);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println("aaa");
    }
}
