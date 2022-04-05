package ru.digitalleague.ocs.internship.lesson16;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem16 {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private Cart16 cart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book16 book;

    @Column(name = "quantity")
    private int quantity;

    public CartItem16() {
    }

    public CartItem16(Cart16 cart, Book16 book, int quantity) {
        this.cart = cart;
        this.book = book;
        this.quantity = quantity;
    }

    public Cart16 getCart() {
        return cart;
    }

    public Book16 getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem16 that = (CartItem16) o;

        if (quantity != that.quantity) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cart != null ? !cart.equals(that.cart) : that.cart != null) return false;
        return book != null ? book.equals(that.book) : that.book == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cart != null ? cart.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }
}
