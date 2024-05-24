package org.example.schoolmanager.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.schoolmanager.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private Button add_button;

    @FXML
    private String user1;

    @FXML
    private Text user;

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public void redirection() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("addForm.fxml")));
        Stage stg = new Stage();

        stg.initStyle(StageStyle.TRANSPARENT);

        Scene scn = new Scene(root);
        stg.setScene(scn);
        stg.show();
    }

    public void close() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        user.setText(getUser1());
    }
}
