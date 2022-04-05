package ru.digitalleague.ocs.internship.lesson16;

public interface CartsRepository {

    Cart16 getCart(User16 user);

    CartItem16 createCartItem(Cart16 cart, Book16 book, int quantity);

    CartItem16 updateCartItem(CartItem16 item);

    void removeCartItem(CartItem16 item);
}
