 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//test comment blabla merging shit
/**
 *
 * @author wesle
 */
public class Database {
    
     private static final String url = "jdbc:mysql://studmysql01.fhict.local:3306/dbi338170";
     private static final String username = "dbi338170";
     private static final String password = "PTS4FM4";
     

    
    /**
     * Connects with the database.
     *
     * @return true if connected, false if failed to connect.
     * @throws java.sql.SQLException
     */
    public static Connection getConnection() throws SQLException {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
