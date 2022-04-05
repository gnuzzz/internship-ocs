package ru.digitalleague.ocs.internship.lesson16;

public interface UsersRepository {
    User16 createUser(String email, String name);

    User16 getUser(String email);
}
