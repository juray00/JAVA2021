/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Couty
 */
public class Commande {
    private int id;
    private String libelle;
    private int dateCommande;

    public Commande() {
    }

    public Commande(String libelle, int dateCommande) {
        this.libelle = libelle;
        this.dateCommande = dateCommande;
    }

    public Commande(int id, String libelle, int dateCommande) {
        this.id = id;
        this.libelle = libelle;
        this.dateCommande = dateCommande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(int dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", libelle=" + libelle + ", dateCommande=" + dateCommande + '}';
    }
    
    
}
