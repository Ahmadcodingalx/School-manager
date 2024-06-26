package org.example.schoolmanager.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.schoolmanager.HelloApplication;
import org.example.schoolmanager.IDBConfig.DatabaseDB;
import org.example.schoolmanager.models.Students;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

public class AddFormController {

    @FXML
    private DatePicker info_DOB;

    @FXML
    private TextField info_FN;

    @FXML
    private TextField info_POB;

    @FXML
    private TextField info_S;

    @FXML
    private TextField info_SN;

    @FXML
    private Button info_save;

    public void addStudent() {

        String name = info_SN.getText().trim();
        String prenom = info_FN.getText().trim();
        String date = String.valueOf(info_DOB.getValue());
        String lieu = info_POB.getText().trim();
        String etat = info_S.getText().trim();

        Students eleve = new Students();
        eleve.setNom(name);
        eleve.setPrenom(prenom);
        eleve.setNaissance(date);
        eleve.setLieuDeNaissance(lieu);
        eleve.setEtat(etat);

        try {

            Alert alert;

            if (info_FN.getText().isEmpty() || info_SN.getText().isEmpty() || String.valueOf(info_DOB.getValue()).isEmpty() || info_POB.getText().isEmpty() || info_S.getText().isEmpty()) { // si on ne rempli pas l'un des deux champ

                //Une alerte de type ERREUR
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("S'il vous plait, remplir tout les champs");
                alert.showAndWait();


            } else {
                eleve.studentAdd(eleve);
            }

        } catch (SQLException e ) {
            throw new RuntimeException(e);
        }

        reset();

    }

    public void close() throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("dashboard.fxml")));
        Stage stg = new Stage();

        Stage initial = (Stage) info_save.getScene().getWindow();
        initial.close();

        stg.initStyle(StageStyle.TRANSPARENT);

        Scene scn = new Scene(root);
        stg.setScene(scn);
        stg.show();
    }

    public void reset() {

        info_FN.setText("");
        info_DOB.setValue(LocalDate.ofEpochDay(0));
        info_POB.setText("");
        info_S.setText("");
        info_SN.setText("");

    }

}
