package ru.digitalleague.ocs.internship.lesson16;

import java.util.List;

public interface CatalogRepository {
    Author16 createAuthor(String name);

    Author16 getAuthor(Long id);

    Author16 getAuthor(String name);

    List<Pair<Author16, Long>> getAuthorsWithBooksCount();

    List<Author16> getAuthors();

    boolean updateAuthor(Author16 author);

    boolean deleteAuthor(Author16 author);

    Category16 createCategory(String name);

    Category16 getCategory(Long id);

    Category16 getCategory(String name);

    List<Category16> getCategories();

    boolean updateCategory(Category16 category);

    boolean deleteCategory(Category16 category);

    PopularScienceBook16 createPopularScienceBook(String title, List<Author16> authors, Category16 category, String image, String scienceField);

    ScienceFictionBook16 createScienceFictionBook(String title, List<Author16> authors, Category16 category, String image, String genre);

    SatireBook16 createSatireBook(String title, List<Author16> authors, Category16 category, String image);

    Book16 getBook(Long id);

    Book16 getBook(String title);

    List<Book16> getBooksForCategory(Category16 category);

    List<Book16> getBooks();

    boolean updateBook(Book16 book);

    boolean deleteBook(Book16 book);
}
