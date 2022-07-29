/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holajavafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author deifont
 */
public class FXMLDocumentController implements Initializable {

    private final static String MENSAJE = "¡Bienvenido a JavaFX!";
    
    @FXML
    private Button bAceptar;
    @FXML
    private Label lMensaje;
    @FXML
    private TextField tfNombre;
    @FXML
    private MenuBar mbMenu;
    @FXML
    private Menu mAcciones;
    @FXML
    private MenuItem miPulsar;
    @FXML
    private MenuItem miInicializar;
    @FXML
    private Menu mAyuda;
    @FXML
    private MenuItem miAcerdaDe;
    @FXML
    private MenuItem miNuevo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        lMensaje.setText(MENSAJE+" "+tfNombre.getText());
        lMensaje.setVisible(true);
    }

    @FXML
    private void inicializar(ActionEvent event) {
        lMensaje.setVisible(false);
        tfNombre.setText("");
    }

    @FXML
    private void handleAcercaDeAction(ActionEvent event) {
        Alert acercaDe = new Alert(AlertType.INFORMATION,"Primera aplicación JavaFX\nAutor: JLBerenguel\n(c) 2021");
        //acercaDe.setHeaderText(null);
        acercaDe.showAndWait();
        
    }
    
    /*
    * Ejemplo de cómo abrir nuevas escenas
    * https://dev.to/devtony101/javafx-3-ways-of-passing-information-between-scenes-1bm8
    * https://stackoverflow.com/questions/23627340/login-application-with-1-stage-and-multiple-scene-in-javafx
    */

    @FXML
    private void handleNuevoAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLNuevo.fxml"));
        Parent nuevaVentana;
        try {
            nuevaVentana = loader.load();
            Scene scene = new Scene(nuevaVentana);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Nueva ventana");
            stage.showAndWait();
            
            //Vuelve la ventana
           
             FXMLNuevoController controladorNuevaVentana = loader.getController();
             if(controladorNuevaVentana.isAceptado()){
                 this.tfNombre.setText(controladorNuevaVentana.getNombre());
             }
            
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
