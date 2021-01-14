/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.Liste;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class Exercice1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        1- créer une liste de string
        2- ajouter des elements
        3- supprimer des elements
        4- affichage de la liste 
        5- modifier un element de la liste 
        6- rechercher un element de la liste
        */
       //1- créer une liste de string
       List<String> lString=new ArrayList();
       
       //2- ajouter des elements
       lString.add ("Bonjour");
       lString.add ("Au Revoir");
       lString.add ("les Etudiants de la liage 3");
      
       //3- supprimer des elements
       //Methode1
         for(String elt:lString){
           System.out.println(elt);
       }
       lString.add(0, "Debut");
       lString.forEach((elt) -> {
           System.out.println(elt);
        });
       //4-affichage de la liste 
       lString.remove("Debut");
       lString.remove(2);
       System.out.println("Affichage apres suppression");
       lString.forEach((elt) -> {
           System.out.println(elt);
        });
       //5- modifier un element de la liste 
       lString.set(0,"Bonsoir");
        System.out.println("Affichage apres modification");
       lString.forEach((elt) -> {
           System.out.println(elt);
        });
       //6- rechercher un element de la liste
       if(lString.contains("Bonsoir")==true){
        System.out.println("Element existe");
       }else{
           System.out.println("Element existe pas");
    }
    
    }
}