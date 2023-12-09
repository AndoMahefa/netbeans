/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author razaf
 */
public class Connexion {
    public static Connection getConnexion() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "4010355"); 
            System.out.println("connecte");
        } catch(Exception e) {
            System.out.println(e);
        }
        return con;
    }
   
   public static void main(String[] args) {
       Connexion.getConnexion();
   }
}
