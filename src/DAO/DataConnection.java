package DAO;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataConnection {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String server = "LAPTOP-PDOUEGSA\\SQLEXPRESS";
            String user = "sa";
            String password = "02587169";
            String db = "QLCaPhe";
            int port = 1433;
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setServerName(server);
            ds.setUser(user);
            ds.setPassword(password);
            ds.setPortNumber(port);
            ds.setDatabaseName(db);
            ds.setTrustServerCertificate(true);
            connection = ds.getConnection();
            System.out.println("Ket noi thanh cong");
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        connection = null;
    }
}
