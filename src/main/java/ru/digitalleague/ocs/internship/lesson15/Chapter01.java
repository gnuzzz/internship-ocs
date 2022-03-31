package ru.digitalleague.ocs.internship.lesson15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;

public class Chapter01 {

    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
//            JDBCCatalogRepository repository = new JDBCCatalogRepository(conn);
//            JDBCCatalogService catalog = new JDBCCatalogService(repository);

//            List<Category> categories = catalog.getAllCategories();
//            for (Category category: categories) {
//                System.out.println(category);
//            }

//            List<Author> authors = catalog.getAllAuthors();
//            for (Author author: authors) {
//                System.out.println(author);
//            }

//            Category c1 = catalog.getCategory("Фантастика");
//            if (c1 == null) {
//                System.out.println("Category not found");
//                return;
//            }
//            List<Book> books = catalog.getBooks(c1);
//            for (Book book: books) {
//                System.out.println(book);
//            }

//            Author a1 = catalog.getAuthor("Айзек Азимов");
//            if (a1 == null) {
//                System.out.println("Author not found");
//                return;
//            }
//            List<Book> books = catalog.getBooks(a1);
//            for (Book book: books) {
//                System.out.println(book);
//            }

//            Author a1 = catalog.createAuthor("Аркадий Стругацкий");
//            Author a2 = catalog.createAuthor("Борис Стругацкий");
//            Category c1 = catalog.getCategory("Фантастика");
//            Book b1 = catalog.createBook("Понедельник начинается в субботу", Arrays.asList(a1, a2), c1);
//            System.out.println(b1);

//            Author a1 = catalog.getAuthor("Аркадий Стругацкий");
//            Author a2 = catalog.getAuthor("Борис Стругацкий");
//            Category c1 = catalog.getCategory("Фантастика");
//            Book b1 = catalog.createBook("Сказка о тройке", Arrays.asList(a1, a2), c1, "troika.png");
//            System.out.println(b1);
        }
    }

}
