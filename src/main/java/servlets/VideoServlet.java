package servlets;

import UILogic.*;
import services.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/video")
public class VideoServlet extends HttpServlet {
    private NoteLogic noteLogic = new NoteLogic();
    private VideoLogic videoLogic = new VideoLogic();
    private CommentsLogic commentsLogic = new CommentsLogic();
    private ChannelLogic channelLogic = new ChannelLogic();
    private UserLogic userLogic = new UserLogic();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     userLogic.authUser(req);
        if (userLogic.checkUser(req, resp)) {
            req.setAttribute("video", videoLogic.findVideoById(Integer.parseInt(req.getParameter("id"))));
            req.setAttribute("videos7", videoLogic.get7Videos());
            req.setAttribute("comments", commentsLogic.getComments(Integer.parseInt(req.getParameter("id"))));
            req.setAttribute("imgOfChannel", channelLogic.findImgOfChannelByVideoId(Integer.parseInt(req.getParameter("id"))));
            req.setAttribute("nameOfChannel", channelLogic.findNameofChannelByIdVideo(Integer.parseInt(req.getParameter("id"))));
            videoLogic.increaseViews(Integer.parseInt(req.getParameter("id")));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/video.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        videoLogic.increaseLikes(Integer.parseInt(req.getParameter("id")), req, resp);
        commentsLogic.sendComment(req, resp);
        noteLogic.saveNote(req, resp);
    }


}
