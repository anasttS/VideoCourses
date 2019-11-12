package BL;

import DAO.ChannelDAO;
import DAO.CommentDAO;
import DAO.UserDAO;
import DAO.VideoDAO;
import models.Comment;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import static java.lang.Integer.parseInt;

public class CommentService {
    UserDAO userDAO = new UserDAO();
    CommentDAO commentDAO = new CommentDAO();
    VideoDAO videoDAO = new VideoDAO();
    ChannelDAO channelDAO = new ChannelDAO();

    public LinkedList<Comment> getComments(int videoId) {
        try {
            return getComments0(videoId);
        } catch (SQLException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }


    private LinkedList<Comment> getComments0(int videoId) throws SQLException {
        LinkedList<Comment> comments = new LinkedList<>();
        ResultSet resultSet = commentDAO.getCommnets(videoId);
        while (resultSet.next()) {
            comments.add(new Comment(resultSet.getInt("id"), resultSet.getInt("mediaId"), resultSet.getDate("date"), resultSet.getString("text"), resultSet.getString("username"), resultSet.getString("img_user")));
        }
        return comments;
    }



    public void sendComment(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("send") != null) {
            int id_n = parseInt(request.getParameter("send"));
            int idUser = userDAO.findIDofUser(request.getSession().getAttribute("current_user").toString());
            String text = request.getParameter("text");
            java.sql.Date myDate = new java.sql.Date(System.currentTimeMillis());
            Comment comment = new Comment(idUser, id_n, myDate, text);
            commentDAO.add(comment);
            try {
                response.sendRedirect("/video?id=" + id_n);
            } catch (IOException e) {
                System.out.println();
                throw new IllegalArgumentException();
            }
        }
    }
}
