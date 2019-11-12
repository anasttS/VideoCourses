package pages;

import BL.ChannelService;
import BL.UserService;
import DAO.ChannelDAO;
import DAO.UserDAO;
import models.Channel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100)
@WebServlet("/channel")
public class CreateChannelServlet extends HttpServlet {
    ChannelService channelService = new ChannelService();
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/createChannel.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = channelService.getIdByName(channelService.findNameofChannelByUserId(userService.getIdByEmail((String) req.getSession().getAttribute("current_user"))));
        channelService.createChannel(id, req, resp);
    }
}
