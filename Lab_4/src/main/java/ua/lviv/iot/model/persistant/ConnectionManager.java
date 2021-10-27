package ua.lviv.iot.model.persistant;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor
public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/patients_data?allowPublicKeyRetrieval=true&" +
            "createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "maks040403";

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            }
        }
        return connection;
    }

}
