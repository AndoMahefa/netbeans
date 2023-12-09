/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import models.Utilisateur;
import utils.Connexion;

/**
 *
 * @author razaf
 */
public class UtilisateurService {
    public static void save(Utilisateur utilisateur, Connection connexion) throws Exception {
        PreparedStatement state = null;
        String requete = "insert into utilisateur  values (default, ?, ?)";
        try {
            if(connexion == null) {
                connexion = Connexion.getConnexion();
            }
           state = connexion.prepareStatement(requete);

           state.setString(1, utilisateur.getEmail());
           state.setString(2, utilisateur.getMotdepasse());
                
                System.out.println(requete);
                state.execute();
           } catch (Exception e) {
                e.printStackTrace();
           } finally {
                if(state != null) state.close();
                if(connexion != null) connexion.close();
           }
     }
    
    public static ArrayList<Utilisateur> findall(Connection connexion) throws Exception {
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        Statement state = null;
        ResultSet res = null;
        try {
            if(connexion == null) connexion = Connexion.getConnexion();
            String sql = "select * from utilisateur";
            state = connexion.createStatement();
            res = state.executeQuery(sql);
            while(res.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(res.getInt("id"));
                utilisateur.setEmail(res.getString("email"));
                utilisateur.setMotdepasse(res.getString("motdepasse"));
                
                utilisateurs.add(utilisateur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(res != null) res.close();
            if(state != null) state.close();
            if(connexion != null) connexion.close();
        }
        
        return utilisateurs;
    }
    
    public static void main(String[] args) {
        try {
            ArrayList<Utilisateur> utilisateurs = UtilisateurService.findall(null);
            for(Utilisateur utilisateur : utilisateurs) {
                System.out.println(utilisateur.getId()+" "+utilisateur.getEmail()+" "+utilisateur.getMotdepasse());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    }
}
