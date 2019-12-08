package servlets;



import UILogic.UserLogic;
import UILogic.VideoLogic;
import services.VideoService;
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
    private UserLogic userLogic = new UserLogic();
    private VideoLogic videoLogic = new VideoLogic();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (userLogic.checkUser(req, resp)) {
            userLogic.authUser(req);
            RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/addVideo.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        videoLogic.addVideo(req, resp);
    }

}

