package ru.digitalleague.ocs.internship.lesson16;

import javax.persistence.EntityManager;

public class JPACartsRepository implements CartsRepository {

    private EntityManager em;

    public JPACartsRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Cart16 getCart(User16 user) {
        var t = em.getTransaction();
        t.begin();
        try {
            Cart16 cart = em.find(Cart16.class, user.getEmail());
            if (cart == null) {
                cart = new Cart16(user.getEmail());
                em.persist(cart);
            }
            t.commit();
            return cart;
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
    }

    @Override
    public CartItem16 createCartItem(Cart16 cart, Book16 book, int quantity) {
        var t = em.getTransaction();
        t.begin();
        try {
            CartItem16 item = new CartItem16(cart, book, quantity);
            em.persist(item);
            t.commit();
            return item;
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
    }

    @Override
    public CartItem16 updateCartItem(CartItem16 item) {
        var t = em.getTransaction();
        t.begin();
        try {
            em.persist(item);
            t.commit();
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
        return item;
    }

    @Override
    public void removeCartItem(CartItem16 item) {
        var t = em.getTransaction();
        t.begin();
        try {
            em.remove(item);
            t.commit();
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
    }

}
