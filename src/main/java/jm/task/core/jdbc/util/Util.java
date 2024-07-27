package jm.task.core.jdbc.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String URL = dotenv.get("URL");
    private static final String USER = dotenv.get("USER");
    private static final String PASSWORD = dotenv.get("PASSWORD");

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error establishing database connection: " + e.getMessage(), e);
        }

        return connection;
    }
}
