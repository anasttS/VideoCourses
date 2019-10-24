package BL;

import DAO.UserDAO;
import UILogic.UICookieLogic;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class UserService {

    UserDAO dao = new UserDAO();
    UICookieLogic logic = new UICookieLogic();

    public String getUsernameByEmail(String email) {
        User user = dao.getUserByEmail(email);
        return user.getUsername();
    }

    public LocalDate getbirthDateByEmail(String email) {
        User user = dao.getUserByEmail(email);
        return user.getBirthDate();
    }

    public void login(String email, String password, HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (dao.userIsExist(email, password.hashCode())) {
                logic.addCookie(req, resp, email);
                resp.sendRedirect("/profile");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/login2.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void register(String email, int password, String username, LocalDate birthDate, String interests, HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (req.getParameter("register") != null) {
                if (dao.emailIsContained(email)) {
                    req.getRequestDispatcher("/jsp/register2.jsp").forward(req, resp);
                } else {
                    dao.saveUser(new User(email, username, password, birthDate, interests));
                    resp.sendRedirect("/login");
                }
            }
        } catch (IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (req.getParameter("save") != null){
                dao.updateData(req.getParameter("username"), LocalDate.parse(req.getParameter("birthDate")), (String) req.getSession().getAttribute("current_user"));
                resp.sendRedirect("/profile");
            }
        } catch (IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }

    public  void delete(HttpServletRequest req, HttpServletResponse resp){
        if (req.getParameter("delete") != null){
            String user = (String) req.getSession().getAttribute("current_user");
            int id = dao.findIDofUser(user);
            dao.delete(id);
            logic.deleteCookie(req, resp);
            try {
                resp.sendRedirect("/main");
            } catch (IOException e) {
                System.out.println();
                throw new IllegalArgumentException();
            }
        }
    }
}
