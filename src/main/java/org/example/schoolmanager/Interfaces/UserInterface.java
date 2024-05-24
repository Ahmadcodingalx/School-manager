package org.example.schoolmanager.Interfaces;

import org.example.schoolmanager.models.User;

import java.sql.SQLException;

public interface UserInterface {

    void userSignUp(User user) throws SQLException;
    void userSignIn(User user) throws SQLException;

}