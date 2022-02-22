package ru.digitalleague.ocs.internship.lesson05.ch2;

public class Chapter02_2 {
    public static void main(String[] args) {
        Workstation ws = new Workstation(
                new CPU("i9", 200),
                new Memory("DDR4", 100),
                new HDDStorage("barracuda", 100, 4),
                new Cooler("air", 10)
        );
        Laptop l = new Laptop(
                new CPU("i7", 100),
                new Memory("DDR3", 100),
                new SSDStorage("samsung", 100, "qwerty"),
                new Display("retina", 50)
        );
        System.out.println(ws.getPower());
        System.out.println(l.getPower());
    }
}
