package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соединения с БД
    public static final String url = "jdbc:mysql://localhost:3306/training_db?CreateDatabaseIfNotExists=true";
    public static final String user = "root";
    public static final String pass = "hucka_facka";

    public static Connection connection;
    private Util() {};

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException t) {
            t.printStackTrace();
            throw new RuntimeException();
        }
        return connection;
    }
}