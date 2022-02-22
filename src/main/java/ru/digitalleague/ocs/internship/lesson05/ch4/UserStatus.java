package ru.digitalleague.ocs.internship.lesson05.ch4;

public class UserStatus {
    public static final UserStatus ACTIVE = new UserStatus("active");
    public static final UserStatus BLOCKED = new UserStatus("blocked");

    String name;

    private UserStatus(String name) {
        this.name = name;
    }
}
