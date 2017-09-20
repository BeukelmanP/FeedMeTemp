/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Feedback.Feedback;
import Login.User;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
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
        DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
        String url = "jdbc:mysql://localhost:3307/streedie_profs4";
        return DriverManager.getConnection(url, "root", "usbw");
    }
}
