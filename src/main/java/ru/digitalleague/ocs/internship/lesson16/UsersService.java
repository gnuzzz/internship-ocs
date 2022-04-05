package ru.digitalleague.ocs.internship.lesson16;

public class UsersService {

    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User16 createUser(String email, String name) throws MarketException {
        try {
            return usersRepository.createUser(email, name);
        } catch (Exception e) {
            throw new MarketException("Can't create user", e);
        }
    }

    public User16 getUser(String email) throws MarketException {
        try {
            return usersRepository.getUser(email);
        } catch (Exception e) {
            throw new MarketException("Can't get user for " + email, e);
        }
    }
}
