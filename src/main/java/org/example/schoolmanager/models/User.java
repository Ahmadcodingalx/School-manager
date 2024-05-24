package org.example.schoolmanager.models;

import javafx.scene.control.Alert;
import org.example.schoolmanager.IDBConfig.DatabaseDB;
import org.example.schoolmanager.Interfaces.UserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements UserInterface {

    private String email;
    private String password;

    private Connection connection;


    private PreparedStatement prepStat;

    @Override
    public void userSignUp(User user) throws SQLException {

        String sql = "INSERT INTO user (email, password) VALUES (?, ?)";
        connection = DatabaseDB.connectDB();

        assert connection != null;
        prepStat = connection.prepareStatement(sql);
        prepStat.setString(1, user.getEmail());
        prepStat.setString(2, user.getPassword());

        prepStat.executeUpdate();
    }

    @Override
    public void userSignIn(User user) throws SQLException {

        String sqlReq = "SELECT * FROM user WHERE email = ? AND password = ?";
        connection = DatabaseDB.connectDB();

        assert connection != null;
        prepStat = connection.prepareStatement(sqlReq);
        prepStat.setString(1, user.getEmail());
        prepStat.setString(2, user.getPassword());

        ResultSet resultSet = prepStat.executeQuery();

        Alert alert;

        try {
            if (resultSet.next()) { // si le mot de passe et le nom d'utilisateur sont corrects

//            DashboardController dashboardController = new DashboardController();
//            dashboardController.setUser1(signIn_email.getText());

                //Une alerte de type INFORMATION
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message d'information");
                alert.setHeaderText(null);
                alert.setContentText("Connexion réussie!");
                alert.showAndWait();

                //signIn_btn.getScene().getWindow().hide(); //Pour cacher la fenêtre

            } else { // si le mot de passe et le nom d'utilisateur ne sont pas corrects

                //Une alerte de type ERREUR
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("nom d'utilisateur ou mot de passe incorrect");
                alert.showAndWait();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
