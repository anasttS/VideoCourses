package servlets;

import UILogic.ChannelLogic;
import UILogic.UserLogic;
import services.ChannelService;
import services.UserService;
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
    private UserLogic userLogic = new UserLogic();
    private ChannelLogic channelLogic = new ChannelLogic();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (userLogic.checkUser(req, resp)){
            userLogic.authUser(req);
            userLogic.setProfileAttributes(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        channelLogic.sendToCreatingChannel(req, resp);
        userLogic.edit(req, resp);
    }
}
