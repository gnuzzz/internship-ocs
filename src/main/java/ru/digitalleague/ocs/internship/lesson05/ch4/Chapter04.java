package ru.digitalleague.ocs.internship.lesson05.ch4;

public class Chapter04 {
    public static void main(String[] args) {
        User.Status s = User.Status.ACTIVE;

        User u1 = new User("First", User.Status.ACTIVE, 0, 0);

        User.Position p = u1.getPosition();

        u1.moveTo(1, 1);
        System.out.println(u1.track);

        System.out.println(p);
    }
}
