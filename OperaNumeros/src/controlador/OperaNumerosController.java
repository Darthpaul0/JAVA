/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import modelo.Operaciones;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class OperaNumerosController implements Initializable {

    @FXML
    private Button btnOperar;
    @FXML
    private RadioButton rdbtnSuma;
    @FXML
    private RadioButton rdbtnMult;
    @FXML
    private RadioButton rdbtnDiv;
    @FXML
    private RadioButton rdbtnResta;
    @FXML
    private TextField txtfOp1;
    @FXML
    private TextField txtfOp2;
    @FXML
    private TextField txtfResultado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Para evitar que se puedan seleccionar todos los radio buttons, los agrupamos
        ToggleGroup tg = new ToggleGroup();
        this.rdbtnSuma.setToggleGroup(tg);
        this.rdbtnResta.setToggleGroup(tg);
        this.rdbtnMult.setToggleGroup(tg);
        this.rdbtnDiv.setToggleGroup(tg);

    }

    @FXML
    private void hacerOperacion(ActionEvent event) {

        try {

            //Obtenemos el valor del campo
            int op1 = Integer.parseInt(this.txtfOp1.getText());
            int op2 = Integer.parseInt(this.txtfOp2.getText());

            //Instanciamos nuestra clase operaciones
            Operaciones op = new Operaciones(op1, op2);

            //Pasamos las condiciones para cada radio button
            //Si está seleccionado, se hará esa operación
            if (this.rdbtnSuma.isSelected()) {
                this.txtfResultado.setText(op.suma() + "");
            } else if (this.rdbtnResta.isSelected()) {
                this.txtfResultado.setText(op.resta() + "");
            } else if (this.rdbtnMult.isSelected()) {
                this.txtfResultado.setText(op.multiplica() + "");
            } else if (this.rdbtnDiv.isSelected()) {
                if (op2 == 0) {
                    // Alerta de error
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("No se puede dividir entre 0: Indeterminación.");
                    alert.showAndWait();
                } else {
                    this.txtfResultado.setText(op.divide()+ "");
                }

            }
        } catch (NumberFormatException e) {
// Alerta de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }

}
