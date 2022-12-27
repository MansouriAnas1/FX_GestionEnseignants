package com.example.dao.entities;

import java.io.Serializable;

public class Enseignant implements Serializable {
    private int ID;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;

    public Enseignant() {};

    public Enseignant(String nom, String prenom, String adresse, String téléphone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = téléphone;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTéléphone(String téléphone) {
        this.telephone = téléphone;
    }

    public int getID() {
        return ID;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTéléphone() {
        return telephone;
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "ID=" + ID +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
