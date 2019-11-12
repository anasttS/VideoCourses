package DAO;

import models.Video;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class VideoDAO {
    private static Connection connection = ConnectionProvider.getConnection();

    public  ArrayList<Video> getVideoArr() {
        ArrayList<Video> videos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                videos.add(new Video(resultSet.getInt("id_video"), resultSet.getString("name"), resultSet.getString("description"), LocalDate.parse(resultSet.getString("upload_date")), resultSet.getInt("owner_id"), resultSet.getInt("channel_id"), resultSet.getInt("likes"), resultSet.getInt("views"), resultSet.getString("url"), resultSet.getString("img")));
            }
            return videos;
        } catch (SQLException e) {
            System.out.println("Exception during getVideos");
            throw new IllegalArgumentException();
        }
    }
    public  ArrayList<Video> getRandomVideoArr() {
        ArrayList<Video> videos = new ArrayList<>();
        try {
            Random r = new Random();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                videos.add(new Video(resultSet.getInt("id_video"), resultSet.getString("name"), resultSet.getString("description"), LocalDate.parse(resultSet.getString("upload_date")), resultSet.getInt("owner_id"), resultSet.getInt("channel_id"), resultSet.getInt("likes"), resultSet.getInt("views"), resultSet.getString("url"), resultSet.getString("img")));
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
            PreparedStatement statement = connection.prepareStatement("INSERT INTO videocourses.video (name, description, upload_date, owner_id, channel_id, likes, views, url, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, video.getName());
            statement.setString(2, video.getDescription());
            statement.setString(3, video.getUpload_date().toString());
            statement.setInt(4, video.getOwner_id());
            statement.setInt(5, video.getChannel_id());
            statement.setInt(6, video.getLikes());
            statement.setInt(7, video.getViews());
            statement.setString(8, video.getUrl());
            statement.setString(9, video.getImg());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during saveVideo");
            throw new IllegalArgumentException();
        }
    }

    public void deleteVideo(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM video WHERE id_video = " + id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during deleteChannel");
            throw new IllegalArgumentException();
        }
    }

    public String getVideonameByID(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video WHERE id_video = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                return name;
            }
        } catch (SQLException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
        return null;
    }


    public String getUrlById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video WHERE id_video = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String url = resultSet.getString("url");
                return url;
            }
        } catch (SQLException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
        return null;
    }
    public String getDescriptionOfVideoByID(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video WHERE id_video = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String description = resultSet.getString("description");
                return description;
            }
        } catch (SQLException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
        return null;
    }

    public Date getDateOfVideoByID(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video WHERE id_video = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Date date = resultSet.getDate("upload_date");
                return date;
            }
        } catch (SQLException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
        return null;
    }

    public String getPreviewOfVideoByID(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video WHERE id_video = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String img = resultSet.getString("img");
                return img;
            }
        } catch (SQLException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
        return null;
    }

    public ArrayList<Video> getVideoArrByChannelId(int channel_id){
        ArrayList<Video> videos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video WHERE channel_id = ?");
            statement.setInt(1,channel_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                videos.add(new Video(resultSet.getInt("id_video"), resultSet.getString("name"), resultSet.getString("description"), LocalDate.parse(resultSet.getString("upload_date")), resultSet.getInt("owner_id"), resultSet.getInt("channel_id"), resultSet.getInt("likes"), resultSet.getInt("views"), resultSet.getString("url"), resultSet.getString("img")));
            }
            return videos;
        } catch (SQLException e) {
            System.out.println("Exception during getVideosByChannelId");
            throw new IllegalArgumentException();
        }
    }

    public Video getVideoByID(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video WHERE id_video = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
               return new Video(resultSet.getInt("id_video"), resultSet.getString("name"), resultSet.getString("description"), LocalDate.parse(resultSet.getString("upload_date")), resultSet.getInt("owner_id"), resultSet.getInt("channel_id"), resultSet.getInt("likes"), resultSet.getInt("views"), resultSet.getString("url"), resultSet.getString("img"));
            }
        } catch (SQLException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
        return null;
    }


}
