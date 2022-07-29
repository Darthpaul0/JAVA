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
public class DarPlusController implements Initializable {

    @FXML
    private Button btnDarPlus;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtfDNI;

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
    private void darPlus(ActionEvent event) {
        String posiblePlus = this.txtfDNI.getText();
        for (Vendedor posible : vendedores) {
            if (posible.getDNI().equals(posiblePlus)) {
                posible.fijarIncentivo();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText(posible.getNombre() + " " + posible.getApellidos() + " ha recibido un plus de 500€");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("Ese DNI no está registrado.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void cancelarAccion(ActionEvent event) {
        // Cerrar la ventana
        Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
        stage.close();
    }

}
