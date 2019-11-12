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
            System.out.println();
            throw new IllegalArgumentException();
        }
    }

    public List<Comment> getAllByIdNote(int id) {
        List<Comment> commentsOfNote = new ArrayList();
        try {
            PreparedStatement statement = connection.prepareStatement("with t as (SELECT * FROM comment LEFT JOIN users ON comment.id_user = users.id) select * from t WHERE  id_media = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int idComment = rs.getInt(1);
                int mediaId = rs.getInt(3);
                Date date = (rs.getDate(4));
                String text = (rs.getString(5));
                String username = (rs.getString(8));
                String img = (rs.getString(13));

                Comment md = new Comment(idComment, mediaId, date, text, username, img);
                commentsOfNote.add(md);
            }
        } catch (SQLException e) {
            System.out.println("Exception during find all video in channel");
            throw new IllegalArgumentException();
        }
        return commentsOfNote;
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

    public String getTextById(int id){
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement("SELECT text FROM comment WHERE id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Exception during find description of note");
            throw new IllegalArgumentException();
        }
    }

    public Date getDateById(int id){
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement("SELECT date FROM comment WHERE id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getDate(1);
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Exception during find description of note");
            throw new IllegalArgumentException();
        }
    }

    public int getOwnedIdById(int id){
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement("SELECT id_user FROM comment WHERE id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("Exception during find description of note");
            throw new IllegalArgumentException();
        }
    }
}