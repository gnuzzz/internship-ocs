package ru.digitalleague.ocs.internship.lesson16;

import java.util.Arrays;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CartsServicePureJUnitTest {

    private static Category16 category1;
    private static Category16 category2;
    private static Author16 author1;
    private static Author16 author2;
    private static Book16 book1;
    private static Book16 book2;

    private User16 user;

    @BeforeAll
    public static void setUpAll() {
//        System.out.println("Before all tests");
        category1 = new Category16(1L, "Фантастика");
        category2 = new Category16(2L, "Научно-популярная литература");
        author1 = new Author16(1L, "Айзек Азимов");
        author2 = new Author16(5L, "Дэвид Дойч");
        book1 = new ScienceFictionBook16(1L, "Основание", category1, "foundation.png", 1951, Arrays.asList(author1), 110, 10, "space opera");
        book2 = new PopularScienceBook16(4L, "Структура реальности", category2, "structure.png", 1997, Arrays.asList(author2), 90, 20, "phisics");
    }

    @AfterAll
    public static void tearDownAll() {
//        System.out.println("After all tests");
    }

    @BeforeEach
    public void setUp() {
//        System.out.println("Before each test");
        user = new User16("vpupkin@test.com", "Василий Пупкин");
    }

    @AfterEach
    public void tearDown() {
//        System.out.println("After each test");
    }

    @Test
    @DisplayName("Should success get end recalculate empty cart")
    public void successGetCartForEmptyCart() throws Exception {
        CartsRepository cartsRepository = new FictiveCartsRepository() {
            @Override
            public Cart16 getCart(User16 user) {
                Cart16 cart = new Cart16(user.getEmail());
                return cart;
            }
        };
        CartsService cartsService = new CartsService(cartsRepository);

        Cart16 cart = cartsService.getCart(user);
        Assertions.assertTrue(cart.getItems().isEmpty());
        Assertions.assertEquals(0, cart.getSum());
        Assertions.assertEquals(0, cart.getVatSum());
    }

    @Test
    @DisplayName("Should success get end recalculate non-empty cart")
    public void successGetCartForNonEmptyCart() throws Exception {
        CartsRepository cartsRepository = new FictiveCartsRepository() {
            @Override
            public Cart16 getCart(User16 user) {
                Cart16 cart = new Cart16(user.getEmail());
                CartItem16 item1 = new CartItem16(cart, book1, 1);
                CartItem16 item2 = new CartItem16(cart, book2, 1);
                cart.setItems(Arrays.asList(item1, item2));
                return cart;
            }
        };
        CartsService cartsService = new CartsService(cartsRepository);

        Cart16 cart = cartsService.getCart(user);
        Assertions.assertEquals(2, cart.getItems().size());
        Assertions.assertEquals(200, cart.getSum());
        Assertions.assertEquals(29, cart.getVatSum());
    }

    @Test
    public void correctHandleGetCartException() throws Exception {
        CartsRepository cartsRepository = new FictiveCartsRepository() {
            @Override
            public Cart16 getCart(User16 user) {
                throw new RuntimeException("get cart exception");
            }
        };
        CartsService cartsService = new CartsService(cartsRepository);
        Assertions.assertThrows(MarketException.class, () -> cartsService.getCart(user), "get cart exception");
    }

}
