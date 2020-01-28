package hu.tosad2019.groep4.generator.dataaccess.dbaccess;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {
    public void SetCredentials(String username, String password);

    public Connection getConnection() throws SQLException;
}
