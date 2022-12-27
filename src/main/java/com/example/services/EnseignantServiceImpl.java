package com.example.services;

import com.example.dao.EnseignantDao;
import com.example.dao.entities.Enseignant;

import java.sql.SQLException;
import java.util.List;

public class EnseignantServiceImpl implements EnseignantService{
    EnseignantDao eda;

    public EnseignantServiceImpl(EnseignantDao edao) {
        this.eda = edao;
    }

    @Override
    public void addEnseignant(Enseignant e) throws SQLException {
    eda.save(e);
    }

    @Override
    public void deleteEnseignant(Enseignant e) throws SQLException {
    eda.Delete(e);
    }

    @Override
    public List<Enseignant> getAllEnseignants() throws SQLException {
        return eda.findAll();
    }
}
