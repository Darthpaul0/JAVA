/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class TablaPersonasController implements Initializable {

    @FXML
    private Button btnAgregar;
    @FXML
    private TextField txtfNombre;
    @FXML
    private TextField txtfApellidos;
    @FXML
    private TextField txtfEdad;
    @FXML
    private TableView<Persona> tblPersonas;
    @FXML
    private TableColumn tblcNombre;
    @FXML
    private TableColumn tblcApellidos;
    @FXML
    private TableColumn tblcEdad;

    //especie de lista, no se puede generar en Scene Builder
    private ObservableList<Persona> personas;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //con esto creamos la lista vacía donde guardaremos las personas
        personas = FXCollections.observableArrayList();

        //asociamos las columnas con sus atributos
        this.tblcNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tblcApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.tblcEdad.setCellValueFactory(new PropertyValueFactory("edad"));
    }

    @FXML
    private void agregarPersona(ActionEvent event) {

        try {

            //asociamos una variable al valor del campo de texto
            String nombre = this.txtfNombre.getText();
            String apellidos = this.txtfApellidos.getText();
            int edad = Integer.parseInt(this.txtfEdad.getText());

            //instanciamos una persona
            Persona humano = new Persona(nombre, apellidos, edad);

            //comprobamos si la persona ya existe, es decir, está en la lista
            //si no está en la lista...
            if (!this.personas.contains(humano)) {
                //...añadimos a la persona
                this.personas.add(humano);
                //...la ponemos en la tabla
                this.tblPersonas.setItems(personas);

                //mostramos un mensajito
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("Persona agregada con éxito.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("¡Esa persona ya existe!");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("¡Esa persona ya existe!");
            alert.showAndWait();
        }

    }

    @FXML
    private void modificarPersona(ActionEvent event) {

        //Instanciamos una persona y le decimos que equivale al item seleccionado
        Persona p = this.tblPersonas.getSelectionModel().getSelectedItem();

        //en caso de pinchar en vacío
        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se ha seleccionado ninguna persona.");
            alert.showAndWait();
        } else {
            try {

                //asociamos una variable al valor del campo de texto
                String nombre = this.txtfNombre.getText();
                String apellidos = this.txtfApellidos.getText();
                int edad = Integer.parseInt(this.txtfEdad.getText());

                //instanciamos una persona
                Persona aux = new Persona(nombre, apellidos, edad);

                //comprobamos si la persona ya existe, es decir, está en la lista
                //si no está en la lista...
                if (!this.personas.contains(aux)) {
                    //asociamos los nuevos valores a la persona
                    p.setNombre(aux.getNombre());
                    p.setApellidos(aux.getApellidos());
                    p.setEdad(aux.getEdad());

                    //actualizamos la tabla con los nuevos datos
                    this.tblPersonas.refresh();

                    //mostramos un mensajito
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Información");
                    alert.setContentText("Persona modificada con éxito.");
                    alert.showAndWait();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("¡Esa persona ya existe!");
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("¡Esa persona ya existe!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void eliminarPersona(ActionEvent event) {

        //Instanciamos una persona y le decimos que equivale al item seleccionado
        Persona p = this.tblPersonas.getSelectionModel().getSelectedItem();

        //en caso de pinchar en vacío
        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se ha seleccionado ninguna persona.");
            alert.showAndWait();
        } else {
            //Eliminamos la persona p
            this.personas.remove(p);
            //Actualizamos la tabla
            this.tblPersonas.refresh();

            //mostramos un mensajito
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Persona eliminada con éxito.");
            alert.showAndWait();
        }

    }

    @FXML
    private void seleccionarPersona(MouseEvent event) {

        //Instanciamos una persona y le decimos que equivale al item seleccionado
        Persona p = this.tblPersonas.getSelectionModel().getSelectedItem();

        //en caso de pinchar en vacío
        if (p != null) {
            this.txtfNombre.setText(p.getNombre());
            this.txtfApellidos.setText(p.getApellidos());
            this.txtfEdad.setText(p.getEdad() + "");
        }

    }

}
