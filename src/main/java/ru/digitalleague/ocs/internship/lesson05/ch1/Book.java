package ru.digitalleague.ocs.internship.lesson05.ch1;

import java.util.ArrayList;
import java.util.List;

public class Book {

//    public static void main(String[] args) {
//        System.out.println("Book.main");
//    }

    public static double vat = 0.2;

    static final List<Book> BOOKS = new ArrayList<>();

    static {
        BOOKS.add(new Book("Дюна", "Френк Герберт", 100));
        BOOKS.add(new Book("Основание", "Айзек Азимов", 200));
    }

    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public static double getVat() {
        return vat;
    }

    public static void setVat(double newVat) {
        vat = newVat;
    }

    public double getTotalPrice() {
        return price + price * vat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
