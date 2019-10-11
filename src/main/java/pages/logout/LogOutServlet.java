package pages.logout;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cLogin = new Cookie("cookuser", null);
        Cookie cPassword = new Cookie("cookpass", null);
        Cookie cRemember = new Cookie("cookrem", null);
        cLogin.setMaxAge(0);
        cPassword.setMaxAge(0);
        cRemember.setMaxAge(0);
        resp.addCookie(cLogin);
        resp.addCookie(cPassword);
        resp.addCookie(cRemember);
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("/main");
    }
}
