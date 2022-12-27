package com.example.dao;

import com.example.dao.entities.Enseignant;

import java.util.List;

public interface EnseignantDao extends dao<Enseignant> {
    List<Enseignant> findEnseignantByMc();
}
