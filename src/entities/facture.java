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
public class facture {
     private int idfacture;
    private int idRdv;
    private int clientid;
     private float montant;
      private String datef;
       private Date datefacture;

    public facture(int idfacture, int idRdv, int clientid, float montant, String datef, Date datefacture) {
        this.idfacture = idfacture;
        this.idRdv = idRdv;
        this.clientid = clientid;
        this.montant = montant;
        this.datef = datef;
        this.datefacture = datefacture;
    }

    public facture() {
       
    }

    public int getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(int idfacture) {
        this.idfacture = idfacture;
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

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getDatef() {
        return datef;
    }

    public void setDatef(String datef) {
        this.datef = datef;
    }

    public Date getDatefacture() {
        return datefacture;
    }

    public void setDatefacture(Date datefacture) {
        this.datefacture = datefacture;
    }
      
    
}
