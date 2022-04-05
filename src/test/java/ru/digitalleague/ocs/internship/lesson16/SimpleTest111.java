package ru.digitalleague.ocs.internship.lesson16;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SimpleTest111 {

//    @Test
//    public void test() {
//        System.out.println("test");
//    }

//    @BeforeAll
//    public static void setUpAll() {
//        System.out.println("before all");
//    }
//
//    @AfterAll
//    public static void tearDownAll() {
//        System.out.println("after all");
//    }
//
//    @BeforeEach
//    public void setUp() {
//        System.out.println("before each");
//    }
//
//    @AfterEach
//    public void tearDown() {
//        System.out.println("after each");
//    }
//
//    @Test
//    public void test1() {
////        System.out.println("test1");
//        System.out.println("test1 " + this);
//    }
//
//    @Test
//    public void test2() {
////        System.out.println("test2");
//        System.out.println("test2" + this);
//    }

//    @Test
//    public void testGetUser() {
//        String email = "iivanov@test.com";
//        User16 user = getUser1(email);
//        Assertions.assertEquals(email, user.getEmail());
//    }
//
//    @Test
//    public void testGetUserWithException() {
//        String email = "iivanov@test.com";
//        Assertions.assertThrows(MarketException.class, () -> getUser2(email));
//    }
//
//    private User16 getUser1(String email) {
//        return new User16(email, "Иван Иванов");
//    }
//
//    private User16 getUser2(String email) throws MarketException{
//        throw new MarketException("invalid email");
////        throw new RuntimeException("invalid email");
//    }

//    @RepeatedTest(4)
//    public void testRepeated() {
//        System.out.println("repeated");
//    }

//    @ParameterizedTest
//    @ValueSource(strings = {"email1@test.com", "email2@test.com"})
//    @CsvSource({"email1@test.com", "email2@test.com"})
//    @CsvFileSource(files = "/Users/vladimirkornyshev/lang/digitalleague.ru/internship-ocs/src/main/resources/data.csv")
//    public void testParameterized(String email) {
//        var user = new User16(email, "Иван Иванов");
//        System.out.println(user.getEmail());
//    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class SomeTests {

        @BeforeAll
        public void setUpAll() {
            System.out.println("before all some tests");
        }

        @Test
        public void test1() {
            System.out.println("test1");
        }

        @Test
        public void test2() {
            System.out.println("test2");
        }

    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class OtherTests {

        @BeforeAll
        public void setUpAll() {
            System.out.println("before all other tests");
        }

        @Test
        public void test3() {
            System.out.println("test3");
        }

        @Test
        public void test4() {
            System.out.println("test4");
        }

    }

}
