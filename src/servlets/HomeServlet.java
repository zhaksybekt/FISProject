package servlets;

import kz.zhaxybek.projectbook.db.Book;
import kz.zhaxybek.projectbook.db.DBConnection;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet(value = "/home.html" )
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> books = DBConnection.getBooks();
        request.setAttribute("knigi", books);
        request.getRequestDispatcher("/books.jsp").forward(request, response);

    }
}