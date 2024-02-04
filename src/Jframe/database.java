/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jframe;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author nirma
 */
public class database {
    
    // create connection to database
    
    private static String  serverName = "localhost";
    private static String  userName = "root";
    private static String  dbName = "library_information_system";
    private static Integer portNumber = 3306;
    private static String  pass = "";
    
    // Create a function to create and return the connection
    public static Connection getConnection() throws java.sql.SQLException
    {
        Connection connectdb = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(serverName);
        datasource.setUser(userName);
        datasource.setDatabaseName(dbName);
        datasource.setPortNumber(portNumber); 
        datasource.setPassword(pass);
        
        connectdb = datasource.getConnection();
        
        return connectdb;
    }

    static PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
