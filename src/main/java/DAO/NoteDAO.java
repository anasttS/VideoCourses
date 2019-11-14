package DAO;

import models.Note;

import java.sql.*;
import java.util.ArrayList;

public class NoteDAO{

    private static Connection connection = ConnectionProvider.getConnection();

    public  void saveNoteBD(Note note) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO note (text, id_user, video_id) VALUES (?, ?, ?)");
            statement.setString(1, note.getText());
            statement.setInt(2, note.getId_user());
            statement.setInt(3, note.getId_video());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during saveNote");
            throw new IllegalArgumentException();
        }
    }

    public void updateData(String text, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE note SET text = ? WHERE id = ?");
            statement.setInt(2, id);
            statement.setString(1, text);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during update data in note");
            throw new IllegalArgumentException();
        }
    }


    public void deleteNote(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM note WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during deleteNote");
            throw new IllegalArgumentException();
        }
    }

    public Note findNoteById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM note WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Note(resultSet.getInt("id"),resultSet.getString("text"), resultSet.getInt("id_user"), resultSet.getInt("video_id"));
            }
        } catch (SQLException e) {
            System.out.println("Exception during find note");
            throw new IllegalArgumentException();
        }
        return null;
    }

    public  ArrayList<Note> getNotesArrByUserID(int user_id) {
        ArrayList<Note> videos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM note WHERE id_user = " + user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                videos.add(new Note(resultSet.getInt("id"),resultSet.getString("text"), resultSet.getInt("id_user"), resultSet.getInt("video_id")));
            }
            return videos;
        } catch (SQLException e) {
            System.out.println("Exception during getVideos");
            throw new IllegalArgumentException();
        }
    }
}

