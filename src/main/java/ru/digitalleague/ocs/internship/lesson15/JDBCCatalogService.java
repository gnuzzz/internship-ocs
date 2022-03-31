package ru.digitalleague.ocs.internship.lesson15;

import java.sql.SQLException;
import java.util.List;

public class JDBCCatalogService {

//    private JDBCCatalogRepository repository;
//
//    public JDBCCatalogService(JDBCCatalogRepository repository) {
//        this.repository = repository;
//    }
//
//    public Author createAuthor(String name) throws CatalogException {
//        try {
//            return repository.createAuthor(name);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't create author", e);
//        }
//    }
//
//    public Author getAuthor(Long id) throws CatalogException {
//        try {
//            return repository.getAuthor(id);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't get author with id " + id, e);
//        }
//    }
//
//    public Author getAuthor(String name) throws CatalogException {
//        try {
//            return repository.getAuthor(name);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't get author with name " + name, e);
//        }
//    }
//
//    public List<Author> getAllAuthors() throws CatalogException {
//        try {
//            return repository.getAuthors();
//        } catch (SQLException e) {
//            throw new CatalogException("Can't get all authors", e);
//        }
//    }
//
//    public List<Author> getAuthors(Book book) throws CatalogException {
//        try {
//            return repository.getAuthors(book);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't get authors for book " + book.getId(), e);
//        }
//    }
//
//    public void updateAuthor(Author author) throws CatalogException {
//        try {
//            repository.updateAuthor(author);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't update author with id " + author.getId(), e);
//        }
//    }
//
//    public void deleteAuthor(Author author) throws CatalogException {
//        try {
//            repository.deleteAuthor(author);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't delete author with id " + author.getId(), e);
//        }
//    }
//
//    public Category createCategory(String name) throws CatalogException {
//        try {
//            return repository.createCategory(name);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't create category", e);
//        }
//    }
//
//    public Category getCategory(Long id) throws CatalogException {
//        try {
//            return repository.getCategory(id);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't get category with id " + id, e);
//        }
//    }
//
//    public Category getCategory(String name) throws CatalogException {
//        try {
//            return repository.getCategory(name);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't get category with name " + name, e);
//        }
//    }
//
//    public List<Category> getAllCategories() throws CatalogException {
//        try {
//            return repository.getCategories();
//        } catch (SQLException e) {
//            throw new CatalogException("Can't get all categories", e);
//        }
//    }
//
//    public void updateCategory(Category category) throws CatalogException {
//        try {
//            repository.updateCategory(category);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't update category with id " + category.getId(), e);
//        }
//    }
//
//    public void deleteCategory(Category category) throws CatalogException {
//        try {
//            repository.deleteCategory(category);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't delete category with id " + category.getId(), e);
//        }
//    }
//
//    public Book createBook(String title, List<Author> authors, Category category, String image) throws CatalogException {
//        try {
//            Book book = repository.createBook(title, authors, category, image);
//            return book;
//        } catch (SQLException e) {
//            throw new CatalogException("Can't create book", e);
//        }
//    }
//
//    public Book getBook(Long id) throws CatalogException {
//        try {
//            return repository.getBook(id);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't get book with id " + id, e);
//        }
//    }
//
//    public Book getBook(String title) throws CatalogException {
//        try {
//            return repository.getBook(title);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't get book with title " + title, e);
//        }
//    }
//
//    public List<Book> getAllBooks() throws CatalogException {
//        try {
//            return repository.getBooks();
//        } catch (SQLException e) {
//            throw new CatalogException("Can't get all books", e);
//        }
//    }
//
//    public List<Book> getBooks(Author author) throws CatalogException {
//        try {
//            return repository.getBooks(author);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't get books for author " + author.getId(), e);
//        }
//    }
//
//    public List<Book> getBooks(Category category) throws CatalogException {
//        try {
//            return repository.getBooks(category);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't get books for category " + category.getId(), e);
//        }
//    }
//
//    public void updateBook(Book book) throws CatalogException {
//        try {
//            repository.updateBook(book);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't update book with id " + book.getId());
//        }
//    }
//
//    public void deleteBook(Book book) throws CatalogException {
//        try {
//            repository.deleteBook(book);
//        } catch (SQLException e) {
//            throw new CatalogException("Can't delete book with id" + book.getId(), e);
//        }
//    }

}
