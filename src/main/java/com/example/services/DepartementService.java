package com.example.services;

import com.example.dao.entities.Departement;
import com.example.dao.entities.Enseignant;

import java.sql.SQLException;
import java.util.List;

public interface DepartementService {

    void addDepartement(Departement e) throws SQLException;

     void deleteDepartement(Departement e) throws SQLException;

    List<Departement> getAllDepartements() throws SQLException;
}
