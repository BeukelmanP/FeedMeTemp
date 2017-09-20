/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Feedback.Feedback;
import Login.User;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//test comment blabla merging shit
/**
 *
 * @author wesle
 */
public class Database {

    /**
     * Connects with the database.
     *
     * @return true if connected, false if failed to connect.
     * @throws java.sql.SQLException
     */
    public static Connection getConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11194356";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection(url, "sql11194356", "YpVPS7iJwE");
            return con;
        } catch (Exception ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
