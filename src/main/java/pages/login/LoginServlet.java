package pages.login;

import BL.UserService;
import UILogic.UICookieLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("current_user") != null || UICookieLogic.checkCookie(req)) {
            resp.sendRedirect("/profile");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/login.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        userService.login(email, password, req, resp);
    }
}
