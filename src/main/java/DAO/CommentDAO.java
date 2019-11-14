package DAO;

import models.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CommentDAO  {
    private static Connection connection = ConnectionProvider.getConnection();

    public ResultSet getCommnets(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM videocourses.comment LEFT JOIN videocourses.users ON comment.user_id = users.id WHERE mediaId = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Exception during get comments");
            throw new IllegalArgumentException();
        }
    }

    public void add(Comment comment) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO comment (user_id, mediaId, date, text) VALUES (?, ?, ?, ?)");
            statement.setInt(1, comment.getUserId());
            statement.setInt(2, comment.getMediaId());
            statement.setDate(3, comment.getDate());
            statement.setString(4, comment.getText());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during creating");
            throw new IllegalArgumentException(e);
        }
    }

}