/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ahmed
 */
public class Commentaire {
    private int idcommentaire;
    private int clientid;
    private String contenucommentaire;
    private String datecommentaire;
    

    public Commentaire() {
    }
    public Commentaire(int id) {
        this.idcommentaire = idcommentaire;
    }
    public Commentaire(int idcommentaire,int clientid,String contenucommentaire,String datecommentaire) {
        this.idcommentaire = idcommentaire;
        this.clientid=clientid;
        this.contenucommentaire= contenucommentaire;;
        this.datecommentaire=datecommentaire;
    }

     public Commentaire(String contenucommentaire) {
        this.contenucommentaire=contenucommentaire; 
       
//To change body of generated methods, choose Tools | Templates.
    }
    
    public Commentaire(String contenucommentaire,String datecommentaire) {
        this.contenucommentaire=contenucommentaire; 
        this.datecommentaire=datecommentaire;
//To change body of generated methods, choose Tools | Templates.
    }
     public Commentaire(int idclient,String contenucommentaire,String datecommentaire){
        this.clientid=1;
        this.contenucommentaire=contenucommentaire; 
        this.datecommentaire=datecommentaire;
//To change body of generated methods, choose Tools | Templates.
    }
    
   

    public int getClientid() {
        return clientid;
    }

    public String getContenucommentaire() {
        return contenucommentaire;
    }

    public String getDatecommentaire() {
        return datecommentaire;
    }

    public int getIdcommentaire() {
        return idcommentaire;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public void setContenucommentaire(String contenu_commentaire) {
        this.contenucommentaire = contenucommentaire;
    }

    public void setDatecommentaire(String datecommentaire) {
        this.datecommentaire = datecommentaire;
    }

    public void setIdcommentaire(int idcommentaire) {
        this.idcommentaire = idcommentaire;
    }
}
