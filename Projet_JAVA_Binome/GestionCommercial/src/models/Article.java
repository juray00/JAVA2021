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
public class Article {
    private int id;
    private String reference;
    private int stocks;
    private int prix;

    public Article() {
    }

    public Article(String reference, int stocks, int prix) {
        this.reference = reference;
        this.stocks = stocks;
        this.prix = prix;
    }

    public Article(int id, String reference) {
        this.id = id;
        this.reference = reference;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", reference=" + reference + ", stocks=" + stocks + ", prix=" + prix + '}';
    }
    
    
}

