/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import modelo.Coche;
import modelo.Moto;
import modelo.Vehículo;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class BuscarVehiculoController implements Initializable {

    @FXML
    private TableView<Vehículo> tblVehiculos;
    @FXML
    private TableColumn colMarca;
    @FXML
    private TableColumn colModelo;
    @FXML
    private TableColumn colPrecio;
    @FXML
    private TextField txtfFiltro;

    //Lista para vehículos
    private ObservableList<Vehículo> vehiculos;
    //Lista de vehículos filtrados
    private ObservableList<Vehículo> filtroVehiculos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.tblVehiculos.setItems(vehiculos);

        this.colMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        this.colModelo.setCellValueFactory(new PropertyValueFactory("modelo"));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
    }

    public void inicializarAtributos(ObservableList<Vehículo> vehiculos, ObservableList<Vehículo> filtroVehiculos) {
        this.vehiculos = vehiculos;
        this.filtroVehiculos = filtroVehiculos;
    }

    @FXML
    private void filtrarMarca(KeyEvent event) {
        //cogemos el valor del text field
        String filtrado = this.txtfFiltro.getText();

        //si no hay vehículos que filtrar
        if (filtrado.isEmpty()) {
            this.tblVehiculos.setItems(vehiculos);
        } else {
            this.filtroVehiculos.clear();
            for (Vehículo v : vehiculos) {
                if (v instanceof Coche) {
                    if (((Coche) v).getMarca().toLowerCase().contains(filtrado.toLowerCase())) {
                        this.filtroVehiculos.add(v);
                    }
                }
                if (v instanceof Moto) {
                    if (((Moto) v).getMarca().toLowerCase().contains(filtrado.toLowerCase())) {
                        this.filtroVehiculos.add(v);
                    }
                }
            }

            this.tblVehiculos.setItems(filtroVehiculos);
        }

    }

}
