package pages.channel;

import DAO.ChannelDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/channelProfile")
public class ChannelServlet extends HttpServlet {
    ChannelDAO dao = new ChannelDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        String nameOfChannel = (String) session.getAttribute("nameOfChannel");
//        req.setAttribute("nameOfChannel", nameOfChannel);
//        int channel_id = ChannelDAO.findId(nameOfChannel);
//        ArrayList<Video> videos = VideoDAO.getVideoFromChannel(channel_id);
//        System.out.println(videos.toArray().toString());
//        req.setAttribute("videos", videos);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/channelProfile.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        String name = req.getParameter("name");
//        String description = req.getParameter("description");
//        LocalDate upload_date = LocalDate.parse(req.getParameter("upload_date"));
//        String user = (String) session.getAttribute("current_user");
//        String nameOfChannel = (String) session.getAttribute("nameOfChannel");
//        req.setAttribute("nameOfChannel", nameOfChannel);
//        int owner_id = UserDAO.findIDofUser(user);
//        int channel_id = ChannelDAO.findId(nameOfChannel);
//        int playlist_id = 1;
//        int likes = 10;
//        int views = 20;
//        String url = "bear.ru";
//        if (req.getParameter("add") != null) {
//           VideoDAO.saveUser(new Video(name, description, upload_date, owner_id, channel_id, playlist_id, likes, views, url), channel_id);
//        } else if (req.getParameter("delete") != null){
//            VideoDAO.delete(req.getParameter("delete"), channel_id);
//        }
//        resp.sendRedirect("/channelProfile");

    }
}
