package BL;

import DAO.UserDAO;
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

    UserDAO dao = new UserDAO();
    UICookieLogic logic = new UICookieLogic();

    public int getIdByEmail(String email) {
        try {
            int id = dao.findIDofUser(email);
            return id;
        } catch (NullPointerException e) {
            System.out.println("Exception");
        }
        return 0;
    }

    public String getUsernameByEmail(String email) {
        try {
            User user = dao.getUserByEmail(email);
            return user.getUsername();
        } catch (NullPointerException e) {
            System.out.println("Exception");
        }
        return null;
    }

    public LocalDate getbirthDateByEmail(String email) {
        try {
            User user = dao.getUserByEmail(email);
            return user.getBirthDate();
        } catch (NullPointerException e) {
            System.out.println("Exception");
        }
        return null;
    }
    public String getImgByEmail(String email) {
        try {
            User user = dao.getUserByEmail(email);
            return user.getImg();
        } catch (NullPointerException e) {
            System.out.println("Exception during getImg");
        }
        return null;
    }
    public int getChannelIdByEmail(String email) {
            int channel_id = dao.getChannelIdOfUser(email);
        return channel_id;
    }

    public void login(String email, String password, HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (dao.userIsExist(email, password.hashCode())) {
                logic.addCookie(req, resp, email);
                resp.sendRedirect("/profile");
            } else {
                req.setAttribute("message", "Unknown username/password. Please retry.");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/login.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        int password = req.getParameter("password").hashCode();
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        String interest1 = req.getParameter("Interest1");
        String interest2 = req.getParameter("Interest2");
        String interest3 = req.getParameter("Interest3");
        String interest4 = req.getParameter("Interest4");
        String interest5 = req.getParameter("Interest5");
        String[] interests = {interest1, interest2, interest3, interest4, interest5};
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
                    dao.saveUser(new User(email, username, password, birthDate, Arrays.toString(interests), img));
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
            if (req.getParameter("save") != null) {
                dao.updateData(req.getParameter("username"), LocalDate.parse(req.getParameter("birthDate")), (String) req.getSession().getAttribute("current_user"));
                resp.sendRedirect("/profile");
            }
        } catch (IOException e) {
            System.out.println();
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
                System.out.println();
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
                System.out.println();
                throw new IllegalArgumentException();
            }
        }
    }
}
