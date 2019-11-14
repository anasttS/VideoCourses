package pages;

import BL.ChannelService;
import BL.UserService;
import UILogic.ForNavbar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100)
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private ForNavbar forNavbar = new ForNavbar();
    private UserService userService = new UserService();
    private ChannelService channelService = new ChannelService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forNavbar.authUser(req);
        if (req.getSession().getAttribute("current_user") != null) {
            req.setAttribute("email", (String) req.getSession().getAttribute("current_user"));
            req.setAttribute("birthDate", userService.getbirthDateByEmail((String) req.getSession().getAttribute("current_user")) + "");
            req.setAttribute("img", userService.getImgByEmail((String) req.getSession().getAttribute("current_user")));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/profile.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        channelService.sendToCreatingChannel(req, resp);
        userService.edit(req, resp);
        userService.delete(req, resp);
    }
}
