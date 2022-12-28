package com.example.dao.entities;

import java.io.Serializable;
import java.util.List;

public class Departement implements Serializable {
    private int id;
    private String nom;

    private List<Enseignant> enseignants;

    public Departement( String nom, List<Enseignant> enseignants) {
        this.nom = nom;
        this.enseignants = enseignants;
    }

    public Departement() {}
    public Departement(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
