package by.alexkrug.model.database.connection;

import by.alexkrug.model.database.tools.PropertiesTool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static Connection connection;
    private static final String URL = "db.url";
    private static final String USER = "db.user";
    private static final String PASSWORD = "db.password";

    private ConnectionManager() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            PropertiesTool propertiesTool = new PropertiesTool();
            Properties properties = propertiesTool.PROPERTIES;
            try {
                connection = DriverManager.getConnection(
                        properties.getProperty(URL),
                        properties.getProperty(USER),
                        properties.getProperty(PASSWORD)
                );
                return connection;

            } catch (SQLException e) {
                System.out.println(e.getStackTrace());
            }
        }
        return connection;
    }
}
