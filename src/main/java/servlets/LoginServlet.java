package servlets;

import UILogic.UserLogic;
import services.UserService;
import UILogic.UICookieLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
     private UserLogic userLogic = new UserLogic();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userLogic.authUser(req);
        if (userLogic.checkUser(req, resp)) {
            resp.sendRedirect("/profile");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/login.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userLogic.login(req, resp);
    }
}
