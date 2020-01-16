package hu.tosad2019.groep4.generator.dataaccess;

import hu.tosad2019.groep4.generator.datainfrastructure.DbConnection;
import hu.tosad2019.groep4.generator.datainfrastructure.OracleDbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TriggerCreation {
    String hostName;
    public TriggerCreation(String dbHostname){
        this.hostName = dbHostname;
    }

    public boolean apply(String trigger) throws SQLException {
        boolean result;


        DbConnection dbConnectionObject = new OracleDbConnection(hostName);
        Connection connection = null;

        connection = dbConnectionObject.getConnection();

        Statement statement = connection.createStatement();

        result = statement.execute(trigger);
        connection.commit();
        connection.close();


        return result;
    }
}
