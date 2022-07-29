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
import modelo.Vendedor;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class ContratarVendedorController implements Initializable {

    @FXML
    private TextField txtfNombre;
    @FXML
    private TextField txtfApellidos;
    @FXML
    private TextField txtfEdad;
    @FXML
    private TextField txtfEstudios;
    @FXML
    private TextField txtfDNI;
    @FXML
    private Button btnContratarAceptar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtfSalario;
    @FXML
    private TextField txtfVacaciones;
    @FXML
    private TextField txtfExperiencia;

    //Aquí guardamos los vendedores
    private ObservableList<Vendedor> vendedores;

    private Vendedor vendedor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void inicializarAtributos(ObservableList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public void inicializarAtributos(ObservableList<Vendedor> personas, Vendedor vende) {
        this.vendedores = vendedores;
        this.vendedor = vende;
        //Datos del vendedor
        this.txtfNombre.setText(this.vendedor.getNombre());
        this.txtfApellidos.setText(this.vendedor.getApellidos());
        this.txtfEdad.setText(this.vendedor.getEdad() + "");
        this.txtfEstudios.setText(this.vendedor.getEstudios());
        this.txtfDNI.setText(this.vendedor.getDNI());
        this.txtfExperiencia.setText(this.vendedor.getAñosExperiencia() + "");
        this.txtfVacaciones.setText(this.vendedor.getDiasVacaciones() + "");
        this.txtfSalario.setText(this.vendedor.getSueldo() + "");
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    @FXML
    private void agregarVendedor(ActionEvent event) {
        //Asociamos los datos del vendedor a lo introducido por teclado
        String nombre = this.txtfNombre.getText();
        String apellidos = this.txtfApellidos.getText();
        int edad = Integer.parseInt(this.txtfEdad.getText());
        String estudios = this.txtfEstudios.getText();
        String DNI = this.txtfDNI.getText();
        int experiencia = Integer.parseInt(this.txtfExperiencia.getText());
        int vacaciones = Integer.parseInt(this.txtfVacaciones.getText());
        double sueldo = Double.parseDouble(this.txtfSalario.getText());

        //Creamos el vendedor
        Vendedor vende = new Vendedor(sueldo, experiencia, estudios, vacaciones, nombre, apellidos, DNI, edad);

        //Comprobamos que no esté ya en nómina
        if (!vendedores.contains(vende)) {
            //si no existe, lo añadimos y cerramos la ventana
            this.vendedor = vende;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Vendedor añadido correctamente");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ese vendedor ya está en nómina.");
            alert.showAndWait();
        }
        // Cerrar la ventana
        Stage stage = (Stage) this.btnContratarAceptar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancelarAccion(ActionEvent event) {
        this.vendedor = null;
        // Cerrar la ventana
        Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
        stage.close();
    }
}
