package repository;

import model.Book;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This class simulates access to the database
 *
 * ApplicationScoped specifies that a bean is application scoped.
 * Scoping defines a lifecycle for how long an object will be around.
 * ApplicationScoped means it will be around for the complete lifecycle
 * of the Web Application
 */
@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private int count;
    private Map<String, Book> idToBookMap = new HashMap<String, Book>();

    public BookRepositoryImpl() {
        synchronized (this) {
            books(
                    book("War and Peace", "blah blah blah", "5.50", "5/29/1970"),
                    book("Pride and Prejudice", "blah blah blah", "5.50", "5/29/1960"),
                    book("book1", "blah blah blah", "5.50", "5/29/1960"),
                    book("book2", "blah blah blah", "5.50", "5/29/1960"),
                    book("book3", "blah blah blah", "5.50", "5/29/1960"),
                    book("book4", "blah blah blah", "5.50", "5/29/1960"),
                    book("book5", "blah blah blah", "5.50", "5/29/1960"),
                    book("book6", "blah blah blah", "5.50", "5/29/1960"),
                    book("book7", "blah blah blah", "5.50", "5/29/1960"),
                    book("book8", "blah blah blah", "5.50", "5/29/1960"),
                    book("book9", "blah blah blah", "5.50", "5/29/1960"),
                    book("Java for dummies", "blah blah blah", "1.99", "5/29/1960")
            );
        }
    }

    private Book book(String title, String description, String aPrice,
                      String aPubDate)  {

        Date pubDate = null;
        BigDecimal price = null;

        try {
            price = new BigDecimal(aPrice);
        }catch (Exception ex) {
        }

        try {
            pubDate = dateFormat.parse(aPubDate);
        }catch (Exception ex) {
        }

        return new Book("" + (count++), title, description, price, pubDate);
    }

    private void books(Book... books) {
        for (Book book : books) {
            doAddBook(book);
        }
    }

    private void doAddBook(Book book) {
        synchronized (this) {
            this.idToBookMap.put(book.getId(), book);
        }
    }

    public Book lookupBookById(String id)  {
        synchronized (this) {
            return this.idToBookMap.get(id).cloneMe();
        }
    }

    public void addBook(String title, String description, String price,
                        String pubDate)  {
        doAddBook(book(title, description, price, pubDate));
    }

    public void updateBook(String id, String title, String description,
                           String price, String pubDate) {
        Book book = book(title, description, price, pubDate);
        synchronized (this) {
            book.setId(id);
            this.idToBookMap.put(id, book);
        }
    }

    private List<Book> doListBooks()  {
        List<Book> books;
        synchronized (this) {

            books = new ArrayList<Book>(this.idToBookMap.size());
            for (Book book : this.idToBookMap.values()) {
                books.add(book.cloneMe());
            }
        }
        return books;
    }

    public List<Book> listBooks () {
        List<Book> books = doListBooks();

        Collections.sort(books, new Comparator<Book>() {
            public int compare(Book bookA, Book bookB) {
                return bookA.getId().compareTo(bookB.getId());
            }
        });

        return books;
    }

    public void removeBook(String id)  {
        synchronized(this) {
            this.idToBookMap.remove(id);
        }
    }

}
