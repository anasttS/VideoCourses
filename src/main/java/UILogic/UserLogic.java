package UILogic;

import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;

public class UserLogic {
    private UserService userService = new UserService();
    private UICookieLogic uiCookieLogic = new UICookieLogic();


    public void login(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            if (userService.userIsExist(email, getHashPassword(password))) {
                uiCookieLogic.addCookie(req, resp, email);
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
        String password2 = req.getParameter("passwordRepeat");
        String passwordHash = getHashPassword(password);
        String passwordHash2 = getHashPassword(password2);
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
                if (userService.emailIsContained(email)) {
                    req.setAttribute("message", "This email already exists. Please try again.");
                    req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
                } else {
                    if (!passwordHash.equals(passwordHash2)) {
                        req.setAttribute("message", "Entered passwords are not the same.");
                        req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
                    } else {
                        userService.saveUser(email, username, passwordHash, birthDate, img);
                        resp.sendRedirect("/login");
                    }
                }
            }
        } catch (IOException | ServletException e2) {
            System.out.println("Exception during register user");
            throw new IllegalArgumentException();
        }
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) {
        int id_user = userService.getIdByEmail((String) req.getSession().getAttribute("current_user"));
        ArrayList<String> interests = new ArrayList<>();
        String username = req.getParameter("username");
        LocalDate date = LocalDate.parse(req.getParameter("birthDate"));
        String email = (String) req.getSession().getAttribute("current_user");
        try {
            if (req.getParameter("save") != null) {
                userService.updateData(username, date, email);
                for (int i = 1; i < 6; i++) {
                    String interest = req.getParameter("Interest" + i);
                    interests.add(interest);
                }
                userService.editInterests(interests, id_user);
                resp.sendRedirect("/profile");
            }
        } catch (IOException e) {
            System.out.println("Exception during edit profile");
            throw new IllegalArgumentException();
        }
    }

    public void authUser(HttpServletRequest req){
        req.setAttribute("auth", req.getSession().getAttribute("current_user"));
        req.setAttribute("username", userService.getUsernameByEmail((String) req.getSession().getAttribute("current_user")));
    }

    public boolean checkUser(HttpServletRequest req, HttpServletResponse resp){
        return req.getSession().getAttribute("current_user") != null || UICookieLogic.checkCookie(req);

    }

    public void setProfileAttributes(HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("email", (String) req.getSession().getAttribute("current_user"));
        req.setAttribute("AllInterests", userService.getInterests());
        req.setAttribute("interests", userService.findInterestOfUser(userService.getIdByEmail((String) req.getSession().getAttribute("current_user"))));
        req.setAttribute("birthDate", userService.getbirthDateByEmail((String) req.getSession().getAttribute("current_user")) + "");
        req.setAttribute("img", userService.getImgByEmail((String) req.getSession().getAttribute("current_user")));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/profile.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }

    public Integer getIdByEmail(HttpServletRequest req){
        String email = (String) req.getSession().getAttribute("current_user");
        return  userService.getIdByEmail(email);
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp){
        uiCookieLogic.deleteCookie(req, resp);
        try {
            resp.sendRedirect("/main");
        } catch (IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }

    public int getChannelIdByEmail(String email) {
        return userService.getChannelIdByEmail(email);
    }

    private String getHashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            byte[] mdbytes = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < mdbytes.length; j++) {
                String s = Integer.toHexString(0xff & mdbytes[j]);
                s = (s.length() == 1) ? "0" + s : s;
                sb.append(s);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
            return null;
        }
    }


}
