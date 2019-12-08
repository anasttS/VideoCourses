package servlets;

import UILogic.ChannelLogic;
import UILogic.UserLogic;
import UILogic.VideoLogic;
import services.ChannelService;
import services.UserService;
import services.VideoService;
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
    private ChannelLogic channelLogic = new ChannelLogic();
    private UserLogic userLogic = new UserLogic();
    private VideoLogic videoLogic = new VideoLogic();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userLogic.authUser(req);
        if (channelLogic.channelIsExist(userLogic.getIdByEmail((req)))) {
            req.setAttribute("nameOfChannel", channelLogic.findNameofChannelByUserId(userLogic.getIdByEmail(req)));
            req.setAttribute("img", channelLogic.findImgofChannelByUserId(userLogic.getIdByEmail(req)));
            req.setAttribute("videos", channelLogic.getVideosByChannelId(userLogic.getChannelIdByEmail((String) req.getSession().getAttribute("current_user"))));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/channelProfile.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/channel");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        videoLogic.sendToAddVideoPage(req, resp);
        videoLogic.sendToVideoPage(req, resp);
    }
}
