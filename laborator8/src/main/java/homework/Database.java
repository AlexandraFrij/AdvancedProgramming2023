package homework;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * used to connect to a database
 */
public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/music?user=postgres&password=password";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    private static DataSource dataSource = null;

    public Database() {
    }

    /**
     * creates connections
     *
     * @return the connection
     */
    public static synchronized Connection getConnection() throws SQLException {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(URL);
            config.setUsername(USER);
            config.setPassword(PASSWORD);
            config.setAutoCommit(false);

            dataSource = new HikariDataSource(config);
        }

        return dataSource.getConnection();
    }

    /**
     * closes the connection
     */
    public static synchronized void closeConnection() {
        if (dataSource instanceof HikariDataSource) {
            ((HikariDataSource) dataSource).close();
        }
    }
}
