module org.example.schoolmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.schoolmanager to javafx.fxml;
    exports org.example.schoolmanager;

    opens org.example.schoolmanager.Controllers to javafx.fxml;
    exports org.example.schoolmanager.Controllers;

    opens org.example.schoolmanager.IDBConfig to javafx.fxml;
    exports org.example.schoolmanager.IDBConfig;
}