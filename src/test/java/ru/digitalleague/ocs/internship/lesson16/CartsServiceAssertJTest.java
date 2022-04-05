package ru.digitalleague.ocs.internship.lesson16;

import java.util.Arrays;
import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CartsServiceAssertJTest {

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
        assertThat(cart.getItems()).isNotNull().isEmpty();
        assertThat(cart.getSum()).isEqualTo(0);
        assertThat(cart.getVatSum()).isEqualTo(0);
//        Assertions.assertTrue(cart.getItems().isEmpty());
//        Assertions.assertEquals(0, cart.getSum());
//        Assertions.assertEquals(0, cart.getVatSum());
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
        assertThat(cart.getItems()).isNotNull().isNotEmpty();
        assertThat(cart.getItems().size()).isEqualTo(2);
        assertThat(cart.getItems()).contains(new CartItem16(cart, book1, 1));
        assertThat(cart.getSum()).isEqualTo(200);
        assertThat(cart.getVatSum()).isEqualTo(29);

//        Assertions.assertEquals(2, cart.getItems().size());
//        Assertions.assertEquals(200, cart.getSum());
//        Assertions.assertEquals(29, cart.getVatSum());
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

    @Test
    @Disabled
    public void test() {
        User16 user1 = new User16("test@test.com", "Test1");
        User16 user2 = new User16("test@test.com", "Test2");
        assertThat(user1).isEqualTo(user2);
        assertThat(user1).usingRecursiveComparison().isEqualTo(user2);
    }

    @Test
    public void test2() {
        User16 user1 = new User16("aaa@test.com", "aaa");
        User16 user2 = new User16(null, "aaa");

        UserAssert.assertThat(user1).hasNoneEmptyEmail();
//        UserAssert.assertThat(user2).hasNoneEmptyEmail();
    }

    static class UserAssert extends AbstractAssert<UserAssert, User16> {
        public UserAssert(User16 user16) {
            super(user16, UserAssert.class);
        }

        public UserAssert hasNoneEmptyEmail() {
            isNotNull();
            if (actual.getEmail() == null) {
                failWithMessage("Email of user is null");
            }
            return this;
        }

        public static UserAssert assertThat(User16 user) {
            return new UserAssert(user);
        }
    }

}
