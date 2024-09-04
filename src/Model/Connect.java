package Model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Util.ENV;

public class Connect {
    protected static Connection conn;
    protected static Statement state;
    public static void getConnection() throws SQLException{
        conn=DriverManager.getConnection(ENV.DatabaseURL,ENV.DatabaseUser,ENV.DatabasePassword);
        state=conn.createStatement();
    }
}


