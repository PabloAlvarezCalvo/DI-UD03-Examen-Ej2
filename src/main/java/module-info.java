module com.example.examen_ejercicio1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.examen_ejercicio2 to javafx.fxml;
    opens com.example.examen_ejercicio1 to javafx.fxml;
    exports com.example.examen_ejercicio2;
    exports com.example.examen_ejercicio1;
}