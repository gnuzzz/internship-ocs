package ru.digitalleague.ocs.internship.lesson16;

public class FictiveCartsRepository implements CartsRepository {
    @Override
    public Cart16 getCart(User16 user) {
        return null;
    }

    @Override
    public CartItem16 createCartItem(Cart16 cart, Book16 book, int quantity) {
        return null;
    }

    @Override
    public CartItem16 updateCartItem(CartItem16 item) {
        return null;
    }

    @Override
    public void removeCartItem(CartItem16 item) {
        //do nothing
    }
}
