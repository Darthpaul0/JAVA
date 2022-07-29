/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Coche;
import modelo.Moto;
import modelo.Vehículo;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class VenderVehiculoController implements Initializable {

    @FXML
    private TextField txtfMatricula;
    @FXML
    private Button btnVender;
    @FXML
    private Button btnCancelar;

    //Lista para vehículos
    private ObservableList<Vehículo> vehiculos;
    private ObservableList<Vehículo> vendidos;
    private Vehículo vehiculo;
    private double ingresos = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void inicializarAtributos(ObservableList<Vehículo> vehículos) {
        this.vehiculos = vehículos;
    }
    public void inicializarAtributos(double ingresos) {
        this.ingresos = ingresos;
    }

    @FXML
    private void venderVehiculo(ActionEvent event) {
        //Antes de nada, nos aseguramos que el concesionario tiene vehículos en venta
        if (vehiculos.isEmpty()) {
            System.out.println("Actualmente no hay vehículos en venta.");
        } else {

            //Primero leemos la matrícula del vehículo que está en venta
            String matricula = this.txtfMatricula.getText();

            //Ahora comprobamos que esa matrícula coincide con algún vehículo en stock
            //Se necesita crear una lista alternativa para las ventas como solución al error java.util.ConcurrentModificationException
            boolean encontrado = false;
            //Recorremos el array de vehículos 
            for (Vehículo maquina : vehiculos) {
                //Si es coche
                if (maquina instanceof Coche) {
                    Coche auto = (Coche) maquina;
                    if (auto.getMatricula().equals(matricula)) {
                        encontrado = true;
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Información");
                        alert.setContentText("Vendido un " + auto.getMarca() + " " + auto.getModelo() + " por " + auto.getPrecio() + "€");
                        alert.showAndWait();
                        //Ponemos el estado de la venta a true
                        auto.vendido = true;
                        //Añadimos el precio a la variable ingresos
                        ingresos += auto.getPrecio();
                        //Añadimos el vehículo vendido a la lista de vendidos
                        vendidos.add(auto);
                        //Finalmente, eliminamos las ventas de la lista de vehículos
                        vehiculos.remove(vendidos);
                    }
                }

                //Si es moto
                if (maquina instanceof Moto) {
                    Moto miMoto = (Moto) maquina;
                    if (miMoto.getMatricula().equals(matricula)) {
                        encontrado = true;
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Información");
                        alert.setContentText("Vendida una " + miMoto.getMarca() + " " + miMoto.getModelo() + " tipo " + miMoto.tipoMoto() + " por " + miMoto.getPrecio() + "€");
                        alert.showAndWait();
                        //Ponemos el estado de la venta a true
                        miMoto.vendido = true;
                        //Añadimos el precio a la variable ingresos
                        ingresos += miMoto.getPrecio();
                        //Añadimos el vehículo vendido a la lista de vendidos
                        vendidos.add(miMoto);
                        //Finalmente, eliminamos las ventas de la lista de vehículos
                        vehiculos.remove(vendidos);
                    }
                }
            }
            //Si no encotramos el coche que queríamos vender
            if (!encontrado) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("No hemos encontrado ese vehículo.");
                alert.showAndWait();
            }
            // Cerrar la ventana
            Stage stage = (Stage) this.btnVender.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        // Cerrar la ventana
        Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
        stage.close();
    }

}
