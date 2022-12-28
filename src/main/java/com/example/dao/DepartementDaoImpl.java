package com.example.dao;

import com.example.dao.entities.Departement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartementDaoImpl implements DepartementDao {
    @Override
    public List<Departement> findAll() throws SQLException {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select * from DEPARTEMENT");
        ResultSet rs = stm.executeQuery();
        List<Departement> departements = new ArrayList<>();
        while (rs.next()) {
            Departement e = new Departement();
            e.setId(rs.getInt("id"));
            e.setNom(rs.getString("nom"));
            departements.add(e);
        }
        return departements;
    }

    @Override
    public Departement findOne(int id) throws SQLException {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select * from DEPARTEMENT where ID=?");
        stm.setInt(1,id);
        ResultSet rs = stm.executeQuery();
        Departement e =null;
        if(rs.next()) {
            e.setId(rs.getInt("ID"));
            e.setNom(rs.getString("nom"));
        }
        return e;
    }

    @Override
    public Departement save(Departement o) throws SQLException {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("insert into DEPARTEMENT(NOM)" +
                " values (?)");

        stm.setString(1,o.getNom());

        stm.executeUpdate();
        return o;
    }

    @Override
    public boolean Delete(Departement o) throws SQLException {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("delete from DEPARTEMENT where ID=?");
            stm.setInt(1,o.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public Departement update(Departement o) throws SQLException {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("update DEPARTEMENT set NOM=? where ID=?");

        stm.setString(1,o.getNom());
        stm.setInt(2,o.getId());

        stm.executeUpdate();
        return o;
    }

    @Override
    public List<Departement> findDepartementByMc() {
        return null;
    }
}
