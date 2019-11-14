package pages;


import BL.UserService;
import BL.VideoService;
import UILogic.ForNavbar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100)
@WebServlet("/addVideo")
public class AddVideoServlet extends HttpServlet {
    private ForNavbar forNavbar = new ForNavbar();
    private VideoService videoService = new VideoService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("current_user") != null) {
            forNavbar.authUser(req);
            RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/addVideo.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        videoService.addVideo(req, resp);
    }

}

