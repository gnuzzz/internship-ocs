package ru.digitalleague.ocs.internship.lesson15;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JPACatalogRepository {

    private EntityManager em;

    public JPACatalogRepository(EntityManager em) {
        this.em = em;
    }

    public Author createAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        var t = em.getTransaction();
        t.begin();
        try {
            em.persist(author);
            t.commit();
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
        return author;
    }

    public Author getAuthor(Long id) {
        return em.find(Author.class, id);
    }

    public Author getAuthor(String name) {
        Query query = em.createQuery("select author from Author author where author.name = :name");
        query.setParameter("name", name);
        query.setMaxResults(1);
        query.setHint("org.hibernate.cacheable", true);
        List<Author> authors = query.getResultList();
        return authors.isEmpty() ? null : authors.get(0);
    }

    public List<Pair<Author, Long>> getAuthorsWithBooksCount() {
        Query query = em.createNativeQuery("select a.*, count.value as books_count from authors a\n" +
                "join (\n" +
                "    select b2a.author_id, count(*) value from books2authors b2a group by b2a.author_id\n" +
                ") count on count.author_id = a.id;\n", AuthorWithBooksCount.class);
        Stream<Pair<Author, Long>> result =  query.getResultList().stream()
                .map(it -> new Pair<>(((AuthorWithBooksCount)it).getAuthor(), ((AuthorWithBooksCount)it).getBooksCount()));
        return result.collect(Collectors.toList());
    }

    public List<Author> getAuthors() {
        Query query = em.createQuery("select author from Author author");
        return query.getResultList();
    }

    public boolean updateAuthor(Author author) {
        em.merge(author);
        return true;
    }

    public boolean deleteAuthor(Author author) {
        em.remove(author);
        return true;
    }

    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        var t = em.getTransaction();
        t.begin();
        try {
            em.persist(category);
            t.commit();
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
        return category;
    }

    public Category getCategory(Long id) {
        return em.find(Category.class, id);
    }

    public Category getCategory(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category> criteria = cb.createQuery(Category.class);
        Root<Category> root = criteria.from(Category.class);
        criteria.select(root);
        criteria.where(cb.equal(root.get("name"), name));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Category> getCategories() {
        Query query = em.createQuery("select category from Category category");
        return query.getResultList();
    }

    public boolean updateCategory(Category category) {
        em.merge(category);
        return true;
    }

    public boolean deleteCategory(Category category) {
        em.remove(category);
        return true;
    }

    public PopularScienceBook createPopularScienceBook(String title, List<Author> authors, Category category, String image, String scienceField) {
        PopularScienceBook book = new PopularScienceBook();
        book.setTitle(title);
        book.setAuthors(authors);
        book.setCategory(category);
        book.setImage(image);
        book.setScienceField(scienceField);
        var t = em.getTransaction();
        t.begin();
        try {
            em.persist(book);
            t.commit();
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
        return book;
    }

    public ScienceFictionBook createScienceFictionBook(String title, List<Author> authors, Category category, String image, String genre) {
        ScienceFictionBook book = new ScienceFictionBook();
        book.setTitle(title);
        book.setAuthors(authors);
        book.setCategory(category);
        book.setImage(image);
        book.setGenre(genre);
        var t = em.getTransaction();
        t.begin();
        try {
            em.persist(book);
            t.commit();
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
        return book;
    }

    public SatireBook createSatireBook(String title, List<Author> authors, Category category, String image) {
        SatireBook book = new SatireBook();
        book.setTitle(title);
        book.setAuthors(authors);
        book.setCategory(category);
        book.setImage(image);
        var t = em.getTransaction();
        t.begin();
        try {
            em.persist(book);
            t.commit();
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
        return book;
    }

    public Book getBook(Long id) {
        return em.find(Book.class, id);
    }

    public Book getBook(String title) {
        Query query = em.createQuery("select book from Book book where book.title = :title");
        query.setParameter("title", title);
        return (Book) query.getSingleResult();
    }

    public List<Book> getBooksForCategory(Category category) {
        Query query = em.createQuery("select book from Book book where book.category.id = :categoryId");
        query.setParameter("categoryId", category.getId());
        return query.getResultList();
    }

    public List<Book> getBooks() {
        Query query = em.createQuery("select book from Book book");
        return query.getResultList();
    }

    public boolean updateBook(Book book) {
        var t = em.getTransaction();
        t.begin();
        try {
            em.merge(book);
            t.commit();
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
        return true;
    }

    public boolean deleteBook(Book book) {
        var t = em.getTransaction();
        t.begin();
        try {
            em.remove(book);
            t.commit();
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        }
        return true;
    }

    @Entity
    static class AuthorWithBooksCount extends AbstractAuthor {

        @Column(name = "books_count")
        private Long booksCount;

        public Author getAuthor() {
            Author author = new Author(getId(), getName());
            author.setBooks(getBooks());
            return author;
        }

        public Long getBooksCount() {
            return booksCount;
        }
    }

}
