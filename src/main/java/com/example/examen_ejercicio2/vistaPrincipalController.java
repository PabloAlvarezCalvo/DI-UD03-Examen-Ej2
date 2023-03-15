package com.example.examen_ejercicio2;

import com.example.examen_ejercicio1.ejercicio1App;
import com.example.examen_ejercicio2.models.Ciudad;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.channels.Selector;
import java.util.*;

public class vistaPrincipalController implements Initializable {
    @FXML
    private ListView <Ciudad> listaVistaCiudades;

    @FXML Button btnGuardar, btnMostrar, btnCancelar;

    @FXML Label lblTitulo;

    @FXML
    ComboBox<Ciudad> cbCiudadDestino;

    @FXML TextField tfNombre, tfCiudadOrigen, tfTarifa;
    @FXML CheckBox cbDesayuno, cbCena, cbComida;

    @FXML
    private final ObservableList <Ciudad> listaCiudades =
           FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listaCiudades.add(new Ciudad("Madrid", "", 150));
        listaCiudades.add(new Ciudad("Barcelona", "", 200));
        listaCiudades.add(new Ciudad("Sevilla","", 300));
        listaCiudades.add(new Ciudad("Málaga", "", 300));
        listaCiudades.add(new Ciudad("Valencia", "", 320));
        listaCiudades.add(new Ciudad("Oporto", "", 80));

        cbCiudadDestino.setItems(listaCiudades);
    }

    @FXML private void btnGuardarOnClick(){
        String mensaje;
        if (cbCiudadDestino.getSelectionModel().getSelectedIndex() >= 0) {
            mensaje = tfNombre.getText() + " ha adquirido un billete con origen " + tfCiudadOrigen.getText()
                    + " y destino " + cbCiudadDestino.getSelectionModel().getSelectedItem().getNombre()
                    + " por un precio de " + tfTarifa.getText() + "€.";
        } else {
            mensaje = "Error, no ha seleccionado ciudad de destino.";
        }

        ButtonType btnConfirmar = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Billete");
        dialog.setContentText(mensaje);
        dialog.getDialogPane().getButtonTypes().add(btnConfirmar);
        dialog.showAndWait();
    }

    @FXML private void btnMostrarOnClick() throws IOException {
        //Mostrar ejercicio 1
        FXMLLoader fxmlLoader = new FXMLLoader(ejercicio1App.class.getResource("vistaprincipal.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900, 690);
        stage.setTitle("Elige tu destino!");
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML private void btnCancelarOnClick(){
        //Limpiar datos programatico
        //No funciona o no se refleja en pantalla
        /*
        for (int i = 0; i < vbExtrasContainer.getChildren().size(); i++){
            Node node = vbExtrasContainer.getChildren().get(i);
            if (node instanceof TextField) {
                ((TextField) node).clear();
            }
        }
        cbCiudadDestino.getSelectionModel().clearSelection();
         */

        //Limpiar datos
        tfNombre.setText("");
        cbCiudadDestino.getSelectionModel().clearSelection();
        tfTarifa.setText("");
    }

    @FXML private void btnCalcularOnClick(){
        calcularTarifa();
    }

    @FXML private void cbCiudadDestinoOnChange(){
        calcularTarifa();
    }

    private void calcularTarifa(){
        if (cbCiudadDestino.getSelectionModel().getSelectedItem() != null) {
            int tarifa = (int) cbCiudadDestino.getSelectionModel().getSelectedItem().getTarifa();

            if (cbCena.isSelected()) tarifa += 15;
            if (cbComida.isSelected()) tarifa += 20;
            if (cbDesayuno.isSelected()) tarifa += 10;

            tfTarifa.setText(Integer.toString(tarifa));
        }
    }
}