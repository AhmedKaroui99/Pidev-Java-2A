/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author SBS
 */
public class Associe extends User{
    private String nom;
    private String prenom;
    private String type;
    private String description;
    private String longitude;
    private String latitude;
    private int contactTel;
    private String contactMail;
    private int nbreMaxClientParJours;

    public Associe() {
    }

    public Associe(String nom, String prenom, String type, String description, String longitude, String latitude, int contactTel, String contactMail, int nbreMaxClientParJours) {
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.contactTel = contactTel;
        this.contactMail = contactMail;
        this.nbreMaxClientParJours = nbreMaxClientParJours;
    }

    public Associe(String nom, String prenom, String type, String description, String longitude, String latitude, int contactTel, String contactMail, int nbreMaxClientParJours, int id, String email, String password, String role) {
        super(id, email, password, role);
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.contactTel = contactTel;
        this.contactMail = contactMail;
        this.nbreMaxClientParJours = nbreMaxClientParJours;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getContactTel() {
        return contactTel;
    }

    public void setContactTel(int contactTel) {
        this.contactTel = contactTel;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public int getNbreMaxClientParJours() {
        return nbreMaxClientParJours;
    }

    public void setNbreMaxClientParJours(int nbreMaxClientParJours) {
        this.nbreMaxClientParJours = nbreMaxClientParJours;
    }

    @Override
    public String toString() {
        return "Associe{" + "nom=" + nom + ", prenom=" + prenom + ", type=" + type + ", description=" + description + ", longitude=" + longitude + ", latitude=" + latitude + ", contactTel=" + contactTel + ", contactMail=" + contactMail + ", nbreMaxClientParJours=" + nbreMaxClientParJours + '}';
    }

    


    
}
