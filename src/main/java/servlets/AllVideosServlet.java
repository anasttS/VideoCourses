package servlets;


import UILogic.UserLogic;
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

@WebServlet("/allVideos")
public class AllVideosServlet extends HttpServlet {
   private UserLogic userLogic = new UserLogic();
    private VideoService videoService = new VideoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userLogic.authUser(req);
        ArrayList<Video> videos = videoService.getVideos();
        req.setAttribute("videos", videos);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/videosPage.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       videoService.sendToVideoPageByWatchButton(req, resp);
    }
}
