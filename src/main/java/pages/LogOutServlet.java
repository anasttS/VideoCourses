package pages;

import UILogic.UICookieLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    UICookieLogic logic = new UICookieLogic();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logic.deleteCookie(req, resp);
       resp.sendRedirect("/main");
    }
}
