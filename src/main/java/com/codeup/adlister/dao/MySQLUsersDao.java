package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
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
    public User findByUsername(String username) {
        // Set query string to find user by username.
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            // Establish prepared statement and pass query string to prepare for execution.
            PreparedStatement stmt = connection.prepareStatement(query);
            // Set the value of the ? to the username we are searching for.
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        // Setup insert query string
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            // Prepare statement with query string and Statement.RETURN_GENERATED_KEYS to get newly generated ID
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // set the values of the ?'s with the data from our User instance
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            // Execute the update statement
            stmt.executeUpdate();
            // get the newly generated ID
            ResultSet rs = stmt.getGeneratedKeys();
            // Move rs pointer to first row container the new ID
            rs.next();
            // return the newly generated ID.
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            // if no user by that username exists, return null
            return null;
        }
        // otherwise, create a new User instance based on the ResultSet
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }

}
