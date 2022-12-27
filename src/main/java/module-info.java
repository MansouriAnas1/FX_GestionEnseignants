module com.example.fx_gestionmagasin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.presentation to javafx.fxml;
    exports com.example.presentation;
}