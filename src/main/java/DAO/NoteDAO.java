package DAO;

import models.Note;

import java.sql.*;
import java.util.ArrayList;

public class NoteDAO{

    private static Connection connection = ConnectionProvider.getConnection();

    public  void saveNoteBD(Note note) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO note (text, id_user, id_video) VALUES (?, ?, ?)");
            statement.setString(1, note.getText());
            statement.setInt(2, note.getId_user());
            statement.setInt(3, note.getId_video());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during saveNote");
            throw new IllegalArgumentException();
        }
    }

    public void updateData(int id_video, String text, int id_user) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE note SET id_video = ?, text = ? WHERE id_user = ?");
            statement.setInt(1, id_video);
            statement.setString(2, text);
            statement.setInt(3, id_user);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }


    public void deleteNote(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM notes WHERE id = " + id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during deleteNote");
            throw new IllegalArgumentException();
        }
    }



    public  ArrayList<Note> getNotesArrByUserID(int user_id) {
        ArrayList<Note> videos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM note WHERE id_user = " + user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                videos.add(new Note(resultSet.getString("text"), resultSet.getInt("id_user"), resultSet.getInt("id_video")));
            }
            return videos;
        } catch (SQLException e) {
            System.out.println("Exception during getVideos");
            throw new IllegalArgumentException();
        }
    }
}

