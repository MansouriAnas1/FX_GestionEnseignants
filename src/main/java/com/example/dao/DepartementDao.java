package com.example.dao;

import com.example.dao.entities.Departement;
import com.example.dao.entities.Enseignant;

import java.util.List;

public interface DepartementDao extends dao<Departement> {
    List<Departement> findDepartementByMc();
}
