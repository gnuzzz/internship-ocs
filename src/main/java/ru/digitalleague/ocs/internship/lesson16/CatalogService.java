package ru.digitalleague.ocs.internship.lesson16;

import java.util.List;

public class CatalogService {

    private CatalogRepository repository;

    public CatalogService(CatalogRepository repository) {
        this.repository = repository;
    }

    public Author16 createAuthor(String name) throws MarketException {
        try {
            return repository.createAuthor(name);
        } catch (Exception e) {
            throw new MarketException("Can't create author", e);
        }
    }

    public Author16 getAuthor(Long id) throws MarketException {
        try {
            return repository.getAuthor(id);
        } catch (Exception e) {
            throw new MarketException("Can't get author with id " + id, e);
        }
    }

    public Author16 getAuthor(String name) throws MarketException {
        try {
            return repository.getAuthor(name);
        } catch (Exception e) {
            throw new MarketException("Can't get author with name " + name, e);
        }
    }

    public List<Author16> getAllAuthors() throws MarketException {
        try {
            return repository.getAuthors();
        } catch (Exception e) {
            throw new MarketException("Can't get all authors", e);
        }
    }

    public List<Author16> getAuthors(Book16 book) throws MarketException {
        return book.getAuthors();
    }

    public List<Pair<Author16, Long>> getAuthorsWithBooksCount() throws MarketException {
        try {
            return repository.getAuthorsWithBooksCount();
        } catch (Exception e) {
            throw new MarketException("Can't get authors with books count ", e);
        }
    }

    public void updateAuthor(Author16 author) throws MarketException {
        try {
            repository.updateAuthor(author);
        } catch (Exception e) {
            throw new MarketException("Can't update author with id " + author.getId(), e);
        }
    }

    public void deleteAuthor(Author16 author) throws MarketException {
        try {
            repository.deleteAuthor(author);
        } catch (Exception e) {
            throw new MarketException("Can't delete author with id " + author.getId(), e);
        }
    }

    public Category16 createCategory(String name) throws MarketException {
        try {
            return repository.createCategory(name);
        } catch (Exception e) {
            throw new MarketException("Can't create category", e);
        }
    }

    public Category16 getCategory(Long id) throws MarketException {
        try {
            return repository.getCategory(id);
        } catch (Exception e) {
            throw new MarketException("Can't get category with id " + id, e);
        }
    }

    public Category16 getCategory(String name) throws MarketException {
        try {
            return repository.getCategory(name);
        } catch (Exception e) {
            throw new MarketException("Can't get category with name " + name, e);
        }
    }

    public List<Category16> getAllCategories() throws MarketException {
        try {
            return repository.getCategories();
        } catch (Exception e) {
            throw new MarketException("Can't get all categories", e);
        }
    }

    public void updateCategory(Category16 category) throws MarketException {
        try {
            repository.updateCategory(category);
        } catch (Exception e) {
            throw new MarketException("Can't update category with id " + category.getId(), e);
        }
    }

    public void deleteCategory(Category16 category) throws MarketException {
        try {
            repository.deleteCategory(category);
        } catch (Exception e) {
            throw new MarketException("Can't delete category with id " + category.getId(), e);
        }
    }

    public PopularScienceBook16 createPopularScienceBook(String title, List<Author16> authors, Category16 category, String image, String scienceField) throws MarketException {
        try {
            PopularScienceBook16 book = repository.createPopularScienceBook(title, authors, category, image, scienceField);
            return book;
        } catch (Exception e) {
            throw new MarketException("Can't create book", e);
        }
    }

    public ScienceFictionBook16 createScienceFictionBook(String title, List<Author16> authors, Category16 category, String image, String genre) throws MarketException {
        try {
            ScienceFictionBook16 book = repository.createScienceFictionBook(title, authors, category, image, genre);
            return book;
        } catch (Exception e) {
            throw new MarketException("Can't create book", e);
        }
    }

    public SatireBook16 createSatireBook(String title, List<Author16> authors, Category16 category, String image) throws MarketException {
        try {
            SatireBook16 book = repository.createSatireBook(title, authors, category, image);
            return book;
        } catch (Exception e) {
            throw new MarketException("Can't create book", e);
        }
    }

    public Book16 getBook(Long id) throws MarketException {
        try {
            return repository.getBook(id);
        } catch (Exception e) {
            throw new MarketException("Can't get book with id " + id, e);
        }
    }

    public Book16 getBook(String title) throws MarketException {
        try {
            return repository.getBook(title);
        } catch (Exception e) {
            throw new MarketException("Can't get book with title " + title, e);
        }
    }

    public List<Book16> getAllBooks() throws MarketException {
        try {
            return repository.getBooks();
        } catch (Exception e) {
            throw new MarketException("Can't get all books", e);
        }
    }

    public void updateBook(Book16 book) throws MarketException {
        try {
            repository.updateBook(book);
        } catch (Exception e) {
            throw new MarketException("Can't update book with id " + book.getId());
        }
    }

    public void deleteBook(Book16 book) throws MarketException {
        try {
            repository.deleteBook(book);
        } catch (Exception e) {
            throw new MarketException("Can't delete book with id" + book.getId(), e);
        }
    }

}
