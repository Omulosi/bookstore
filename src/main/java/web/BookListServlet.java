package web;

import model.Book;
import repository.BookRepository;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book/")
public class BookListServlet extends HttpServlet {

    @Inject
    private BookRepository bookRepo;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> books = bookRepo.listBooks();
        request.setAttribute("books", books);
        request.getServletContext().getRequestDispatcher("/book-list.jsp")
                .forward(request, response);
    }
}
