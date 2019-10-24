package DAO;

import models.Video;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class VideoDAO {
    private static Connection connection = ConnectionProvider.getConnection();

    public static ArrayList<Video> getVideoArr() {
        ArrayList<Video> videos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                videos.add(new Video(resultSet.getString("name"), resultSet.getString("description"), LocalDate.parse(resultSet.getString("upload_date")), resultSet.getInt("owner_id"), resultSet.getInt("channel_id"), resultSet.getInt("playlist_id"), resultSet.getInt("likes"), resultSet.getInt("views"), resultSet.getString("url")));
            }
            return videos;
        } catch (SQLException e) {
            System.out.println("Exception during getVideos");
            throw new IllegalArgumentException();
        }
    }


//    public static ArrayList<Video> getVideoFromChannel(int channel_id) {
//        ArrayList<Video> videoFromChannel = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM video WHERE channel_id = \"" + channel_id + "\"";
//            ResultSet rs = null;
//                rs = stmt.executeQuery(sql);
//                if (rs.next()) {
//                    videoFromChannel.add(new Video(rs.getString("name"), rs.getString("description"), LocalDate.parse(rs.getString("upload_date")), rs.getInt("owner_id"), rs.getInt("channel_id"), rs.getInt("playlist_id"), rs.getInt("likes"), rs.getInt("views"), rs.getString("url")));
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//         return videoFromChannel;
//    }

//    public static int findIDofUser(String url) {
//        try {
//            String sql = "SELECT * FROM video WHERE url = \"" + url + "\"";
//            if (stmt.executeQuery(sql).next()) {
//                System.out.println(stmt.executeQuery(sql).getInt("id"));
//                return stmt.executeQuery(sql).getInt("id");
//            }
//        } catch (SQLException e) {
//            System.out.println("Exception during findId");
//            throw new IllegalArgumentException();
//        }
//        return 0;
//    }

    public void saveVideo(Video video) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO video (name, description, upload_date, owner_id, channel_id, playlist_id, likes, views, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ");
            statement.setString(1, video.getName());
            statement.setString(2, video.getDescription());
            statement.setString(3, video.getUpload_date().toString());
            statement.setInt(4, video.getOwner_id());
            statement.setInt(5, video.getChannel_id());
            statement.setInt(6, video.getPlaylist_id());
            statement.setInt(7, video.getLikes());
            statement.setInt(8, video.getViews());
            statement.setString(9, video.getUrl());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during saveVideo");
            throw new IllegalArgumentException();
        }
    }

    public void deleteVideo(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM video WHERE id = " + id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during deleteChannel");
            throw new IllegalArgumentException();
        }
    }
}
