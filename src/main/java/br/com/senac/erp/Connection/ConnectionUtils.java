package br.com.senac.erp.Connection;

import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author victo
 */
public class ConnectionUtils {
    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        String dbURL = "jdbc:mysql://localhost:3307/ERP";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        properties.put("serverTimezone", "UTC");
        conn = DriverManager.getConnection(dbURL, properties);
        return conn;
    }

}
