/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.DaoDetails;
import dao.DaoPersonne;
import java.util.List;
import models.Article;
import models.Client;
import models.Commande;
import models.Profil;
import models.Users;

/**
 *
 * @author Couty
 */
public class Service {
    private DaoPersonne daoPersonne;
    private DaoDetails daoDetails;
    
     public Service() {
        daoPersonne=new DaoPersonne();
        daoDetails=new DaoDetails();
    }
     
    public boolean inscrireUsers(Users usr){
           return daoPersonne.insertUsers(usr)!=0;
       }
     public List<Users> listerUsers(Profil profil){
       return daoPersonne.findByProfil(profil);
    }
     
     public boolean creerArticle(Article article){
          int nbreLigne= daoDetails.insert(article);
          return nbreLigne != 0;
     }
     public List<Article> listerArticle(){
           return daoDetails.findArticle();
       }
     public boolean creerCommande(Commande commande){
          int nbreLigne= daoDetails.insert(commande);
          return nbreLigne != 0;
     }
      public List<Commande> listerCommande(){
           return daoDetails.findCommande();
       }
     public boolean creerClient(Client client){
          int nbreLigne= daoPersonne.insert(client);
          return nbreLigne != 0;
     }
}

