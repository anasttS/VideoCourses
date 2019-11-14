package pages;

import BL.UserService;
import BL.VideoService;
import UILogic.ForNavbar;
import models.Video;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/videos")
public class InterestingVideosServlet extends HttpServlet {
    private ForNavbar forNavbar = new ForNavbar();
    private VideoService videoService = new VideoService();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("current_user") != null) {
            forNavbar.authUser(req);
            ArrayList<Video> videos = videoService.getVideosByUserInterests(userService.getIdByEmail((String) req.getSession().getAttribute("current_user")));
            req.setAttribute("videos", videos);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/videosPage.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/main");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      videoService.sendToVideoPageByWatchButton(req, resp);
    }
}
