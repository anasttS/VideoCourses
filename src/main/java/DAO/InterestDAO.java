package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InterestDAO {
    private static Connection connection = ConnectionProvider.getConnection();

    public void addInterest(int idUser, String interest) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO interest_user_rel (id_user, id_interest) VALUES (?, ?) ");
            statement.setInt(1, idUser);
            statement.setString(2, interest);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during addInterest");
            throw new IllegalArgumentException();
        }
    }

    public void deleteInterest(int idUser, String interest) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM interest_user_rel WHERE id_user = ? and id_interest = ? ");
            statement.setInt(1, idUser);
            statement.setString(2, interest);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during deleteInterest");
            throw new IllegalArgumentException();
        }
    }

    public Map<Integer, String> findInterestsOfUser(int idUser){
        Map<Integer, String> interests = new HashMap<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM interest_user_rel LEFT JOIN interests ON interest_user_rel.id_interest = interests.interest_id WHERE id_user = ?;");
            statement.setInt(1, idUser);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                interests.put(resultSet.getInt("id_interest"), resultSet.getString("text"));
            }
        } catch (SQLException e) {
            System.out.println("Exception during findInterestsOfUser");
            throw new IllegalArgumentException();
        }
        return interests;
    }

    public boolean interestIsExist(String interest, int idUser) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM interest_user_rel WHERE id_user = ? AND id_interest = ?");
            statement.setInt(1, idUser);
            statement.setString(2, interest);
            if (statement.executeQuery().next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Exception during userIsExist");
            throw new IllegalArgumentException();
        }
        return false;
    }

    public Map<Integer, String> getInterests(){
        Map<Integer, String> interests = new HashMap<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM  interests;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                interests.put(resultSet.getInt("interest_id"), resultSet.getString("text"));
            }
        } catch (SQLException e) {
            System.out.println("Exception during getInterests");
            throw new IllegalArgumentException();
        }
        return interests;
    }

}

