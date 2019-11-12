package DAO;

import models.Video;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FindDAO {
    private static Connection connection = ConnectionProvider.getConnection();

    public List<Video> getNoteBySearch(String pattern) {
        List<Video> notesLike = new ArrayList<Video>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video WHERE name = ?");
            statement.setString(1, "%" + pattern + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id_note = rs.getInt(0);
                int id_owned = rs.getInt(4);
                int id_channel = rs.getInt(5);
                String name = (rs.getString(1));
                String description = (rs.getString(2));
                LocalDate date = (rs.getDate(3)).toLocalDate();
                String url = (rs.getString(8));
                String preview = (rs.getString(9));
                Video md = new Video(id_note, name, description, date, id_owned, id_channel, url, preview);
                notesLike.add(md);
            }
        } catch (SQLException e) {
            System.out.println("Exception during find all note in channel");
            throw new IllegalArgumentException();
        }
        return notesLike;
    }

    public List<Video> getAllByUserName(String pattern) {
        List<Video> notesOfUser = new ArrayList<Video>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video LEFT JOIN users ON video.owner_id = users.id WHERE users.username = ?");
            statement.setString(1, "%" + pattern + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id_note = rs.getInt(0);
                int id_owned = rs.getInt(4);
                int id_channel = rs.getInt(5);
                String name = (rs.getString(1));
                String description = (rs.getString(2));
                LocalDate date = (rs.getDate(3)).toLocalDate();
                String url = (rs.getString(8));
                String preview = (rs.getString(9));
                Video md = new Video(id_note, name, description, date, id_owned, id_channel, url, preview);
                notesOfUser.add(md);
            }
        } catch (SQLException e) {
            System.out.println("Exception during find all note in channel");
            throw new IllegalArgumentException();
        }
        return notesOfUser;
    }

    public List<Video> getAllByChannelName(String pattern) {
        List<Video> notesOfChannel = new ArrayList<Video>();
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement("with t as (SELECT * FROM video LEFT JOIN channel ON video.owner_id = channel.id) select * from t WHERE channel.name = ?");
            statement.setString(1, "%" + pattern + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id_note = rs.getInt(0);
                int id_owned = rs.getInt(4);
                int id_channel = rs.getInt(5);
                String name = (rs.getString(1));
                String description = (rs.getString(2));
                LocalDate date = (rs.getDate(3)).toLocalDate();
                String url = (rs.getString(8));
                String preview = (rs.getString(9));
                Video md = new Video(id_note, name, description, date, id_owned, id_channel, url, preview);
                notesOfChannel.add(md);
            }
        } catch (SQLException e) {
            System.out.println("Exception during find all note in channel");
            throw new IllegalArgumentException();
        }
        return notesOfChannel;
    }

    public List<Video> getAllByAll(String pattern) {
        List<Video> allNotes = new ArrayList<>();
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement("with t1 as (SELECT * FROM video LEFT JOIN users ON media.owner_id = users.id and video.channel_id = users.own_channel),\n" +
                    "     t2 as (select * from t1 WHERE username = ?),\n" +
                    "     t3 as (SELECT * FROM video LEFT JOIN channel ON video.channel_id = channel.id),\n" +
                    "     t4 as (select * from t3 WHERE channel.name = ?),\n" +
                    "     t5 as (SELECT * FROM video where name = ?),\n" +
                    "     t6 as (SELECT owner_id, channel_id, id, video.name, description, video.date, video.url, video.img from t2 UNION SELECT owner_id, channel_id, id, video.name, description, video.date, video.url, video.img from t4),\n" +
                    "     t7 as (SELECT owner_id, channel_id, id, video.name, description, video.date, video.url, video.img from t5 UNION SELECT owner_id, channel_id, id, video.name, description, video.date, video.url, video.img from t6)\n" +
                    "select * from t7;");
            statement.setString(1, "%" + pattern + "%");
            statement.setString(2, "%" + pattern + "%");
            statement.setString(3, "%" + pattern + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id_note = rs.getInt(0);
                int id_owned = rs.getInt(4);
                int id_channel = rs.getInt(5);
                String name = (rs.getString(1));
                String description = (rs.getString(2));
                LocalDate date = (rs.getDate(3)).toLocalDate();
                String url = (rs.getString(8));
                String preview = (rs.getString(9));
                Video md = new Video(id_note, name, description, date, id_owned, id_channel, url, preview);
                allNotes.add(md);
            }
        } catch (SQLException e) {
            System.out.println("Exception during find all note in channel");
            throw new IllegalArgumentException();
        }
        return allNotes;
    }
}
