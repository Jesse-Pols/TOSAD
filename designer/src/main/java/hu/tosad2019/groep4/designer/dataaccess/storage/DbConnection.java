package hu.tosad2019.groep4.designer.dataaccess.storage;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {
    void SetCredentials(String username, String password);

    public Connection getConnection() throws SQLException;
}
