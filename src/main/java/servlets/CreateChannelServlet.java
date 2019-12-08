package servlets;

import UILogic.ChannelLogic;
import UILogic.UserLogic;
import services.ChannelService;
import services.UserService;

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
@WebServlet("/channel")
public class CreateChannelServlet extends HttpServlet {
    private ChannelLogic channelLogic = new ChannelLogic();
    private UserLogic userLogic = new UserLogic();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userLogic.authUser(req);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/createChannel.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = channelLogic.getIdByName(channelLogic.findNameofChannelByUserId(userLogic.getIdByEmail(req)));
        channelLogic.createChannel(id, req, resp);
    }
}
