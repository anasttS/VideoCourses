package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InterestDAO {
    private static Connection connection = ConnectionProvider.getConnection();

    public void addInterest(int id_user, String interest) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO interest_user_rel (id_user, id_interest) VALUES (?, ?) ");
            statement.setInt(1, id_user);
            statement.setString(2, interest);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during addInterest");
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<Integer> findInterestsOfUser(int id_user){
        ArrayList<Integer> interests = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM  interest_user_rel WHERE id_user = ?");
            statement.setInt(1, id_user);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                interests.add(resultSet.getInt("id_interest"));
            }
        } catch (SQLException e) {
            System.out.println("Exception during findInterestsOfUser");
            throw new IllegalArgumentException();
        }
        return interests;
    }
}

