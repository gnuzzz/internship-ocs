package ru.digitalleague.ocs.internship.lesson05.ch3;

public class Chapter03_2 {
    public static void main(String[] args) {
//        расширение ссылочного типа
//        Child1 ch1 = new Child1();
//        Parent p = ch1;
//        System.out.println(p.x);
//        System.out.println(p.y);

//        расширение ссылочного типа null-типом
//        Parent p1 = null;

//        сужение ссылочного типа
//        Parent p1 = new Child1();
//        Child1 c1 = (Child1) p1;
//
//        Parent p2 = new Child2();
//        Child1 c2 = (Child1) p2;

//        String s = (String)(Object)p2;

//        Child1 ch1 = (Child1) new Child2();

        Parent p = new Child3();
        System.out.println(p instanceof Child1);
        System.out.println(p instanceof Child3);
        System.out.println(p instanceof Child2);
    }
}
