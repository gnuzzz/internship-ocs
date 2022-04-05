package ru.digitalleague.ocs.internship.lesson16;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category16 extends DBEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Book16> books;

    public Category16() {
    }

    public Category16(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book16> getBooks() {
        return books;
    }

    public void setBooks(List<Book16> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "id: " + getId() + ", name: " + getName();
    }
}
