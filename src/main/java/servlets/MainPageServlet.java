package servlets;

import UILogic.ForNavbar;
import UILogic.UserLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/main")
public class MainPageServlet extends HttpServlet {
    private UserLogic userLogic = new UserLogic();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userLogic.authUser(req);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/mainPage.jsp");
        dispatcher.forward(req, resp);
    }

}
