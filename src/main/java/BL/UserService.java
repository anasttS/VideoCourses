package BL;

import DAO.InterestDAO;
import DAO.UserDAO;
import UILogic.HashPassword;
import UILogic.MediaAdd;
import UILogic.UICookieLogic;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class UserService {

    private UserDAO dao = new UserDAO();
    private InterestDAO interestDAO = new InterestDAO();
    private UICookieLogic logic = new UICookieLogic();
    private HashPassword hashPassword = new HashPassword();

    public int getIdByEmail(String email) {
        try {
            int id = dao.findIDofUser(email);
            return id;
        } catch (NullPointerException e) {
            System.out.println("Exception during get id by user's email");
        }
        return 0;
    }

    public String getUsernameByEmail(String email) {
        try {
            User user = dao.getUserByEmail(email);
            return user.getUsername();
        } catch (NullPointerException e) {
            System.out.println("Exception during get username by email");
        }
        return null;
    }

    public LocalDate getbirthDateByEmail(String email) {
        try {
            User user = dao.getUserByEmail(email);
            return user.getBirthDate();
        } catch (NullPointerException e) {
            System.out.println("Exception during get birthDate by email");
        }
        return null;
    }
    public String getImgByEmail(String email) {
        try {
            User user = dao.getUserByEmail(email);
            return user.getImg();
        } catch (NullPointerException e) {
            System.out.println("Exception during getImg by Email ");
        }
        return null;
    }
    public int getChannelIdByEmail(String email) {
        return dao.getChannelIdOfUser(email);
    }

    public void login(String email, String password, HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (dao.userIsExist(email, hashPassword.getHashPassword(password))) {
                logic.addCookie(req, resp, email);
                resp.sendRedirect("/profile");
            } else {
                req.setAttribute("message", "Unknown username/password. Please retry.");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/login.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (IOException | ServletException e) {
            System.out.println("Exception during login");
            throw new IllegalArgumentException();
        }
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordHash = hashPassword.getHashPassword(password);
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));

        MediaAdd m = new MediaAdd();
        String img;
        try {
            img = m.addMedia(req, "fileP");
        } catch (IOException | ServletException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
        try {
            if (req.getParameter("register") != null) {
                if (dao.emailIsContained(email)) {
                    req.setAttribute("message", "This email already exists. Please try again.");
                    req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
                } else {
                    dao.saveUser(new User(email, username, passwordHash, birthDate, img));
                    resp.sendRedirect("/login");
                }
            }
        } catch (IOException | ServletException e2) {
            System.out.println("Exception during register user");
            throw new IllegalArgumentException();
        }
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (req.getParameter("save") != null) {
                dao.updateData(req.getParameter("username"), LocalDate.parse(req.getParameter("birthDate")), (String) req.getSession().getAttribute("current_user"));
                int id_user = getIdByEmail((String) req.getSession().getAttribute("current_user"));
                for (int i = 1; i <= 5; i++) {
                    String interest = req.getParameter("Interest" + i);
                    if (interest != null){
                        interestDAO.addInterest(id_user, interest);
                    } else {
                        interestDAO.deleteInterest(id_user, interest);
                    }

                }

                resp.sendRedirect("/profile");
            }
        } catch (IOException e) {
            System.out.println("Exception during edit profile");
            throw new IllegalArgumentException();
        }
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("delete") != null) {
            String user = (String) req.getSession().getAttribute("current_user");
            int id = getIdByEmail(user);
            dao.delete(id);
            logic.deleteCookie(req, resp);
            try {
                resp.sendRedirect("/main");
            } catch (IOException e) {
                System.out.println("Exception during delete account");
                throw new IllegalArgumentException();
            }
        }
    }

    public void addPhoto(HttpServletRequest req, HttpServletResponse resp){
        if (req.getParameter("addPhoto") != null) {
            String email = (String) req.getSession().getAttribute("current_user");
            MediaAdd m = new MediaAdd();
            String img = null;
            try {
                img = m.addMedia(req, "fileP");
            } catch (IOException | ServletException e) {
                System.out.println();
                throw new IllegalArgumentException();
            }
            dao.addImg(img, email);
            try {
                resp.sendRedirect("/profile");
            } catch (IOException e) {
                System.out.println("Exception during add user photo");
                throw new IllegalArgumentException();
            }
        }
    }
}
