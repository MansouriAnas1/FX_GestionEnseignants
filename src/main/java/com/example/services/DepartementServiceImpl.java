package com.example.services;

import com.example.dao.DepartementDao;
import com.example.dao.DepartementDaoImpl;
import com.example.dao.entities.Departement;

import java.sql.SQLException;
import java.util.List;

public class DepartementServiceImpl implements DepartementService{
    DepartementDao eda;

    public DepartementServiceImpl(DepartementDao edao) {
        this.eda = edao;
    }

    @Override
    public void addDepartement(Departement e) throws SQLException {
    eda.save(e);
    }

    @Override
    public void deleteDepartement(Departement e) throws SQLException {
    eda.Delete(e);
    }

    @Override
    public List<Departement> getAllDepartements() throws SQLException {
        return eda.findAll();
    }
}
