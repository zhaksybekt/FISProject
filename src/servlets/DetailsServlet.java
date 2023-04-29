package servlets;

import kz.zhaxybek.projectbook.db.Book;
import kz.zhaxybek.projectbook.db.DBConnection;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = -1;
        try{
            id = Integer.parseInt(request.getParameter("book_id"));
        }
        catch (Exception e){
        }
        Book book = DBConnection.getBook(id);
        request.setAttribute(
                "kniga", book);
        request.getRequestDispatcher
                        ("/details.jsp").
                forward(request, response);
    }
}
