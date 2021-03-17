package com.example.demo.dao;

import com.example.demo.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static final String URL = "jdbc:sqlite:C:\\Users\\АбдулК\\Desktop\\demo\\identifier.sqlite";
    private static final String GET_ALL_USER_QUERY = "select * from user";

    public static List<User> getAllUsers() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        List<User> users = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement statement = connection.prepareStatement(GET_ALL_USER_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                        ));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;

    }



}
