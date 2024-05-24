package org.example.schoolmanager.Interfaces;

import org.example.schoolmanager.models.Students;

import java.sql.SQLException;

public interface StudentInterface {

    void studentAdd(Students eleve) throws SQLException;

}