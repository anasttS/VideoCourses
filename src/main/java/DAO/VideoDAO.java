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

    public  ArrayList<Video> getVideosByInterests(int id_user) {
        ArrayList<Video> videos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video left JOIN interest_user_rel ON video.interest_id = interest_user_rel.id_interest WHERE id_user = ?");
            statement.setInt(1, id_user);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                videos.add(new Video(resultSet.getInt("id_video"), resultSet.getString("name"), resultSet.getString("description"), LocalDate.parse(resultSet.getString("upload_date")), resultSet.getInt("owner_id"), resultSet.getInt("channel_id"), resultSet.getInt("likes"), resultSet.getInt("views"), resultSet.getString("url"), resultSet.getString("img")));
            }
            return videos;
        } catch (SQLException e) {
            System.out.println("Exception during getVideosByInterests");
            throw new IllegalArgumentException();
        }
    }

    public void increaseViews(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE video SET views = views + 1 WHERE id_video = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during increaseViews");
            throw new IllegalArgumentException();
        }

    }
    public void increaseLikes(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE video SET likes = likes + 1 WHERE id_video = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during increaseLikes");
            throw new IllegalArgumentException();
        }

    }

    public void saveVideo(Video video) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO videocourses.video (name, description, upload_date, owner_id, channel_id, likes, views, url, img, interest_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, video.getName());
            statement.setString(2, video.getDescription());
            statement.setString(3, video.getUpload_date().toString());
            statement.setInt(4, video.getOwner_id());
            statement.setInt(5, video.getChannel_id());
            statement.setInt(6, video.getLikes());
            statement.setInt(7, video.getViews());
            statement.setString(8, video.getUrl());
            statement.setString(9, video.getImg());
            statement.setInt(10, video.getInterest_id());
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
            System.out.println("Exception during delete video");
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
            System.out.println("Exception during get videoname by id");
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
            System.out.println("Exception during get url by id");
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
            System.out.println("Exception during get description of video by id");
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
            System.out.println("Exception during get date of video by id");
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
            System.out.println("Exception during get preview of video by id");
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
            System.out.println("Exception during get video by id");
            throw new IllegalArgumentException();
        }
        return null;
    }

    public ArrayList<Video> getVideoByVideoName(String pattern) {
        ArrayList<Video> videos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video WHERE name like ?");
            statement.setString(1, "%" + pattern + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                videos.add(new Video(resultSet.getInt("id_video"), resultSet.getString("name"), resultSet.getString("description"), LocalDate.parse(resultSet.getString("upload_date")), resultSet.getInt("owner_id"), resultSet.getInt("channel_id"), resultSet.getInt("likes"), resultSet.getInt("views"), resultSet.getString("url"), resultSet.getString("img")));
            }

        } catch (SQLException e) {
            System.out.println("Exception during find all video by videoname");
            throw new IllegalArgumentException();
        }
        return videos;
    }

    public ArrayList<Video> getVideoByUserName(String query){
        ArrayList<Video> videos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("        SELECT * FROM video LEFT JOIN users ON video.owner_id = users.id WHERE users.username like ?");
            statement.setString(1, "%" + query + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                videos.add(new Video(resultSet.getInt("id_video"), resultSet.getString("name"), resultSet.getString("description"), LocalDate.parse(resultSet.getString("upload_date")), resultSet.getInt("owner_id"), resultSet.getInt("channel_id"), resultSet.getInt("likes"), resultSet.getInt("views"), resultSet.getString("url"), resultSet.getString("img")));
            }

        } catch (SQLException e) {
            System.out.println("Exception during find all video by Username");
            throw new IllegalArgumentException();
        }
        return videos;
    }


        public ArrayList<Video> getVideoByChannelName(String query){
            ArrayList<Video> videos = new ArrayList<>();
            try {
                PreparedStatement statement = connection.prepareStatement("        SELECT * FROM video LEFT JOIN channel ON video.channel_id = channel.id_ WHERE channel.name like ?");
                statement.setString(1, "%" + query + "%");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    videos.add(new Video(resultSet.getInt("id_video"), resultSet.getString("name"), resultSet.getString("description"), LocalDate.parse(resultSet.getString("upload_date")), resultSet.getInt("owner_id"), resultSet.getInt("channel_id"), resultSet.getInt("likes"), resultSet.getInt("views"), resultSet.getString("url"), resultSet.getString("img")));
                }

            } catch (SQLException e) {
                System.out.println("Exception during find all video by ChannelName");
                throw new IllegalArgumentException();
            }
            return videos;
        }

}
