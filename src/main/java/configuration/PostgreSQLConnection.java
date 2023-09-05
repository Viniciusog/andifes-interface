/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author vinij
 */
public class PostgreSQLConnection {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    private static final String url = "jdbc:postgresql://localhost:5432/andifes";
    private static final String user = "postgres";
    private static final String password = "root";
    
    //Connect to mustache database on MySQL
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = (Connection) DriverManager.getConnection(url, user, password); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection error: " + e.getMessage());
        }
        return con;
    }
}
