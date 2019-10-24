package BL;

import DAO.ChannelDAO;
import DAO.UserDAO;
import models.Channel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChannelService {
    UserDAO userDAO = new UserDAO();
    ChannelDAO channelDAO = new ChannelDAO();

    public void createChannel(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (req.getParameter("create") != null) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/channel.jsp");
                dispatcher.forward(req, resp);
                String email = (String) req.getSession().getAttribute("current_user");
                channelDAO.createChannel(new Channel(userDAO.findIDofUser(email), req.getParameter("name")));
                resp.sendRedirect("/profile");
        }
        } catch (ServletException | IOException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }
}
