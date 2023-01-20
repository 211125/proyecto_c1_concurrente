module com.example.proyecto_c1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyecto_c1 to javafx.fxml;
    exports com.example.proyecto_c1;
}