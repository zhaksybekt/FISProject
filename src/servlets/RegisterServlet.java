package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

    }
        private static final long serialVersionUID = 1L;

        protected void doPost(HttpServletRequest request,
                              HttpServletResponse response)
                throws ServletException, IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con =
                        DriverManager.
                                getConnection(
                                        "jdbc:mysql://localhost:3306/bitlab",
                                        "root", "root");
                PreparedStatement ps =
                        con.prepareStatement
                                ("INSERT INTO users" +
                                        " (username, password, email) VALUES (?, ?, ?)");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, email);
                ps.executeUpdate();

                response.sendRedirect("login.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

