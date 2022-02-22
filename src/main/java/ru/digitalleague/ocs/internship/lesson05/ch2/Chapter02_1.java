package ru.digitalleague.ocs.internship.lesson05.ch2;

public class Chapter02_1 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(1, 2, 10, 20);
        Circle c = new Circle(3, 4, 40);
        System.out.println(r.calculateArea());
        System.out.println(c.calculateArea());
    }
}
