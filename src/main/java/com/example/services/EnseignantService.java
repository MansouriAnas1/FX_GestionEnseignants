package com.example.services;

import com.example.dao.entities.Enseignant;

import java.sql.SQLException;
import java.util.List;

public interface EnseignantService {

    void addEnseignant(Enseignant e) throws SQLException;

     void deleteEnseignant(Enseignant e) throws SQLException;

    List<Enseignant> getAllEnseignants() throws SQLException;
}
