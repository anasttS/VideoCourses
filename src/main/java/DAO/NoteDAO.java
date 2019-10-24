package DAO;

import models.Note;

import java.sql.*;


public class NoteDAO{

    private static Connection connection = ConnectionProvider.getConnection();

    public  void saveNote(Note note) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO note (text, id_user, id_video) VALUES (?, ?, ?) ");
            statement.setString(1, note.getText());
            statement.setInt(2, note.getId_user());
            statement.setInt(3, note.getId_video());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during saveNote");
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
}

