package com.example.examen_ejercicio1;

import com.example.examen_ejercicio1.models.Ciudad;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class vistaPrincipalController implements Initializable {
    @FXML
    private ListView <Ciudad> listaVistaCiudades;
    @FXML
    private ImageView imagenCiudades;

    @FXML Button btnAsignarEstilo, btnLimpiarEstilo;

    @FXML Label lblTitulo;

    @FXML
    private final ObservableList <Ciudad> listaCiudades =
           FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listaCiudades.add(new Ciudad("Madrid", "C:\\Users\\a21pabloac1\\Desktop\\DI-UD03-Examen\\examen_ejercicio1\\src\\main\\resources\\com\\example\\images\\img1.jpg"));
        listaCiudades.add(new Ciudad("Barcelona", "C:\\Users\\a21pabloac1\\Desktop\\DI-UD03-Examen\\examen_ejercicio1\\src\\main\\resources\\com\\example\\images\\img2.jpg"));
        listaCiudades.add(new Ciudad("Sevilla", "C:\\Users\\a21pabloac1\\Desktop\\DI-UD03-Examen\\examen_ejercicio1\\src\\main\\resources\\com\\example\\images\\img3.jpg"));
        listaCiudades.add(new Ciudad("Málaga", "C:\\Users\\a21pabloac1\\Desktop\\DI-UD03-Examen\\examen_ejercicio1\\src\\main\\resources\\com\\example\\images\\img4.jpg"));
        listaCiudades.add(new Ciudad("Valencia", "C:\\Users\\a21pabloac1\\Desktop\\DI-UD03-Examen\\examen_ejercicio1\\src\\main\\resources\\com\\example\\images\\img5.jpg"));
        listaCiudades.add(new Ciudad("Oporto", "C:\\Users\\a21pabloac1\\Desktop\\DI-UD03-Examen\\examen_ejercicio1\\src\\main\\resources\\com\\example\\images\\img6.jpg"));

        lblTitulo.setStyle("titulo");


    // Vamos a asignar la lista observable a la lista
        listaVistaCiudades.setItems(listaCiudades);
    //Debes modificar el ListView para que funcione con la clase Ciudad.
        listaVistaCiudades
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<Ciudad>() {
            @Override
            public void changed(ObservableValue<? extends Ciudad> observableValue, Ciudad oldCiudad, Ciudad newCiudad) {
                System.out.println (newCiudad.getNombre() );
                imagenCiudades.setImage(new Image(newCiudad.getUrl()));
                imagenCiudades.preserveRatioProperty();
            }
        });
    }

    @FXML private void btnAsignarEstiloOnClick(){
        btnAsignarEstilo.getScene().getStylesheets().add("C:\\Users\\a21pabloac1\\Desktop\\DI-UD03-Examen\\examen_ejercicio1\\src\\main\\resources\\com\\example\\examen_ejercicio1\\css\\estilo.css");
    }

    @FXML private void btnLimpiarEstiloOnClick(){
        btnLimpiarEstilo.getScene().getStylesheets().clear();
    }
}