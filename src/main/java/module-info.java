module org.example.schoolmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.schoolmanager to javafx.fxml;
    exports org.example.schoolmanager;

    opens org.example.schoolmanager.Controllers to javafx.fxml;
    exports org.example.schoolmanager.Controllers;
}