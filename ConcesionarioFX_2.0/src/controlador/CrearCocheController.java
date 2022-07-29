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
import modelo.Vehículo;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class CrearCocheController implements Initializable {

    @FXML
    private TextField txtfAlto;
    @FXML
    private TextField txtfLargo;
    @FXML
    private TextField txtfAncho;
    @FXML
    private TextField txtfPeso;
    @FXML
    private TextField txtfPlazas;
    @FXML
    private TextField txtfCapacidad;
    @FXML
    private TextField txtfAño;
    @FXML
    private TextField txtfModelo;
    @FXML
    private TextField txtfMarca;
    @FXML
    private TextField txtfCombustible;
    @FXML
    private TextField txtfCilindrada;
    @FXML
    private TextField txtfKilometros;
    @FXML
    private TextField txtfMatricula;
    @FXML
    private TextField txtfPrecio;
    @FXML
    private TextField txtfColor;
    @FXML
    private TextField txtfPotencia;
    @FXML
    private Button btnCrearCoche;
    @FXML
    private Button btnCancelar;

    //Aquí guardamos los coches
    private ObservableList<Vehículo> coches;

    private Coche coche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void inicializarAtributos(ObservableList<Vehículo> coches) {
        this.coches = coches;
    }

    public void inicializarAtributos(ObservableList<Vehículo> coches, Coche coche) {
        this.coche = coche;
        this.coches = coches;
        //Datos del coche
        this.txtfMarca.setText(this.coche.getMarca());
        this.txtfAlto.setText(this.coche.getAltura() + "");
        this.txtfAncho.setText(this.coche.getAncho() + "");
        this.txtfAño.setText(this.coche.getAñoFabricacion() + "");
        this.txtfCapacidad.setText(this.coche.getCapacidadCarga() + "");
        this.txtfCilindrada.setText(this.coche.getCilindrada() + "");
        this.txtfColor.setText(this.coche.getColor());
        this.txtfCombustible.setText(this.coche.getCombustible());
        this.txtfKilometros.setText(this.coche.getKm() + "");
        this.txtfLargo.setText(this.coche.getLargo() + "");
        this.txtfMatricula.setText(this.coche.getMatricula());
        this.txtfModelo.setText(this.coche.getModelo());
        this.txtfPeso.setText(this.coche.getPeso() + "");
        this.txtfPlazas.setText(this.coche.getPlazas() + "");
        this.txtfPrecio.setText(this.coche.getPrecio() + "");
        this.txtfPotencia.setText(this.coche.getPotencia() + "");
    }

    public Coche getCoche() {
        return coche;
    }

    @FXML
    private void crearCoche(ActionEvent event) {
        //Asociamos los datos del coche a lo introducido por teclado
        String marca = this.txtfMarca.getText();
        String color = this.txtfColor.getText();
        String matricula = this.txtfMatricula.getText();
        String modelo = this.txtfModelo.getText();
        String combustible = this.txtfCombustible.getText();
        int alto = Integer.parseInt(this.txtfAlto.getText());
        int ancho = Integer.parseInt(this.txtfAncho.getText());
        int año = Integer.parseInt(this.txtfAño.getText());
        int capacidad = Integer.parseInt(this.txtfCapacidad.getText());
        int cilindrada = Integer.parseInt(this.txtfCilindrada.getText());
        int km = Integer.parseInt(this.txtfKilometros.getText());
        int largo = Integer.parseInt(this.txtfLargo.getText());
        int peso = Integer.parseInt(this.txtfPeso.getText());
        int plazas = Integer.parseInt(this.txtfPlazas.getText());
        int potencia = Integer.parseInt(this.txtfPotencia.getText());
        double precio = Double.parseDouble(this.txtfPrecio.getText());

        //creamos el coche
        Coche nuevo = new Coche(marca, modelo, potencia, capacidad, plazas, false, peso,
                ancho, largo, alto, color, precio, matricula, km, 4, cilindrada, potencia,
                combustible);

        //comprobamos que no lo tenemos ya en stock
        if (!coches.contains(coche)) {
            this.coche = nuevo;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Coche añadido correctamente");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ese coche ya está en stock.");
            alert.showAndWait();
        }
        // Cerrar la ventana
        Stage stage = (Stage) this.btnCrearCoche.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        this.coche = null;
        // Cerrar la ventana
        Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
        stage.close();
    }

}
