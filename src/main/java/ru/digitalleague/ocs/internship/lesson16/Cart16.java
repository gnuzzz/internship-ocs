package ru.digitalleague.ocs.internship.lesson16;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "carts")
public class Cart16 implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
    private List<CartItem16> items = Collections.emptyList();

    @Transient
    private long sum;

    @Transient
    private long vatSum;

    public Cart16() {
    }

    public Cart16(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<CartItem16> getItems() {
        return items;
    }

    public void setItems(List<CartItem16> items) {
        this.items = items;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public long getVatSum() {
        return vatSum;
    }

    public void setVatSum(long vatSum) {
        this.vatSum = vatSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart16 cart = (Cart16) o;

        return id != null ? id.equals(cart.id) : cart.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
