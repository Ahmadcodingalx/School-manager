package org.example.schoolmanager.models;

import org.example.schoolmanager.IDBConfig.DatabaseDB;
import org.example.schoolmanager.Interfaces.StudentInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Students implements StudentInterface {
    private String nom;
    private String prenom;
    private String naissance;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public String getLieuDeNaissance() {
        return lieuDeNaissance;
    }

    public void setLieuDeNaissance(String lieuDeNaissance) {
        this.lieuDeNaissance = lieuDeNaissance;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    private String lieuDeNaissance;
    private String etat;

    @Override
    public void studentAdd(Students eleve) throws SQLException {

        String sql = "INSERT INTO student (firstname, lastname, dateOfBirth, placeOfBirth, state) VALUES (?, ?, ?, ?, ?)";
        Connection connection = DatabaseDB.connectDB();

//        assert connection != null;
        assert connection != null;
        PreparedStatement prepStat = connection.prepareStatement(sql);
        prepStat.setString(1, eleve.getNom());
        prepStat.setString(2, eleve.getPrenom());
        prepStat.setString(3, eleve.getNaissance());
        prepStat.setString(4, eleve.getLieuDeNaissance());
        prepStat.setString(5, eleve.getEtat());

        prepStat.executeUpdate();
    }
}
