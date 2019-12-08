package servlets;

import UILogic.UICookieLogic;
import UILogic.UserLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    private UserLogic userLogic = new UserLogic();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      userLogic.logout(req, resp);
    }
}
