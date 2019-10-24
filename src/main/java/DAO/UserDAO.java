package DAO;

import models.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class UserDAO {
    private static Connection connection = ConnectionProvider.getConnection();

    public User getUserByEmail(String email) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getString("email"), resultSet.getString("username"), resultSet.getInt("password"), LocalDate.parse(resultSet.getString("birthDate")), resultSet.getString("interests"));
            }
        } catch (SQLException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
        return null;
    }

    public void saveUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (email, username, password, birthDate, interests) VALUES (?, ?, ?, ?, ?) ");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setInt(3, user.getPassword());
            statement.setString(4, user.getBirthDate().toString());
            statement.setString(5, user.getInterests());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during saveUser");
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getString("email"), resultSet.getString("username"), resultSet.getInt("password"), LocalDate.parse(resultSet.getString("birthDate")), resultSet.getString("interests")));
            }
            return users;
        } catch (SQLException e) {
            System.out.println("Exception during getUsers");
            throw new IllegalArgumentException();
        }
    }

    public int findIDofUser(String email) {
        int id = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = " + email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            return id;
        } catch (SQLException e) {
            System.out.println("Exception during findIDofUser");
            throw new IllegalArgumentException();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = " + id);
             statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception during delete");
            throw new IllegalArgumentException();
        }

    }

    public boolean userIsExist(String email, int password) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setInt(2, password);
            if (statement.execute()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Exception during userIsExist");
            throw new IllegalArgumentException();
        }
        return false;
    }

    public boolean emailIsContained(String email) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            if (statement.executeQuery().next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Exception during emailIsContained");
            throw new IllegalArgumentException();
        }
        return false;
    }

    public void updateData(String username, LocalDate birthDate, String email) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET username = ?, birthDate = ? WHERE email = ?");
            statement.setString(1, username);
            statement.setString(2, birthDate.toString());
            statement.setString(3, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
            throw new IllegalArgumentException();
        }
    }


//    public static boolean checkPermission(String nameOfRight) {
//        try {
//            if ((stmt.executeQuery("SELECT * FROM users WHERE right = \"" + nameOfRight + "\"")).next()) {
//                return true;
//            }
//        } catch (SQLException e) {
//            System.out.println("Exception during checkPermission");
//            throw new  IllegalArgumentException();
//        }
//        return false;
//    }

}
