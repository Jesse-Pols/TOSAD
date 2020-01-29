package hu.tosad2019.groep4.designer.dataaccess.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDbConnection implements DbConnection {
    private final String baseConnectionString = "jdbc:oracle:thin:@";
    private final String editionPart = "/xepdb1";
    private String connectionString = "jbdc:oracle:thin:@localhost:1521/xepdb1";

    private String hostName;
    private int port;
    private String username;
    private String password;


    public OracleDbConnection(){
        String hostName = "localhost";

        this.connectionString = baseConnectionString + hostName + ":1521" + editionPart;
    }

    public OracleDbConnection(String connectionString){
        this.connectionString = connectionString;
    }

    public OracleDbConnection(String hostname, int port){
        this.hostName = hostname;
        this.port = port;
        this.connectionString = baseConnectionString + hostname + ":" + port + editionPart;
    }

    @Override
    public void SetCredentials(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, username, password);

    }
}
