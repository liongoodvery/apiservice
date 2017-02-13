package org.lion.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by lion on 2/13/17.
 */
public class JdbcUtils {

    private static final String db_username;
    private static final String db_password;
    private static final String db_driver;
    private static final String db_host;
    private static final String db_port;
    private static final String db_name;

    static {
        db_username = ResourceBundle.getBundle("jdbc").getString("db_username");
        db_password = ResourceBundle.getBundle("jdbc").getString("db_password");
        db_driver = ResourceBundle.getBundle("jdbc").getString("db_driver");
        db_host = ResourceBundle.getBundle("jdbc").getString("db_host");
        db_port = ResourceBundle.getBundle("jdbc").getString("db_port");
        db_name = ResourceBundle.getBundle("jdbc").getString("db_name");
    }

    static {
        try {
            Class.forName(db_driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection openConnection() throws SQLException {
       return DriverManager.getConnection(phaseConnectUrl(), db_username, db_password);
    }

    private static String phaseConnectUrl() {
        return String.format("jdbc:mysql://%s:%s/%s", db_host, db_port, db_name);
    }

    public static void close(AutoCloseable closeable){
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(ResultSet rs, Statement st,Connection conn) {
        close(rs);
        close(st);
        close(conn);
    }
}
