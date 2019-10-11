package pages.register;

import DAO.dao;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao.run();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        String interests = req.getParameter("interests");

        if (req.getParameter("register") != null) {
            if (dao.isContained(email)) {
                req.getRequestDispatcher("/jsp/register2.jsp").forward(req, resp);
            } else {
                dao.save(new User(email, username, password, birthDate, interests));
                resp.sendRedirect("/login");
            }
        }
    }
}
