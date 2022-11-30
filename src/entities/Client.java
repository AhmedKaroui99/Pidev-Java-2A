/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author SBS
 */
public class Client extends User {
    private int idClient;
    private String nom;
    private String prenom;
    private Date ddn;
    private String phone;

    public Client() {
    }

    public Client(String nom, String prenom, Date ddn, String phone, int id, String email, String password, String role) {
        super(id, email, password, role);
        this.nom = nom;
        this.prenom = prenom;
        this.ddn = ddn;
        this.phone = phone;
    }

    public Client(int idClient, String nom, String prenom, Date ddn, String phone) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.ddn = ddn;
        this.phone = phone;
    }

    public Client(User u, String nom, String prenom, Date ddn, String phone) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.ddn = ddn;
        this.phone = phone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDdn() {
        return ddn;
    }

    public void setDdn(Date ddn) {
        this.ddn = ddn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    
}
