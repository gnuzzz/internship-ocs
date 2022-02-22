package ru.digitalleague.ocs.internship.lesson05.ch3;

public class Chapter03_1 {
    public static void main(String[] args) {
        var a = (2*4)/10.0*2;
        byte b1 = 1;
        byte b2 = 2;
        byte b = (byte)(b1 + b2);

//        byte b = 123;
//        int i = b; //неявное преобразование

//        тождественное преобразование
//        int a = (int) 11;

//        расширение примитивного типа
//        byte b = 123;
//        int i = b;

//        System.out.println(Short.MIN_VALUE);
//        System.out.println(Character.MIN_VALUE);
//        System.out.println(Character.MAX_VALUE;

//        short s = -123;
//        char c = (char)s;
//        int i = c;
//        System.out.println(i);
//        i = s;
//        System.out.println(i);

//        искажения при расширении
//        long a = 111111111111L;
//        float f = a;
//        a = (long) f;
//        System.out.println(a);

//        сужение примитивного типа
//        short sh = 257;
//        short sh = 385;
//        System.out.println(Integer.toBinaryString(sh));
//        byte b = (byte) sh;
//        System.out.println(b);

//        сужение вещественного типа к целочисленному
        float fmin = Float.NEGATIVE_INFINITY;
        float fmax = Float.POSITIVE_INFINITY;
        System.out.println("long: " + (long)fmin + ".." + (long) fmax);
        System.out.println("int: " + (int)fmin + ".." + (int)fmax);
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("short: " + (short)fmin + ".." + (short)fmax);
        System.out.println("char: " + (int)(char)fmin + ".." + (int)(char)fmax);
        System.out.println("byte: " + (byte)fmin + ".." + (byte)fmax);
    }

}
