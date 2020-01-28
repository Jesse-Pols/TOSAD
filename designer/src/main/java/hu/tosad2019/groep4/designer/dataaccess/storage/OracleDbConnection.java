package hu.tosad2019.groep4.designer.dataaccess.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDbConnection implements DbConnection {
    private final String baseConnectionString = "jdbc:oracle:@";
    private String connectionString = "jbdc:oracle:thin@localhost:1521:xe";

    public OracleDbConnection(){
        String hostName = "localhost";
        this.connectionString = baseConnectionString + hostName + ":1521:xe";
    }

    public OracleDbConnection(String connectionString){
        this.connectionString = connectionString;
    }

    public Connection getConnection(String userName, String password) throws SQLException {
        return DriverManager.getConnection(connectionString, userName, password);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString);
    }
}
