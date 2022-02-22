package ru.digitalleague.ocs.internship.lesson05.ch1;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Chapter01 {
    public static void main(String[] args) {
        System.out.println("Books count: " + Book.BOOKS.size());
        for (Book book : Book.BOOKS) {
            System.out.println(book.getName() + ", " + book.getAuthor() + ", " + book.getTotalPrice());
        }
    }
}
