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
public class SubidaSueldoController implements Initializable {

    @FXML
    private TextField txtfDNI;
    @FXML
    private Button btnAplicarSueldo;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtfVariacion;

    //Lista de vendedores
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    @FXML
    private void cancelarAccion(ActionEvent event) {
        // Cerrar la ventana
        Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void aplicarSubidaSueldo(ActionEvent event) {
        String posibleSubida = this.txtfDNI.getText();
        boolean existeDNI = false;
        for (Vendedor posible : vendedores) {
            if (posible.getDNI().equals(posibleSubida)) {
                existeDNI = true;
                posible.subirSueldo(Double.parseDouble(this.txtfVariacion.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("El nuevo sueldo de " + posible.getNombre() + " " + posible.getApellidos() + " es de " + posible.getSueldo());
                alert.showAndWait();
            }
        }
        //En caso de no tener ese DNI
        if (!existeDNI) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No tenemos ese DNI registrado");
            alert.showAndWait();
        }

        // Cerrar la ventana
        Stage stage = (Stage) this.btnAplicarSueldo.getScene().getWindow();
        stage.close();
    }

}
