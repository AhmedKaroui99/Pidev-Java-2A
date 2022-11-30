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
public class Rubrique {
    private int associeid;
    private String titre;
    private String descriptionbreve;
    private String descriptiondetaille;
    

    public Rubrique() {
    }
    public Rubrique(int id) {
        this.associeid = associeid;
    }

    /**
     *
     * @param associeid
    
     * @param titre
     * @param descriptionbreve
     * @param descriptiondetaille
     */
    public Rubrique(int associeid,String titre,String descriptionbreve,String descriptiondetaille) {
        this.associeid = associeid;
        this.titre=titre;
        this.descriptionbreve=descriptionbreve;
        this.descriptiondetaille=descriptiondetaille;
    
}

    public int getAssocieid() {
        return associeid;
    }

    public String getDescriptionbreve() {
        return descriptionbreve;
    }

    public String getDescriptiondetaille() {
        return descriptiondetaille;
    }

    public String getTitre() {
        return titre;
    }

    public void setAssocieid(int asssocieid) {
        this.associeid = asssocieid;
    }

    public void setDescriptionbreve(String descriptionbreve) {
        this.descriptionbreve = descriptionbreve;
    }

    public void setDescriptiondetaille(String descriptiondetaille) {
        this.descriptiondetaille = descriptiondetaille;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
