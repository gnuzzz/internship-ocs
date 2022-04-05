package ru.digitalleague.ocs.internship.lesson16;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JPACatalogRepository implements CatalogRepository {

    private EntityManager em;

    public JPACatalogRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Author16 createAuthor(String name) {
        Author16 author = new Author16();
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

    @Override
    public Author16 getAuthor(Long id) {
        return em.find(Author16.class, id);
    }

    @Override
    public Author16 getAuthor(String name) {
        Query query = em.createQuery("select author from Author16 author where author.name = :name");
        query.setParameter("name", name);
        query.setMaxResults(1);
        query.setHint("org.hibernate.cacheable", true);
        List<Author16> authors = query.getResultList();
        return authors.isEmpty() ? null : authors.get(0);
    }

    @Override
    public List<Pair<Author16, Long>> getAuthorsWithBooksCount() {
        Query query = em.createNativeQuery("select a.*, count.value as books_count from authors a\n" +
                "join (\n" +
                "    select b2a.author_id, count(*) value from books2authors b2a group by b2a.author_id\n" +
                ") count on count.author_id = a.id;\n", AuthorWithBooksCount16.class);
        Stream<Pair<Author16, Long>> result =  query.getResultList().stream()
                .map(it -> new Pair<>(((AuthorWithBooksCount16)it).getAuthor(), ((AuthorWithBooksCount16)it).getBooksCount()));
        return result.collect(Collectors.toList());
    }

    @Override
    public List<Author16> getAuthors() {
        Query query = em.createQuery("select author from Author16 author");
        return query.getResultList();
    }

    @Override
    public boolean updateAuthor(Author16 author) {
        em.merge(author);
        return true;
    }

    @Override
    public boolean deleteAuthor(Author16 author) {
        em.remove(author);
        return true;
    }

    @Override
    public Category16 createCategory(String name) {
        Category16 category = new Category16();
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

    @Override
    public Category16 getCategory(Long id) {
        return em.find(Category16.class, id);
    }

    @Override
    public Category16 getCategory(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category16> criteria = cb.createQuery(Category16.class);
        Root<Category16> root = criteria.from(Category16.class);
        criteria.select(root);
        criteria.where(cb.equal(root.get("name"), name));
        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Category16> getCategories() {
        Query query = em.createQuery("select category from Category16 category");
        return query.getResultList();
    }

    @Override
    public boolean updateCategory(Category16 category) {
        em.merge(category);
        return true;
    }

    @Override
    public boolean deleteCategory(Category16 category) {
        em.remove(category);
        return true;
    }

    @Override
    public PopularScienceBook16 createPopularScienceBook(String title, List<Author16> authors, Category16 category, String image, String scienceField) {
        PopularScienceBook16 book = new PopularScienceBook16();
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

    @Override
    public ScienceFictionBook16 createScienceFictionBook(String title, List<Author16> authors, Category16 category, String image, String genre) {
        ScienceFictionBook16 book = new ScienceFictionBook16();
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

    @Override
    public SatireBook16 createSatireBook(String title, List<Author16> authors, Category16 category, String image) {
        SatireBook16 book = new SatireBook16();
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

    @Override
    public Book16 getBook(Long id) {
        return em.find(Book16.class, id);
    }

    @Override
    public Book16 getBook(String title) {
        Query query = em.createQuery("select book from Book16 book where book.title = :title");
        query.setParameter("title", title);
        return (Book16) query.getSingleResult();
    }

    @Override
    public List<Book16> getBooksForCategory(Category16 category) {
        Query query = em.createQuery("select book from Book16 book where book.category.id = :categoryId");
        query.setParameter("categoryId", category.getId());
        return query.getResultList();
    }

    @Override
    public List<Book16> getBooks() {
        Query query = em.createQuery("select book from Book16 book");
        return query.getResultList();
    }

    @Override
    public boolean updateBook(Book16 book) {
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

    @Override
    public boolean deleteBook(Book16 book) {
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
    static class AuthorWithBooksCount16 extends AbstractAuthor {

        @Column(name = "books_count")
        private Long booksCount;

        public Author16 getAuthor() {
            Author16 author = new Author16(getId(), getName());
            author.setBooks(getBooks());
            return author;
        }

        public Long getBooksCount() {
            return booksCount;
        }
    }

}
