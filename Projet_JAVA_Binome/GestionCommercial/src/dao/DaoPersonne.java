/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Client;
import models.Personne;
import models.Profil;
import models.Users;

/**
 *
 * @author Couty
 */
public class DaoPersonne implements IDao <Personne> {

     private final String 
            SQL_SELECT_BY_COMMANDE="select "
            + " p.id,nom_complet,"
            + " id_commande,id_article,"
            + " from personne p,commande cmd ,article acl"
            + " where id_commande=?,id_article=?"
            + " and id.cmd=p.id_commande,id.acl=p.id_article";
    private final String SQL_INSERT_CLIENT="INSERT INTO `personne` (  `nom_complet`, `id_commande`,`id_article`) VALUES (?,?,?);";  
    private final String SQL_INSERT_USERS="INSERT INTO `personne` ( `login`,`pwd`) VALUES (?,?);";    
    
    //private final String SQL_INSERT="INSERT INTO `personne` (`nom_complet`, `type`, `tuteur`, `modules`, `grade`, `classe_id`)"
      //      + " VALUES (?,?,?,?,?,?)";
    private final String 
            SQL_SELECT_USERS="select * from personne"
                                  + " where profil=?";
    private final String SQL_SELECT_ALL_USERS="select * from personne where 'Users'";
    private final String SQL_SELECT_CONNECT="select * from personne where login=? and pwd=?";
    private DaoSql sql;
    public DaoPersonne() {
        sql=new DaoSql();
    }
    
    public List<Users> findByProfil(Profil profil){
          List<Users> lUsers=new ArrayList<>();
         
        try {
            //1 Ouvrir la Connexion
           sql.ouvrirConnexionBD();
         //2- Preparer la requete
           sql.preparerRequete(SQL_SELECT_BY_COMMANDE);
           sql.getPs().setInt(1, Commande.getcmd());
          //Execution de la requete
           ResultSet rs=sql.executeSelect();
           //Recuperation des informations de la requete
           while(rs.next()){
               //Donnée Client
               Client clt=new Client();
               clt.setNom_complet(rs.getString("nom_complet"));
               clt.setId(rs.getInt("id"));
               clt.setTelephone(rs.getInt("telephone"));
               clt.setAdresse(rs.getString("adresse"));
               //Recuperation des donnees de la classe
               Commande cmd=new Commande();
               cl.setId(rs.getInt("classe_id"));
               cl.setLibelle(rs.getString("libelle"));
               cl.setNbre(rs.getInt("nbre"));
              //Faire la relation
                etu.setCl(cl);
              //Ajouter l'etudiant dans la Liste  
                lEtudiants.add(etu);
           }
        } catch (SQLException ex) {
            System.err.println("Erreur D'execution de requete");
        }finally{
            mysql.closeConnexion();
        }
        return lEtudiants;
    }
    public Professeur findProfesseurByMatricule(String matricule){
          Professeur professeur=null;
          
        try {
            //1 Ouvrir la Connexion
             mysql.ouvrirConnexionBD();
            //2- Preparer la requete
             mysql.preparerRequete(SQL_SELECT_PROFESSEUR);
             mysql.getPs().setString(1, matricule);
             ResultSet rs=mysql.executeSelect();
             if(rs.next()){
                 professeur=new Professeur();
                 professeur.setId(rs.getInt("id"));
                 professeur.setNomComplet(rs.getString("nom_complet"));
                 professeur.setGrade(rs.getString("grade"));
                 professeur.setMatricule(rs.getString("matricule"));
                 professeur.setModules(
                         Convert.stringToList
                          (rs.getString("modules"))
                 );
             }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       return professeur;
   }
 
 public List<Professeur> findProfesseur(){
     List<Professeur> lProfesseurs=new ArrayList();
     //Recuperation des Professeur
     return lProfesseurs;
 }
   
public Personne findUserConnect(String login,String pwd) {
    Personne pers=null;
    mysql.ouvrirConnexionBD();
    mysql.preparerRequete(SQL_SELECT_CONNECT);
        try {
            mysql.getPs().setString(1, login);
            mysql.getPs().setString(2, pwd);
            ResultSet rs=mysql.executeSelect();
            if(rs.next()){
                if(rs.getString("type").trim().compareTo("Etudiant")==0){
                   pers=new Etudiant(rs.getString("tuteur"));
                }else{
                    if(rs.getString("type").trim().compareTo("Professeur")==0){
                    pers=new Professeur();
                    //DownCasting
                     ((Professeur)pers).setGrade(rs.getString("grade"));
                        ((Professeur)pers).setMatricule(rs.getString("matricule"));
                        ((Professeur)pers).setModules(
                         Convert.stringToList
                          (rs.getString("modules"))
                        );
                    }else{
                        pers=new Admin();
                    }
                }
                //Commun
                 pers.setId(rs.getInt("id"));
                 pers.setNomComplet(rs.getString("nom_complet"));
                 pers.setLogin(rs.getString("login"));
                 pers.setPwd(rs.getString("pwd"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
    return pers;
    
}
    
    
    
    
    //public int insert(Personne pers){
    //    int nbreLigne=0;
        //Traitement Insertion
      //  return nbreLigne;
     public int insertEtudiant(Etudiant etu){
       int nbreLigne=0;
       //Traitement Insertion
        try {
           //1-chargement du driver etouvrir connexion
           mysql.ouvrirConnexionBD();
           //preparer la requete
           mysql.preparerRequete(SQL_INSERT_ETUDIANT);
           //(facultative) Remplacer les variables de la requete par les valeurs
           //un objet vers la base de données
           mysql.getPs().setString(1, etu.getType());
            mysql.getPs().setString(2, etu.getNomComplet());
             mysql.getPs().setString(3, etu.getTuteur());
              mysql.getPs().setInt(4, etu.getCl().getId());
           //Executer la requete
           //insert,select,update
           nbreLigne=mysql.executeMisAJour();
       } catch (SQLException ex) {
           Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           mysql.closeConnexion();
       }
       return nbreLigne;  
       
   }
     public int insertProfesseur(Professeur prof){
       int nbreLigne=0;
       //Traitement Insertion
        try {
           //1-chargement du driver etouvrir connexion
           mysql.ouvrirConnexionBD();
           //preparer la requete
           mysql.preparerRequete(SQL_INSERT_PROFESSEUR);
           //(facultative) Remplacer les variables de la requete par les valeurs
           //un objet vers la base de données
           mysql.getPs().setString(1, prof.getType());
            mysql.getPs().setString(2, prof.getNomComplet());
             mysql.getPs().setString(3, prof.getGrade());
              mysql.getPs().setString(4, Convert.listToString(prof.getModules()));
             mysql.getPs().setString(5, prof.getMatricule());
             
           //Executer la requete
           //insert,select,update
           nbreLigne=mysql.executeMisAJour();
       } catch (SQLException ex) {
           Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           mysql.closeConnexion();
       }
       return nbreLigne;
       
   }

    @Override
    public int insert(Personne objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int insertUsers(Users usr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Users> findByProfil(Profil profil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
  }
    
}
