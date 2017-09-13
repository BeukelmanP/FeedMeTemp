/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wesle
 */
public class Database {

    private java.sql.Connection conn;
    private PreparedStatement pstmt;
    private ResultSet myRs;
    
    private String server;
    private String name;
    private String username;
    private String password;
    private int port;

    public Database() {
        server = "sql11.freemysqlhosting.net";
        name = "sql11194356";
        username = "sql11194356";
        password = "YpVPS7iJwE";
        port = 3306;
    }

    /**
     * Connects with the database.
     * @return true if connected, false if failed to connect.
     */
    public boolean connectToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + server + ":" + port;
            //conn = DriverManager.getConnection("jdbc:mysql://vserver213.axc.nl:3306/lesleya213_pts?zeroDateTimeBehavior=convertToNull", "lesleya213_pts", "wachtwoord123");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("started connection to database...");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed to start connection to database...");
            return false;
        }
    }

    public java.sql.Connection getConn() {
        return this.conn;
    }

    /**
     * Closes the connection with the database
     * @return true if the connection is closed, false if it failed.
     */
    public boolean disconnectFromDB() {
        try {
            if (myRs != null) {
                myRs.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            System.out.println("Closing connection to database...");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
