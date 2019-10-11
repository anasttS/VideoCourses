package pages.login;

import DAO.dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        //int password = req.getParameter("password").hashCode();
        String user = (String) session.getAttribute("currnet_user");
        if(user != null) {
            resp.sendRedirect("/main");
        }
        if (dao.isExist(email, password)) {
            if (req.getParameter("rememberMe") != null) {
                Cookie cLogin = new Cookie("cookemail", email );
                Cookie cPassword = new Cookie("cookpass", password);
                cLogin.setMaxAge(60);
                cPassword.setMaxAge(60);
                resp.addCookie(cLogin);
                resp.addCookie(cPassword);
            }
            session.setAttribute("current_user", email);
            resp.sendRedirect("/main");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/login2.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
