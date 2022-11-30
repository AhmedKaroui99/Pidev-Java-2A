/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Oasis
 */
public class rendezvous {
      private int idRdv;
    private int clientid;
    private int associeid;
    private  String date ;
    private  String etat;
    private  String Typepaiement ;
     private  Date dater ;

    public rendezvous(int idRdv, int clientid, int associeid, String date, String etat, String Typepaiement, Date dater) {
        this.idRdv = idRdv;
        this.clientid = clientid;
        this.associeid = associeid;
        this.date = date;
        this.etat = etat;
        this.Typepaiement = Typepaiement;
        this.dater = dater;
    }

    public rendezvous() {
        
    }

    public int getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(int idRdv) {
        this.idRdv = idRdv;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public int getAssocieid() {
        return associeid;
    }

    public void setAssocieid(int associeid) {
        this.associeid = associeid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getTypepaiement() {
        return Typepaiement;
    }

    public void setTypepaiement(String Typepaiement) {
        this.Typepaiement = Typepaiement;
    }

    public Date getDater() {
        return dater;
    }

    public void setDater(Date dater) {
        this.dater = dater;
    }
     
    
}
