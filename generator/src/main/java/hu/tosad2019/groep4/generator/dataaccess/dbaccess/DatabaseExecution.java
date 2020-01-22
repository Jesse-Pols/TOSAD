package hu.tosad2019.groep4.generator.dataaccess.dbaccess;

import hu.tosad2019.groep4.generator.dataaccess.dbaccess.DbConnection;
import hu.tosad2019.groep4.generator.dataaccess.dbaccess.OracleDbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseExecution {
    String hostName;
    public DatabaseExecution(String dbHostname){
        this.hostName = dbHostname;
    }

    public boolean execute(String trigger) {
        boolean result = false;


        DbConnection dbConnectionObject = new OracleDbConnection(hostName);
        Connection connection = null;

        try {
            connection = dbConnectionObject.getConnection();
            Statement statement = connection.createStatement();

            result = statement.execute(trigger);
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }




        return result;
    }
}