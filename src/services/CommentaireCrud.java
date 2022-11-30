/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Commentaire;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author Ahmed
 */
public class CommentaireCrud {
     public void addcommentaire(Commentaire c){
        try {
            String requete="INSERT INTO Commentaire (clientid,contenucommentaire,datecommentaire) VALUES ( '"+c.getClientid()+"','"+c.getContenucommentaire()+"','"+c.getDatecommentaire()+"')";
                 
            PreparedStatement pst =
                    new MyConnection().cn.prepareStatement(requete);
           
            pst.executeUpdate();
            System.out.println("Commentaire ajoutée!");
        } catch (SQLException ex) {
            Logger.getLogger(RubriqueCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
     
  public void supprimer_commentaire(int idcommentaire){
    
                                
   try {
            String requete = "DELETE FROM `commentaire` WHERE idcommentaire  ="+idcommentaire;
               
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
           
            pst.executeUpdate();
            System.out.println("Commentaire supprimée!");
        } catch (SQLException ex) {
            Logger.getLogger(RubriqueCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
  
  public void modifiercommentaire(Commentaire c){
        try {
     
                    
                    String requete="UPDATE `commentaire` SET "
               
                 
                    + "`contenucommentaire`= '"+c.getContenucommentaire()+"' WHERE idcommentaire =  "+c.getIdcommentaire()+" ";
                    
                    
                 
            PreparedStatement pst =
                    new MyConnection().cn.prepareStatement(requete);
           
            pst.executeUpdate();
            System.out.println("commentaire modifie!");
        } catch (SQLException ex) {
            Logger.getLogger(RubriqueCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    
}
