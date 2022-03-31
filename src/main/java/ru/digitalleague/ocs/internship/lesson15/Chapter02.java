package ru.digitalleague.ocs.internship.lesson15;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Chapter02 {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");

        EntityManager em = factory.createEntityManager();
        JPACatalogRepository repository = new JPACatalogRepository(em);
        JPACatalogService catalog = new JPACatalogService(repository);

//        List<Category> categories = catalog.getAllCategories();
//        for (Category category: categories) {
//            System.out.println(category);
//        }

//        List<Author> authors = catalog.getAllAuthors();
//        for (Author author: authors) {
//            System.out.println(author + ", " + author.getBooks().size());
//        }

//        Category c1 = catalog.getCategory("Сатира");
//        if (c1 == null) {
//            System.out.println("Category not found");
//            return;
//        }
//        System.out.println(c1);
//        List<Book> books = c1.getBooks();
//        for (Book book: books) {
//            System.out.println(book);
//        }

//            Author a1 = catalog.getAuthor("Айзек Азимов");
//            if (a1 == null) {
//                System.out.println("Author not found");
//                return;
//            }
//            List<Book> books = a1.getBooks();
//            for (Book book: books) {
//                System.out.println(book);
//            }

//            Author a1 = catalog.createAuthor("Илья Ильф");
//            Author a2 = catalog.createAuthor("Евгений Петров");
//            Category c1 = catalog.createCategory("Сатира");
//            Book b1 = catalog.createBook("Золотой теленок", Arrays.asList(a1, a2), c1, "gold.png");
//            System.out.println(b1);

//            Author a1 = catalog.getAuthor("Аркадий Стругацкий");
//            Author a2 = catalog.getAuthor("Борис Стругацкий");
//            Category c1 = catalog.getCategory("Фантастика");
//            Book b1 = catalog.createBook("Сказка о тройке", Arrays.asList(a1, a2), c1, "troika.png");
//            System.out.println(b1);

//        List<Pair<Author, Long>> pairs = catalog.getAuthorsWithBooksCount();
//        for (Pair<Author, Long> pair: pairs) {
//            System.out.println(pair.getT1() + ", " + pair.getT2());
//        }

        EntityManager em2 = factory.createEntityManager();
        JPACatalogRepository repository2 = new JPACatalogRepository(em2);
        JPACatalogService catalog2 = new JPACatalogService(repository2);

        Author a1 = catalog.getAuthor("Айзек Азимов");
        System.out.println(a1);
        Author a2 = catalog2.getAuthor("Айзек Азимов");
        System.out.println(a2);

        factory.close();
    }

}
