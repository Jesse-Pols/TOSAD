package hu.tosad2019.groep4.generator.dataaccess.dbaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseExecution {
    DbConnection dbConnection;
    public DatabaseExecution(DbConnection connection){
        dbConnection = connection;
    }

    public boolean execute(String trigger) {
        boolean result = true;

        Connection connection = null;

        try {
            connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();

            statement.execute(trigger);
            connection.close();
        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }
}