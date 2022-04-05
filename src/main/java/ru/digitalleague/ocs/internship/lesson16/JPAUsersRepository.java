package ru.digitalleague.ocs.internship.lesson16;

import javax.persistence.EntityManager;

public class JPAUsersRepository implements UsersRepository {

    private EntityManager em;

    public JPAUsersRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User16 createUser(String email, String name) {
        User16 user = new User16(email, name);
        var t = em.getTransaction();
        t.begin();
        try {
            em.persist(user);
            t.commit();
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
        return user;
    }

    @Override
    public User16 getUser(String email) {
        return em.find(User16.class, email);
    }
}
