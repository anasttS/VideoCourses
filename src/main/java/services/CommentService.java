package services;

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
    private CommentDAO commentDAO = new CommentDAO();

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


    public void sendComment(Comment comment) {
            commentDAO.add(comment);
    }
}
