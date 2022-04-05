package ru.digitalleague.ocs.internship.lesson16;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.getCurrentArguments;
import static org.easymock.EasyMock.replay;

public class CartsServiceEasyMockTest {

    @Test
    public void testCreateMock() throws Exception {
        CartsService cartsService = EasyMock.createMock(CartsService.class);
        User16 user = new User16("iivanov@test.com", "Иван Иванов");
        Cart16 userCart = new Cart16();
        expect(cartsService.getCart(user)).andReturn(userCart);
        replay(cartsService);

        Cart16 cart = cartsService.getCart(user);
        System.out.println(cart);
    }

    @Test
    public void testCreateNiceMock() throws Exception {
        CartsService cartsService = EasyMock.createNiceMock(CartsService.class);
        User16 user = new User16("iivanov@test.com", "Иван Иванов");

        Cart16 cart = cartsService.getCart(user);
        System.out.println(cart);

    }

    @Test
    public void testCreateMockWithStub() throws Exception {
        CartsService cartsService = EasyMock.createMock(CartsService.class);
        User16 user = new User16("iivanov@test.com", "Иван Иванов");
        Cart16 userCart = new Cart16();
//        expect(cartsService.getCart(user)).andReturn(userCart);
        expect(cartsService.getCart(user)).andStubReturn(userCart);
        replay(cartsService);

        Cart16 cart = cartsService.getCart(user);
        System.out.println(cart);
        cart = cartsService.getCart(user);
        System.out.println(cart);
    }

    @Test
    public void testCreateMockWithTimes() throws Exception {
        CartsService cartsService = EasyMock.createMock(CartsService.class);
        User16 user = new User16("iivanov@test.com", "Иван Иванов");
        Cart16 userCart = new Cart16();
        expect(cartsService.getCart(user)).andReturn(userCart);
        expectLastCall().times(2);
        replay(cartsService);

        Cart16 cart = cartsService.getCart(user);
        System.out.println(cart);
        cart = cartsService.getCart(user);
        System.out.println(cart);
//        cart = cartsService.getCart(user);
//        System.out.println(cart);
    }

    @Test
    public void testCreateMockAnyUser() throws Exception {
        CartsService cartsService = EasyMock.createMock(CartsService.class);
        User16 user1 = new User16("iivanov1@test.com", "Иван Иванов");
        User16 user2 = new User16("iivanov2@test.com", "Иван Иванов");
        Cart16 userCart = new Cart16();
//        expect(cartsService.getCart(user1)).andReturn(userCart);
//        expect(cartsService.getCart(user2)).andReturn(userCart);
        expect(cartsService.getCart(anyObject(User16.class))).andReturn(userCart);
        expectLastCall().times(2);
        replay(cartsService);

        Cart16 cart = cartsService.getCart(user1);
        System.out.println(cart);
        cart = cartsService.getCart(user2);
        System.out.println(cart);
    }

    @Test
    public void testCreateMockWithCustomAnswer() throws Exception {
        UsersService usersService = EasyMock.createMock(UsersService.class);
        expect(usersService.getUser(anyString())).andStubAnswer(() -> new User16((String)getCurrentArguments()[0], "Иван Иванов"));
        replay(usersService);

        User16 user = usersService.getUser("test1@test.com");
        System.out.println(user.getEmail());
        user = usersService.getUser("test2@test.com");
        System.out.println(user.getEmail());
    }
}
