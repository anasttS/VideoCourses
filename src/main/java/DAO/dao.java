package DAO;

import models.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class dao {
    private static ArrayList<User> usersArr;
    private static Statement stmt = null;
    private static Connection connection = null;

    public static void run() {
        usersArr = new ArrayList<>();
        final String driverName = "com.mysql.cj.jdbc.Driver";
        final String connectionString = "jdbc:mysql://localhost:3306/videocourses?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String login = "root";
        final String password = "SteshaandMe1";

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(connectionString, login, password);
            stmt = connection.createStatement();
            String sql = "SELECT * FROM users";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User u = new User(rs.getString("email"), rs.getString("username"), rs.getString("password"), LocalDate.parse(rs.getString("birthDate")), rs.getString("interests"));
                usersArr.add(u);
            }
//            stmt.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getUsers() {
        return usersArr;
    }

    public static void save(User user)
    {
        usersArr.add(user);
        try {
            int rows = stmt.executeUpdate("INSERT INTO users (email, username, password, birthDate, interests) VALUES (\""  + user.getEmail() + "\", \"" + user.getUsername() + "\", \"" + user.getPassword() +  "\", \"" + user.getBirthDate()  + "\", \"" + user.getInterests() + "\")");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        try {
            int rows = stmt.executeUpdate("DELETE FROM users WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isExist(String email, String password) {
        for (User user : usersArr) {
            if (user.getEmail().equals(email) && (user.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isContained(String email) {

        for (User user : usersArr) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }


    public String compare() {
//        double max = -1;
//        String userName = null;
//        if (users.size() == 1) {
//            return products.get(0).getProduct();
//        }
//        for (int i = 1; i < products.size(); i++) {
//            if (Double.parseDouble(products.get(i).getPrice()) > Double.parseDouble(products.get(i - 1).getPrice()) && Double.parseDouble(products.get(i).getPrice()) >= max) {
//                max = Double.parseDouble(products.get(i).getPrice());
//                product = products.get(i).getProduct();
//            }
//        }
        return null;
    }

    public static void main(String[] args) {
        run();
    }
}
