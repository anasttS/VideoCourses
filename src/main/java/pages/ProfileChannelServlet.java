package pages;

import BL.ChannelService;
import BL.UserService;
import BL.VideoService;
import UILogic.ForNavbar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/channelProfile")
public class ProfileChannelServlet extends HttpServlet {
    private ForNavbar forNavbar = new ForNavbar();
    private ChannelService channelService = new ChannelService();
    private UserService userService = new UserService();
    private VideoService videoService = new VideoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forNavbar.authUser(req);
        if (channelService.channelIsExist(userService.getIdByEmail((String) req.getSession().getAttribute("current_user")))) {
            req.setAttribute("nameOfChannel", channelService.findNameofChannelByUserId(userService.getIdByEmail((String) req.getSession().getAttribute("current_user"))));
            req.setAttribute("img", channelService.findImgofChannelByUserId(userService.getIdByEmail((String) req.getSession().getAttribute("current_user"))));
            req.setAttribute("videos", channelService.getVideosByChannelId(userService.getChannelIdByEmail((String) req.getSession().getAttribute("current_user"))));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/channelProfile.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/channel");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        videoService.sendToAddVideoPage(req, resp);
        videoService.sendToVideoPage(req, resp);
    }
}
