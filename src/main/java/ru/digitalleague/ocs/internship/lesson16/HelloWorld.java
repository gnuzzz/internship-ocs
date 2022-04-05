package ru.digitalleague.ocs.internship.lesson16;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Program started");
        System.out.println("Hello, world!");
        method("aaa");
        System.out.println("Program stopped");
    }

    public static void method(String s) {
        System.out.println(s.length());
    }
}
