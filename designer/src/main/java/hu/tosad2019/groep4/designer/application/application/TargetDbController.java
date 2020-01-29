package hu.tosad2019.groep4.designer.application.application;

import hu.tosad2019.groep4.designer.dataaccess.storage.DbConnection;
import hu.tosad2019.groep4.designer.dataaccess.storage.OracleDbConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TargetDbController {
    public static boolean testConnection(TargetDbContext targetDbContext){
        DbConnection dbConnection;

        if (targetDbContext.getDataBaseType().equals("Oracle")){
            dbConnection = new OracleDbConnection(targetDbContext.getHostname(), targetDbContext.getPort());
            dbConnection.SetCredentials(targetDbContext.getUsername(), targetDbContext.getPassword());

            try{
                Connection connection = dbConnection.getConnection();
                if (!connection.isClosed())
                    return true;
            }
            catch (SQLException exception){
                return false;
            }
        }

        return false;
    }
}
