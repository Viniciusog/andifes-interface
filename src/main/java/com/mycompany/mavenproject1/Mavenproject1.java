/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import com.formdev.flatlaf.FlatIntelliJLaf;
import configuration.PostgreSQLConnection;
import dao.OrientacaoDAO;
import entities.Especialista;
import java.sql.Connection;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author vinij
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Connection connection = PostgreSQLConnection.getConnection();      
        
        if (connection == null) {
            System.out.println("Erro de conexão com PostgreSQL");
        } else {
            System.out.println("Conexão realizada com sucesso.");
        }
        
        Especialista e = OrientacaoDAO.getOrientador(1);
        System.out.println(e.toString());
        
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());         
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }
        
        Frame f = new Frame();
        f.setSize(700, 500);
        f.setVisible(true);
    }
}
