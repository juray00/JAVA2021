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
public class Client extends Personne {
    private int telephone;
    private String adresse;
     //ManyToOne
   private Commande cmd;
    private Profil pf;
    

    public Client() {
    }

    public Client(int telephone, String adresse, String nom_complet) {
        super(nom_complet);
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public Client(int telephone, String adresse, int id, String nom_complet) {
        super(id, nom_complet);
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public Client(int telephone, String adresse) {
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Commande getCmd() {
        return cmd;
    }

    public void setCmd(Commande cmd) {
        this.cmd = cmd;
    }

    public Profil getPf() {
        return pf;
    }

    public void setPf(Profil pf) {
        this.pf = pf;
    }

    @Override
    public String toString() {
        return super.toString ()+"Client{" + "telephone=" + telephone + ", adresse=" + adresse + ", cmd=" + cmd + ", pf=" + pf + '}';
    }

   

  
    
    
}
