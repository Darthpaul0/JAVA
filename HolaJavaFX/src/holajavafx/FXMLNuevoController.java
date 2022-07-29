/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holajavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author deifont
 */
public class FXMLNuevoController implements Initializable {

    @FXML
    private Label lNombre;
    @FXML
    private TextField tfNombre;
    @FXML
    private Button bAceptar;
    @FXML
    private Button bCancelar;
    
    private String nombre;
    private boolean aceptado;

    public boolean isAceptado() {
        return aceptado;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAceptarAction(ActionEvent event) {
   
        this.aceptado = true;
        this.nombre = this.tfNombre.getText();
        Stage stage= (Stage) bAceptar.getScene().getWindow();
        stage.close();             
        
    }

    @FXML
    private void handleCancelarAction(ActionEvent event) {
        Stage stage= (Stage) bCancelar.getScene().getWindow();
        stage.close();
    }
    
}
