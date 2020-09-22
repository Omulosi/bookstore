package repository;

import model.Book;

import java.util.List;

public interface BookRepository {

    Book lookupBookById (String id);

    void addBook(String title, String description,
                 String price, String pubDate);

    void updateBook(String id, String title,
                    String description, String price, String pubDate);

    void removeBook(String id);


    List<Book> listBooks();
}
