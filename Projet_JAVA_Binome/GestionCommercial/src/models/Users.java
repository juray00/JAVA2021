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
public class Users extends Personne {
    private String pwd;
    private String login;
    private Profil pf;

    public Users(String pwd, String login, String nom_complet) {
        super(nom_complet);
        this.pwd = pwd;
        this.login = login;
    }

    public Users(String pwd, String login, int id, String nom_complet) {
        super(id, nom_complet);
        this.pwd = pwd;
        this.login = login;
    }

    public Users(String pwd, String login) {
        this.pwd = pwd;
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Profil getPf() {
        return pf;
    }

    public void setPf(Profil pf) {
        this.pf = pf;
    }

    @Override
    public String toString() {
        return super.toString()+ "Users{" + "pwd=" + pwd + ", login=" + login + ", pf=" + pf + '}';
    }

   
    
    
}
