package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.zhaxybek.projectbook.db.Book;
import kz.zhaxybek.projectbook.db.DBConnection;
import kz.zhaxybek.projectbook.db.DBConnectionItem;
import kz.zhaxybek.projectbook.db.Items;

import java.io.IOException;

@WebServlet( value = "/add-critique")
public class AddCritiqueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        Items items=new Items();
        if (name != null) {
            items.setName(name.trim());
        }
        if (description != null) {
            items.setDescription(description.trim());
        }
        if (price != null) {
            double itemPrice = Double.parseDouble(price.trim());
            items.setPrice(itemPrice);
        }
        DBConnectionItem.addCritique(items);
        response.sendRedirect("not.html");

    }
}
