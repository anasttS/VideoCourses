package DAO;

import models.Channel;

import java.sql.*;


public class ChannelDAO {
    private static Connection connection = ConnectionProvider.getConnection();


//    public static ArrayList<Channel> getChannelsArrFromUser(int owner_id) {
//        ArrayList<Channel> channels = new ArrayList<>();
//        String sql = ("SELECT * FROM channel WHERE owner_id = " + owner_id + "");
//        System.out.println(sql);
//        try {
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                channels.add(new Channel(rs.getInt("owner_id"), rs.getString("name"), rs.getInt("playlist")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return channels;
//    }

    public  void createChannel(Channel channel) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO channel (owner_id, name) VALUES (?, ?) ");
            statement.setInt(1, channel.getOwner_id());
            statement.setString(2, channel.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during saveVideo");
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
}

//    public static int findId(String name) {
//        int id = 0;
//        String sql = ("SELECT * FROM channel WHERE name = \"" + name + "\"");
//        ResultSet rs = null;
//        try {
//            rs = stmt.executeQuery(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (rs.next()) {
//                id = rs.getInt("_id");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return id;
//    }



