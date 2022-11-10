package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            // store query in stmt instance to be executed.
            stmt = connection.prepareStatement("SELECT * FROM ads");
            // execute the query and set equal to a ResultSet
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            // Passing query string to prepareStatment so that it can be executed later.
            // We must pass Statement.RETURN_GENERATED_KEYS in order to get the newly generated ID.
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            // Set the values of the ?'s to the data we want to save.
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            // Once the values have been set, we execute the update.
            stmt.executeUpdate();
            // We use the stmt.getGeneratedKeys() to return the newly generated ID and set to our ResultSet.
            ResultSet rs = stmt.getGeneratedKeys();
            // Move ResultSet cursor to next line.
            rs.next();
            // return the newly generated ID.
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        // create a new Ad instance from our ResultSet
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        // loop through all the records and add them to a List of Ad objects.
        while (rs.next()) {
            // Creating Ad objects from the ResultSet.
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
