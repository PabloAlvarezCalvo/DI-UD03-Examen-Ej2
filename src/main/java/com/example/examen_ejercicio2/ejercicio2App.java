package com.example.examen_ejercicio2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ejercicio2App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ejercicio2App.class.getResource("vistaprincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 470);
        stage.setTitle("Venta Billetes Tren!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}