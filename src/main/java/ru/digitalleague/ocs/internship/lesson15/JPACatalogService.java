package ru.digitalleague.ocs.internship.lesson15;

import java.util.List;

public class JPACatalogService {

    private JPACatalogRepository repository;

    public JPACatalogService(JPACatalogRepository repository) {
        this.repository = repository;
    }

//    public Author createAuthor(String name) throws CatalogException {
//        try {
//            return repository.createAuthor(name);
//        } catch (Exception e) {
//            throw new CatalogException("Can't create author", e);
//        }
//    }
//
//    public Author getAuthor(Long id) throws CatalogException {
//        try {
//            return repository.getAuthor(id);
//        } catch (Exception e) {
//            throw new CatalogException("Can't get author with id " + id, e);
//        }
//    }
//
//    public Author getAuthor(String name) throws CatalogException {
//        try {
//            return repository.getAuthor(name);
//        } catch (Exception e) {
//            throw new CatalogException("Can't get author with name " + name, e);
//        }
//    }
//
//    public List<Author> getAllAuthors() throws CatalogException {
//        try {
//            return repository.getAuthors();
//        } catch (Exception e) {
//            throw new CatalogException("Can't get all authors", e);
//        }
//    }
//
//    public List<Author> getAuthors(Book book) throws CatalogException {
//        return book.getAuthors();
//    }
//
//    public void updateAuthor(Author author) throws CatalogException {
//        try {
//            repository.updateAuthor(author);
//        } catch (Exception e) {
//            throw new CatalogException("Can't update author with id " + author.getId(), e);
//        }
//    }
//
//    public void deleteAuthor(Author author) throws CatalogException {
//        try {
//            repository.deleteAuthor(author);
//        } catch (Exception e) {
//            throw new CatalogException("Can't delete author with id " + author.getId(), e);
//        }
//    }
//
//    public Category createCategory(String name) throws CatalogException {
//        try {
//            return repository.createCategory(name);
//        } catch (Exception e) {
//            throw new CatalogException("Can't create category", e);
//        }
//    }
//
//    public Category getCategory(Long id) throws CatalogException {
//        try {
//            return repository.getCategory(id);
//        } catch (Exception e) {
//            throw new CatalogException("Can't get category with id " + id, e);
//        }
//    }
//
//    public Category getCategory(String name) throws CatalogException {
//        try {
//            return repository.getCategory(name);
//        } catch (Exception e) {
//            throw new CatalogException("Can't get category with name " + name, e);
//        }
//    }
//
//    public List<Category> getAllCategories() throws CatalogException {
//        try {
//            return repository.getCategories();
//        } catch (Exception e) {
//            throw new CatalogException("Can't get all categories", e);
//        }
//    }
//
//    public void updateCategory(Category category) throws CatalogException {
//        try {
//            repository.updateCategory(category);
//        } catch (Exception e) {
//            throw new CatalogException("Can't update category with id " + category.getId(), e);
//        }
//    }
//
//    public void deleteCategory(Category category) throws CatalogException {
//        try {
//            repository.deleteCategory(category);
//        } catch (Exception e) {
//            throw new CatalogException("Can't delete category with id " + category.getId(), e);
//        }
//    }
//
//    public Book createBook(String title, List<Author> authors, Category category) throws CatalogException {
//        try {
//            Book book = repository.createBook(title, authors, category);
//            return book;
//        } catch (Exception e) {
//            throw new CatalogException("Can't create book", e);
//        }
//    }
//
//    public Book getBook(Long id) throws CatalogException {
//        try {
//            return repository.getBook(id);
//        } catch (Exception e) {
//            throw new CatalogException("Can't get book with id " + id, e);
//        }
//    }
//
//    public Book getBook(String title) throws CatalogException {
//        try {
//            return repository.getBook(title);
//        } catch (Exception e) {
//            throw new CatalogException("Can't get book with title " + title, e);
//        }
//    }
//
//    public List<Book> getAllBooks() throws CatalogException {
//        try {
//            return repository.getBooks();
//        } catch (Exception e) {
//            throw new CatalogException("Can't get all books", e);
//        }
//    }
//
//    public void updateBook(Book book) throws CatalogException {
//        try {
//            repository.updateBook(book);
//        } catch (Exception e) {
//            throw new CatalogException("Can't update book with id " + book.getId());
//        }
//    }
//
//    public void deleteBook(Book book) throws CatalogException {
//        try {
//            repository.deleteBook(book);
//        } catch (Exception e) {
//            throw new CatalogException("Can't delete book with id" + book.getId(), e);
//        }
//    }

}
