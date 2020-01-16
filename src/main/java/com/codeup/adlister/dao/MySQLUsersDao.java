package com.codeup.adlister.dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) throws SQLException {
        String q = "SELECT * FROM users WHERE username = ? LIMIT 1";

        PreparedStatement stmt = connection.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        User found = new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
        return found;
    }

    @Override
    public Long insert(User user) {
        try {
            String q = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    public static void main(String[] args) throws SQLException {
        String n = "name";
        User f = DaoFactory.getUsersDoa().findByUsername(n);
        System.out.println(f.toString());
    }
}
