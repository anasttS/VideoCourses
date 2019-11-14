package pages;

import BL.*;
import DAO.NoteDAO;
import DAO.UserDAO;
import UILogic.ForNavbar;
import models.Note;
import models.Video;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

@WebServlet("/video")
public class VideoServlet extends HttpServlet {
    private ForNavbar forNavbar = new ForNavbar();
    private NoteService noteService = new NoteService();
    private UserService userService = new UserService();
    private VideoService videoService = new VideoService();
    private CommentService commentService = new CommentService();
    private ChannelService channelService = new ChannelService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forNavbar.authUser(req);
        if (req.getSession().getAttribute("current_user") != null) {
            req.setAttribute("video", videoService.findVideoById(Integer.parseInt(req.getParameter("id"))));
            req.setAttribute("comments", commentService.getComments(Integer.parseInt(req.getParameter("id"))));
            req.setAttribute("imgOfChannel", channelService.findImgOfChannelByUserId(userService.getIdByEmail((String) req.getSession().getAttribute("current_user"))));
            req.setAttribute("nameOfChannel", channelService.findNameofChannelByUserId(userService.getIdByEmail((String) req.getSession().getAttribute("current_user"))));
            videoService.increaseViews(Integer.parseInt(req.getParameter("id")));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/video.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        videoService.increaseLikes(Integer.parseInt(req.getParameter("id")), req, resp);
        commentService.sendComment(req, resp);
        noteService.saveNote(Integer.parseInt(req.getParameter("id")), req, resp);
    }


}
