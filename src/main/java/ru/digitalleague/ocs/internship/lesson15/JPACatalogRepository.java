package ru.digitalleague.ocs.internship.lesson15;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityManager;
//import javax.persistence.Id;
//import javax.persistence.Query;

public class JPACatalogRepository {

//    private EntityManager em;
//
//    public JPACatalogRepository(EntityManager em) {
//        this.em = em;
//    }
//
//    public Author createAuthor(String name) {
//        Author author = new Author();
//        author.setName(name);
//        var t = em.getTransaction();
//        t.begin();
//        try {
//            em.persist(author);
//            t.commit();
//        } catch (RuntimeException e) {
//            t.rollback();
//            throw e;
//        }
//        return author;
//    }
//
//    public Author getAuthor(Long id) {
//        return em.find(Author.class, id);
//    }
//
//    public Author getAuthor(String name) {
//        Query query = em.createQuery("select author from Author author where author.name = :name");
//        query.setParameter("name", name);
//        query.setMaxResults(1);
//        query.setHint("org.hibernate.cacheable", true);
//        List<Author> authors = query.getResultList();
//        return authors.isEmpty() ? null : authors.get(0);
//    }
//
//    public List<Author> getAuthors() {
//        Query query = em.createQuery("select author from Author author");
//        return query.getResultList();
//    }
//
//    public boolean updateAuthor(Author author) {
//        em.merge(author);
//        return true;
//    }
//
//    public boolean deleteAuthor(Author author) {
//        em.remove(author);
//        return true;
//    }
//
//    public Category createCategory(String name) {
//        Category category = new Category();
//        category.setName(name);
//        var t = em.getTransaction();
//        t.begin();
//        try {
//            em.persist(category);
//            t.commit();
//        } catch (RuntimeException e) {
//            t.rollback();
//            throw e;
//        }
//        return category;
//    }
//
//    public Category getCategory(Long id) {
//        return em.find(Category.class, id);
//    }
//
//    public Category getCategory(String name) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Category> criteria = cb.createQuery(Category.class);
//        Root<Category> root = criteria.from(Category.class);
//        criteria.select(root);
//        criteria.where(cb.equal(root.get("name"), name));
//        return em.createQuery(criteria).getSingleResult();
//    }
//
//    public List<Category> getCategories() {
//        Query query = em.createQuery("select category from Category category");
//        return query.getResultList();
//    }
//
//    public boolean updateCategory(Category category) {
//        em.merge(category);
//        return true;
//    }
//
//    public boolean deleteCategory(Category category) {
//        em.remove(category);
//        return true;
//    }
//
//    public Book createBook(String title, List<Author> authors, Category category) {
//        Book book = new Book();
//        book.setTitle(title);
//        book.setAuthors(authors);
//        book.setCategory(category);
//        var t = em.getTransaction();
//        t.begin();
//        try {
//            em.persist(book);
//        } catch (RuntimeException e) {
//            t.rollback();
//            throw e;
//        }
//        return book;
//    }
//
//    public Book getBook(Long id) {
//        return em.find(Book.class, id);
//    }
//
//    public Book getBook(String title) {
//        Query query = em.createQuery("select book from Book book where book.title = :title");
//        query.setParameter("title", title);
//        return (Book) query.getSingleResult();
//    }
//
//    public List<Book> getBooks() {
//        Query query = em.createQuery("select book from Book book");
//        return query.getResultList();
//    }
//
//    public boolean updateBook(Book book) {
//        var t = em.getTransaction();
//        t.begin();
//        try {
//            em.merge(book);
//            t.commit();
//        } catch (RuntimeException e) {
//            t.rollback();
//            throw e;
//        }
//        return true;
//    }
//
//    public boolean deleteBook(Book book) {
//        var t = em.getTransaction();
//        t.begin();
//        try {
//            em.remove(book);
//            t.commit();
//        } catch (RuntimeException e) {
//            t.rollback();
//            throw e;
//        }
//        return true;
//    }

}
