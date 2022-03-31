package ru.digitalleague.ocs.internship.lesson15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCCatalogRepository {

    private Connection conn;

    public JDBCCatalogRepository(Connection conn) {
        this.conn = conn;
    }

    public Author createAuthor(String name) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("insert into authors (name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, name);
            st.executeUpdate();
            try (ResultSet rs = st.getGeneratedKeys()) {
                if (rs.next()) {
                    Long id = rs.getLong(1);
                    Author author = new Author(id, name);
                    return author;
                } else {
                    return null;
                }
            }
        }
    }

    public Author getAuthor(Long id) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("select id, name from authors where id = ?")) {
            st.setLong(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Author author = readAuthor(rs);
                    return author;
                } else {
                    return null;
                }
            }
        }
    }

    public Author getAuthor(String name) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("select id, name from authors where name = ?")) {
            st.setString(1, name);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Author author = readAuthor(rs);
                    return author;
                } else {
                    return null;
                }
            }
        }
    }

    public List<Author> getAuthors() throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("select id, name from authors")) {
            try (ResultSet rs = st.executeQuery()) {
                List<Author> authors = new ArrayList<>();
                for (; rs.next(); ) {
                    Author author = readAuthor(rs);
                    authors.add(author);
                }
                return authors;
            }
        }
    }

    public List<Author> getAuthors(Book book) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("select id, name from authors a join books2authors b2a on b2a.book_id = a.id where b2a.book_id = ?")) {
            st.setLong(1, book.getId());
            try (ResultSet rs = st.executeQuery()) {
                List<Author> authors = new ArrayList<>();
                for (; rs.next(); ) {
                    Author author = readAuthor(rs);
                    authors.add(author);
                }
                return authors;
            }
        }
    }

    public boolean updateAuthor(Author author) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("update authors set name = ? where id = ?")) {
            st.setString(1, author.getName());
            st.setLong(2, author.getId());
            return st.executeUpdate() > 0;
        }
    }

    public boolean deleteAuthor(Author author) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("delete from authors where id = ?")) {
            st.setLong(1, author.getId());
            return st.executeUpdate() > 0;
        }
    }

    public Category createCategory(String name) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("insert into categories (name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, name);
            st.executeUpdate();
            try (ResultSet rs = st.getGeneratedKeys()) {
                if (rs.next()) {
                    Long id = rs.getLong(1);
                    Category category = new Category(id, name);
                    return category;
                } else {
                    return null;
                }
            }
        }
    }

    public Category getCategory(Long id) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("select id, name from categories where id = ?")) {
            st.setLong(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Category category = readCategory(rs);
                    return category;
                } else {
                    return null;
                }
            }
        }
    }

    public Category getCategory(String name) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("select id, name from categories where name = ?")) {
            st.setString(1, name);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Category category = readCategory(rs);
                    return category;
                } else {
                    return null;
                }
            }
        }
    }

    public List<Category> getCategories() throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("select id, name from categories")) {
            try (ResultSet rs = st.executeQuery()) {
                List<Category> categories = new ArrayList<>();
                for (; rs.next(); ) {
                    Category category = readCategory(rs);
                    categories.add(category);
                }
                return categories;
            }
        }
    }

    public boolean updateCategory(Category category) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("update categories set name = ? where id = ?")) {
            st.setString(1, category.getName());
            st.setLong(2, category.getId());
            return st.executeUpdate() > 0;
        }
    }

    public boolean deleteCategory(Category category) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("delete from categories where id = ?")) {
            st.setLong(1, category.getId());
            return st.executeUpdate() > 0;
        }
    }

    public Book createBook(String title, List<Author> authors, Category category) throws SQLException {
        try {
            Book book;
            try (PreparedStatement st = conn.prepareStatement("insert into books (title, category_id) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                conn.setAutoCommit(false);
                st.setString(1, title);
                st.setLong(2, category.getId());
                st.executeUpdate();
                try (ResultSet rs = st.getGeneratedKeys()) {
                    if (rs.next()) {
                        Long id = rs.getLong(1);
                        book = new Book(id, title, category.getId());
                    } else {
                        conn.rollback();
                        return null;
                    }
                }
            }
            for (Author author : authors) {
                try (PreparedStatement st = conn.prepareStatement("insert into books2authors (book_id, author_id) values (?, ?)")) {
                    st.setLong(1, book.getId());
                    st.setLong(2, author.getId());
                    st.executeUpdate();
                }
            }
            conn.commit();
            return book;
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }

    }

    public Book getBook(Long id) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("select id, title, category_id from books where id = ?")) {
            st.setLong(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Book book = readBook(rs);
                    return book;
                } else {
                    return null;
                }
            }
        }
    }

    public Book getBook(String title) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("select id, title, category_id from books where title = ?")) {
            st.setString(1, title);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Book book = readBook(rs);
                    return book;
                } else {
                    return null;
                }
            }
        }
    }

    public List<Book> getBooks() throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("select id, title, category_id from books")) {
            try (ResultSet rs = st.executeQuery()) {
                List<Book> books = new ArrayList<>();
                for (; rs.next(); ) {
                    Book book = readBook(rs);
                    books.add(book);
                }
                return books;
            }
        }
    }

    public List<Book> getBooks(Category category) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("select id, title, category_id from books where category_id = ?")) {
            st.setLong(1, category.getId());
            try (ResultSet rs = st.executeQuery()) {
                List<Book> books = new ArrayList<>();
                for (; rs.next(); ) {
                    Book book = readBook(rs);
                    books.add(book);
                }
                return books;
            }
        }
    }

    public List<Book> getBooks(Author author) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("select id, title, category_id from books b join books2authors b2a on b2a.book_id = b.id where b2a.author_id = ?")) {
            st.setLong(1, author.getId());
            try (ResultSet rs = st.executeQuery()) {
                List<Book> books = new ArrayList<>();
                for (; rs.next(); ) {
                    Book book = readBook(rs);
                    books.add(book);
                }
                return books;
            }
        }
    }

    public boolean updateBook(Book book) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("update books set title = ?, category_id = ? where id = ?")) {
            st.setString(1, book.getTitle());
            st.setLong(2, book.getCategoryId());
            st.setLong(3, book.getId());
            return st.executeUpdate() > 0;
        }
    }

    public boolean deleteBook(Book book) throws SQLException {
        try {
            conn.setAutoCommit(false);
            try (PreparedStatement st = conn.prepareStatement("delete from books2authors where book_id = ?")) {
                st.setLong(1, book.getId());
                st.executeUpdate();
            }
            try (PreparedStatement st = conn.prepareStatement("delete from books where id = ?")) {
                st.setLong(1, book.getId());
                int booksDeleted = st.executeUpdate();
                conn.commit();
                return booksDeleted > 0;
            }
        } finally {
            conn.setAutoCommit(true);
        }
    }

    private Author readAuthor(ResultSet rs) throws SQLException {
        Author author = new Author(rs.getLong("id"), rs.getString("name"));
        return author;
    }

    private Category readCategory(ResultSet rs) throws SQLException {
        Category category = new Category(rs.getLong("id"), rs.getString("name"));
        return category;
    }

    private Book readBook(ResultSet rs) throws SQLException {
        Book book = new Book(rs.getLong("id"), rs.getString("title"), rs.getLong("category_id"));
        return book;
    }
    
}
