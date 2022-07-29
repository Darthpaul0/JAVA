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
import modelo.Moto;
import modelo.Vehículo;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class CrearMotoController implements Initializable {

    @FXML
    private TextField txtfAlto;
    @FXML
    private TextField txtfLargo;
    @FXML
    private TextField txtfAncho;
    @FXML
    private TextField txtfPeso;
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
    private Button btnCrearMoto;
    @FXML
    private Button btnCancelar;
    
    //Aquí guardamos los coches
    private ObservableList<Vehículo> motos;

    private Moto moto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void inicializarAtributos(ObservableList<Vehículo> motos) {
        this.motos = motos;
    }
    
    public void inicializarAtributos(ObservableList<Vehículo> motos, Moto moto) {
        this.moto = moto;
        this.motos = motos;
        //Datos del coche
        this.txtfMarca.setText(this.moto.getMarca());
        this.txtfAlto.setText(this.moto.getAltura() + "");
        this.txtfAncho.setText(this.moto.getAncho() + "");
        this.txtfAño.setText(this.moto.getAñoFabricacion() + "");
        this.txtfCilindrada.setText(this.moto.getCilindrada() + "");
        this.txtfColor.setText(this.moto.getColor());
        this.txtfCombustible.setText(this.moto.getCombustible());
        this.txtfKilometros.setText(this.moto.getKm() + "");
        this.txtfLargo.setText(this.moto.getLargo() + "");
        this.txtfMatricula.setText(this.moto.getMatricula());
        this.txtfModelo.setText(this.moto.getModelo());
        this.txtfPeso.setText(this.moto.getPeso() + "");
        this.txtfPrecio.setText(this.moto.getPrecio() + "");
        this.txtfPotencia.setText(this.moto.getPotencia() + "");
    }
    
    public Moto getMoto(){
        return moto;
    }
    
    @FXML
    private void crearMoto(ActionEvent event) {
        //Asociamos los datos de la moto a lo introducido por teclado
        String marca = this.txtfMarca.getText();
        String color = this.txtfColor.getText();
        String matricula = this.txtfMatricula.getText();
        String modelo = this.txtfModelo.getText();
        String combustible = this.txtfCombustible.getText();
        int alto = Integer.parseInt(this.txtfAlto.getText());
        int ancho = Integer.parseInt(this.txtfAncho.getText());
        int año = Integer.parseInt(this.txtfAño.getText());
        int cilindrada = Integer.parseInt(this.txtfCilindrada.getText());
        int km = Integer.parseInt(this.txtfKilometros.getText());
        int largo = Integer.parseInt(this.txtfLargo.getText());
        int peso = Integer.parseInt(this.txtfPeso.getText());
        int potencia = Integer.parseInt(this.txtfPotencia.getText());
        double precio = Double.parseDouble(this.txtfPrecio.getText());
        
        //creamos la moto
        Moto nueva = new Moto(marca, modelo, año, false, peso, ancho, largo, alto, 
                color, precio, matricula, km, 2, cilindrada, potencia, combustible);
        
        //comprobamos que no la tenemos ya en stock
        if (!motos.contains(moto)) {
            this.moto = nueva;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Moto añadida correctamente");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Esa moto ya está en stock.");
            alert.showAndWait();
        }
        // Cerrar la ventana
        Stage stage = (Stage) this.btnCrearMoto.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        // Cerrar la ventana
        Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
        stage.close();
    }

}
