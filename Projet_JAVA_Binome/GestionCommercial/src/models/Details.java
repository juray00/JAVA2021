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
public class Details {
    private int quantite;
    private int montant;
    private Commande cmd;
    private Article acl;

    public Details() {
    }

    public Details(Commande cmd, Article acl) {
        this.cmd = cmd;
        this.acl = acl;
    }
    
    

    public Details(int quantite, int montant, Commande cmd, Article acl) {
        this.quantite = quantite;
        this.montant = montant;
        this.cmd = cmd;
        this.acl = acl;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Commande getCmd() {
        return cmd;
    }

    public void setCmd(Commande cmd) {
        this.cmd = cmd;
    }

    public Article getAcl() {
        return acl;
    }

    public void setAcl(Article acl) {
        this.acl = acl;
    }

    @Override
    public String toString() {
        return "Details{" + "quantite=" + quantite + ", montant=" + montant + ", cmd=" + cmd + ", acl=" + acl + '}';
    }

   
   
   

   
    
    
}
