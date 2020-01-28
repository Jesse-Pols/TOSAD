package hu.tosad2019.groep4.designer.dataaccess.storage;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {
    public Connection getConnection() throws SQLException;
}
