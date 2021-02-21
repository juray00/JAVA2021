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
public  abstract class Personne {
    protected int id;
    protected String nom_complet;
    protected String login;
    protected String pwd;

    public Personne() {
    }

    public Personne(String nom_complet) {
        this.nom_complet = nom_complet;
    }

    public Personne(int id, String nom_complet) {
        this.id = id;
        this.nom_complet = nom_complet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_complet() {
        return nom_complet;
    }

    public void setNom_complet(String nom_complet) {
        this.nom_complet = nom_complet;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom_complet=" + nom_complet + '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    
}
