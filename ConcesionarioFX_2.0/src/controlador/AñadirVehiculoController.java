/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Coche;
import modelo.Moto;
import modelo.Vehículo;
import modelo.Vendedor;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class AñadirVehiculoController implements Initializable {

    @FXML
    private Button btnConfirmarCreacion;
    @FXML
    private RadioButton rdbtnCoche;
    @FXML
    private RadioButton rdbtnMoto;
    
    private ObservableList<Vehículo> vehiculos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Para evitar que se puedan seleccionar todos los radio buttons, los agrupamos
        ToggleGroup tg = new ToggleGroup();
        this.rdbtnCoche.setToggleGroup(tg);
        this.rdbtnMoto.setToggleGroup(tg);
    }
    public void inicializarAtributos(ObservableList<Vehículo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @FXML
    private void crearVehiculo(ActionEvent event) {

        if (this.rdbtnCoche.isSelected()) {
            try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaCrearCoche.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            CrearCocheController cocheando = loader.getController();
            cocheando.inicializarAtributos(vehiculos);

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            // cojo el coche devuelto
            Coche miCoche = cocheando.getCoche();
            if (miCoche != null) {
                vehiculos.add(miCoche);
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

        } else if (this.rdbtnMoto.isSelected()) {
            try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaCrearMoto.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            CrearMotoController motando = loader.getController();
            motando.inicializarAtributos(vehiculos);

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            // cojo la moto devuelta
            Moto miMoto = motando.getMoto();
            if (miMoto != null) {
                vehiculos.add(miMoto);
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar un tipo de vehículo");
            alert.showAndWait();
        }

    }

}
