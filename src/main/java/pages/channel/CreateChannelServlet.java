package pages.channel;

import DAO.ChannelDAO;
import DAO.UserDAO;
import models.Channel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/channel")
public class CreateChannelServlet extends HttpServlet {
    UserDAO dao = new UserDAO();
    ChannelDAO channelDAO = new ChannelDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/channel.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("current_user");
        int owner_id = dao.findIDofUser(user);
        String name = req.getParameter("name");
        session.setAttribute("nameOfChannel", name);
        if (req.getParameter("createChannel") != null) {
            channelDAO.createChannel(new Channel(owner_id, name));
            resp.sendRedirect("/profile");
            //UserDAO.updateChannel();
        }
    }
}
