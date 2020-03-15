package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AnhDT
 */
public class SQLServerConnection {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "Employee";
    public static final String INTEGRATED_SECURITY = "true";

    /**
     * Get connection to MSSQL Server
     * @return Connection
     */
    protected Connection connection;

    public static Connection getConnection() {
        
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://"+HOSTNAME+":"+PORT+";"
                             + "databaseName="+DBNAME+";"
                             + "integratedSecurity=" + INTEGRATED_SECURITY;
                             
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(connectionUrl);
        }
        // Handle any errors that may have occurred.
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}