package org.example.schoolmanager.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.schoolmanager.HelloApplication;
import org.example.schoolmanager.IDBConfig.DatabaseDB;
import org.example.schoolmanager.models.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionController {

    @FXML
    private Button close;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button signIn_btn;

    @FXML
    private TextField signIn_email;

    @FXML
    private PasswordField signIn_password;

    private double x = 0;
    private double y = 0;

    public void signUp() throws IOException {
        signIn_btn.getScene().getWindow().hide(); //Pour cacher la fenêtre

        //Pour fermer la fenêtre
//        Stage initial = (Stage) signIn_btn.getScene().getWindow();
//        initial.close();

        // Liaison de la fenêtre d'acceuil
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("inscription.fxml")));
        Stage stg = new Stage();

        stg.initStyle(StageStyle.TRANSPARENT);

        Scene scn = new Scene(root);
        stg.setScene(scn);
        stg.show();
    }

    @FXML
    public void AdminLogin() {

        User eleve = new User();

        try {

            Alert alert;

            eleve.userSignIn(eleve);

            if (signIn_email.getText().isEmpty() || signIn_password.getText().isEmpty()) { // si on ne rempli pas l'un des deux champ

                //Une alerte de type ERREUR
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("S'il vous plait, remplir tout les champs");
                alert.showAndWait();

            } else {

                eleve.userSignIn(eleve);

                //Pour fermer la fenêtre
                Stage initial = (Stage) signIn_password.getScene().getWindow();
                initial.close();

                // Liaison de la fenêtre d'acceuil
                Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("dashboard.fxml")));
                Stage stg = new Stage();

                stg.initStyle(StageStyle.TRANSPARENT);

                Scene scn = new Scene(root);
                stg.setScene(scn);
                stg.show();

            }

        } catch (SQLException | IOException e ) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void AdminLoginkey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            AdminLogin(); //La methode s'execute l'orsqu'on appuie sur la touche ENTRER
        }
    }

    @FXML
    public void close(MouseEvent event) {
        System.exit(0);
    }

}
