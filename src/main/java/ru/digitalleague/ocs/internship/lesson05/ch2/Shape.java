package ru.digitalleague.ocs.internship.lesson05.ch2;

public class Shape {
    private double x;
    private double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void moveTo(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public double calculateArea() {
        return -1;
    }

    protected void printPosition() {
        printX();
        printY();
    }

    private void printX() {
        System.out.println(x);
    }

    private void printY() {
        System.out.println(y);
    }
}
