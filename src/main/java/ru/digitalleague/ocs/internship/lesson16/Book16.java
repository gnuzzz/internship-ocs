package ru.digitalleague.ocs.internship.lesson16;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Book16 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category16 category;

    @Column(name = "image")
    private String image;

    @Column(name = "year")
    private int year;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "books2authors",
        joinColumns = {@JoinColumn(name = "book_id")},
        inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private List<Author16> authors;

    @Column(name = "price")
    private long price;

    @Column(name = "vat")
    private int vat;

    public Book16() {
    }

    public Book16(Long id, String title, Category16 category, String image, int year, List<Author16> authors, long price, int vat) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.image = image;
        this.year = year;
        this.authors = authors;
        this.price = price;
        this.vat = vat;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category16 getCategory() {
        return category;
    }

    public void setCategory(Category16 category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Author16> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author16> authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book16 book = (Book16) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "id: " + getId() + ", title: " + getTitle() + ", category: " + getCategory().getId() + ", year: " + getYear();
    }
}
