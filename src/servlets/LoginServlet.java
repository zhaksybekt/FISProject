package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.zhaxybek.projectbook.db.DBConnectionLogin;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
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
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                conn = DBConnectionLogin.getConnection();
                pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                rs = pstmt.executeQuery();
                if (username.equals("admin") && password.equals("admin1")) {
                    response.sendRedirect("home.html");
                    return;
                }
                if (rs.next()) {
                    request.getSession().setAttribute("username", username);
                    response.sendRedirect("not.html");
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                } else {
                    response.sendRedirect("login.jsp");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        DBConnectionLogin.closeConnection(conn);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

