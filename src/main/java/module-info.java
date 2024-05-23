module org.example.schoolmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.schoolmanager to javafx.fxml;
    exports org.example.schoolmanager;
}