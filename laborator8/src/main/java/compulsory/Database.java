package compulsory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * used to connect to a database
 */
public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/music?user=postgres&password=password";
    private static Connection connection = null;

    public Database() {
    }

    /**
     * @return the connection
     */
    public static Connection getConnection() {
        createConnection();
        return connection;
    }

    /**
     * creates a connection
     */
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * closes the connection
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
