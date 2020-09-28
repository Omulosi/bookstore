package web;


import model.Book;
import repository.BookRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet("/book")
public class BookEditorServlet extends HttpServlet {

    @Inject
    private BookRepository bookRepo;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {
            Book book = bookRepo.lookupBookById(id);
            request.setAttribute("book", book);
            request.setAttribute("bookPubDate", dateFormat.format(book.getPubDate()));
        }

        /* Redirect to book-form */
        request.getServletContext().getRequestDispatcher("/book-form.jsp").forward(
                request, response
        );

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String pubDate = request.getParameter("pubDate");

        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            bookRepo.addBook(title, description, price, pubDate);
        } else {
            bookRepo.updateBook(id, title, description, price, pubDate);
        }

        response.sendRedirect(request.getContextPath() + "/book/");
    }
}
