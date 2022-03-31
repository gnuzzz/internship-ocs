package ru.digitalleague.ocs.internship.lesson15;

public class Book {

    private Long id;
    private String title;
    private Long categoryId;

    public Book(Long id, String title, Long categoryId) {
        this.id = id;
        this.title = title;
        this.categoryId = categoryId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "id: " + id + ", title: " + title + ", categoryId: " + categoryId;
    }
}
