package pages;

import BL.UserService;
import UILogic.ForNavbar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/main")
public class MainPageServlet extends HttpServlet {
    private ForNavbar forNavbar = new ForNavbar();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forNavbar.authUser(req);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/mainPage.jsp");
        dispatcher.forward(req, resp);
    }

}
