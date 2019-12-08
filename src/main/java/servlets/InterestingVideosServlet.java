package servlets;

import UILogic.UserLogic;
import services.UserService;
import services.VideoService;
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
    private VideoService videoService = new VideoService();
    private UserLogic userLogic = new UserLogic();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (userLogic.checkUser(req, resp)) {
          userLogic.authUser(req);
            ArrayList<Video> videos = videoService.getVideosByUserInterests(userLogic.getIdByEmail(req));
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
