package com.example.dao;

import com.example.dao.entities.Enseignant;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnseignantDaoImpl implements EnseignantDao {
    @Override
    public List<Enseignant> findAll() throws SQLException {
        System.out.println("im here");
        Connection connection = SingletonConnexionDB.getConnection();
        System.out.println("im now here");
        PreparedStatement stm = connection.prepareStatement("select * from ENSEIGNANT");
        ResultSet rs = stm.executeQuery();
        List<Enseignant> enseignants = new ArrayList<>();
        while (rs.next()) {
            Enseignant e = new Enseignant();
            e.setID(rs.getInt("ID"));
            e.setNom(rs.getString("nom"));
            e.setPrenom(rs.getString("prenom"));
            e.setAdresse(rs.getString("adresse"));
            e.setTéléphone(rs.getString("telephone"));
            System.out.println(e);
            enseignants.add(e);
        }

        return enseignants;
    }

    @Override
    public Enseignant findOne(int id) throws SQLException {

        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select * from ENSEIGNANT where ID=?");
        stm.setInt(1,id);
        ResultSet rs = stm.executeQuery();
        Enseignant e =null;
        if(rs.next()) {
            e.setID(rs.getInt("ID"));
            e.setNom(rs.getString("nom"));
            e.setPrenom(rs.getString("prenom"));
            e.setAdresse(rs.getString("adresse"));
            e.setTéléphone(rs.getString("telephone"));
        }
        return e;
    }

    @Override
    public Enseignant save(Enseignant e) throws SQLException {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("insert into ENSEIGNANT(NOM,PRENOM,ADRESSE,TELEPHONE)" +
                " values (?,?,?,?)");

        stm.setString(1,e.getNom());
        stm.setString(2,e.getPrenom());
        stm.setString(3,e.getAdresse());
        stm.setString(4,e.getTéléphone());

        stm.executeUpdate();
        return e;
    }

    @Override
    public boolean Delete(Enseignant o)  {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("delete from ENSEIGNANT where ID=?");
            stm.setInt(1,o.getID());
            stm.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;

    }

    @Override
    public Enseignant update(Enseignant o) throws SQLException {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("update ENSEIGNANT set NOM=?,PRENOM=?,ADRESSE=?,TELEPHONE=? where ID=?");

        stm.setString(1,o.getNom());
        stm.setString(2,o.getPrenom());
        stm.setString(3,o.getAdresse());
        stm.setString(4,o.getTéléphone());
        stm.setInt(5,o.getID());

        stm.executeUpdate();
        return o;
    }

    @Override
    public List<Enseignant> findEnseignantByMc() {
        return null;
    }
}
