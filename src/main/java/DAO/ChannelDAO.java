package DAO;

import models.Channel;

import java.sql.*;


public class ChannelDAO {
    private static Connection connection = ConnectionProvider.getConnection();

    public boolean channelIsExist(int user_id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM channel WHERE owner_id = ?");
            statement.setInt(1, user_id);
            if (statement.executeQuery().next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Exception during channelIsExist");
            throw new IllegalArgumentException();
        }
        return false;
    }

    public void createChannel(Channel channel) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO channel (owner_id, name_channel, img_channel) VALUES (?, ?, ?) ");
            statement.setInt(1, channel.getOwner_id());
            statement.setString(2, channel.getName());
            statement.setString(3, channel.getImg());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during create channel");
            throw new IllegalArgumentException();
        }
    }

    public void deleteChannel(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM channel WHERE id = " + id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during deleteChannel");
            throw new IllegalArgumentException();
        }
    }

    public int findIDofChannel(String name) {
        try {
            int id = 0;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM channel WHERE name_channel = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            return id;
        } catch (SQLException e) {
            System.out.println("Exception during findIdOfChannel");
            throw new IllegalArgumentException();
        }
    }

    public int findIDofChannelByUserID(int owner_id) {
        try {
            int id = 0;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM channel WHERE owner_id = ?");
            statement.setInt(1, owner_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id_");
            }
            return id;
        } catch (SQLException e) {
            System.out.println("Exception during findIdOfChannelByUserId");
            throw new IllegalArgumentException();
        }
    }
    public String  findNameOfChannelByUserID(int owner_id){
        try {
            String name = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM channel WHERE owner_id = ?");
            statement.setInt(1, owner_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                name = resultSet.getString("name_channel");
            }
            return name;
        } catch (SQLException e) {
            System.out.println("Exception during findNameOfChannelByUserId");
            throw new IllegalArgumentException();
        }
    }
    public String  findImgOfChannelByUserID(int owner_id){
        try {
            String img = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM channel WHERE owner_id = ?");
            statement.setInt(1, owner_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                img = resultSet.getString("img_channel");
            }
            return img;
        } catch (SQLException e) {
            System.out.println("Exception during findNameOfChannelByUserId");
            throw new IllegalArgumentException();
        }
    }



    public String findNameOfChannelByVideoId(int id_video) {
        try {
            String name = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video LEFT JOIN channel ON video.channel_id = channel.id_ WHERE video.id_video = ?");
            statement.setInt(1, id_video);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                name = resultSet.getString("name_channel");
            }
            return name;
        } catch (SQLException e) {
            System.out.println("Exception during findNameOfChannelByVideoId");
            throw new IllegalArgumentException();
        }
    }

    public String findImgOfChannelByVideoId(int id_video) {
        try {
            String img = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM video LEFT JOIN channel ON video.channel_id = channel.id_ WHERE video.id_video = ?");
            statement.setInt(1, id_video);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                img = resultSet.getString("img_channel");
            }
            return img;
        } catch (SQLException e) {
            System.out.println("Exception during findImgOfChannelByVideoId");
            throw new IllegalArgumentException();
        }
    }
}



