package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.zhaxybek.projectbook.db.DBConnectionItem;
import kz.zhaxybek.projectbook.db.Items;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/not.html")
public class HomeItemServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Items> items = DBConnectionItem.getItems();
        request.setAttribute("itemsss", items);
        request.getRequestDispatcher("/user.jsp").forward(request, response);
    }}