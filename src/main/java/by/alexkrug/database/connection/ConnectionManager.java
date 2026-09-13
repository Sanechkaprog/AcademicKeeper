package by.alexkrug.database.connection;

import by.alexkrug.database.tools.PropertiesTool;

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

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            PropertiesTool propertiesTool = new PropertiesTool();
            Properties properties = propertiesTool.PROPERTIES;
            connection = DriverManager.getConnection(
                    properties.getProperty(URL),
                    properties.getProperty(USER),
                    properties.getProperty(PASSWORD)
                    );
        }
        return connection;
    }
}
