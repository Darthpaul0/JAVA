/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Vendedor;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class VistaVendedoresController implements Initializable {

    @FXML
    private MenuButton menubtnVendedores;
    @FXML
    private MenuItem btnitemContratar;
    @FXML
    private MenuItem btnitemDespedir;
    @FXML
    private MenuItem btnitemModificar;
    @FXML
    private MenuButton menubtnVendedores1;
    @FXML
    private MenuItem subitemSubirSueldo1;
    @FXML
    private MenuItem subitemBajarSueldo1;
    @FXML
    private MenuItem subitemPlus1;
    @FXML
    private MenuButton menubtnVendedores11;
    @FXML
    private MenuItem subitemModificarVacaciones11;
    @FXML
    private TableView<Vendedor> tblVendedores;

    //lista donde guardaremos los vendedores
    private ObservableList<Vendedor> vendedores;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colApellidos;
    @FXML
    private TableColumn<?, ?> colDNI;
    @FXML
    private TableColumn<?, ?> colSueldo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //con esto creamos la lista vacía donde guardaremos las personas
        vendedores = FXCollections.observableArrayList();

        //asociamos las columnas con sus atributos
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.colDNI.setCellValueFactory(new PropertyValueFactory("DNI"));
        this.colSueldo.setCellValueFactory(new PropertyValueFactory("Sueldo"));
    }

    public void inicializarAtributos(ObservableList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    @FXML
    private void contratarVendedor(ActionEvent event) {
        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaContratarVendedor.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            ContratarVendedorController contratando = loader.getController();
            contratando.inicializarAtributos(vendedores);

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            // cojo la persona devuelta
            Vendedor vende = contratando.getVendedor();
            if (vende != null) {
                //añadimos el vendedor
                vendedores.add(vende);
                //actualizamos la tabla
                this.tblVendedores.setItems(vendedores);
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void despedirVendedor(ActionEvent event) {
        //Instanciamos un vendedor y le decimos que equivale al item seleccionado
        Vendedor vende = this.tblVendedores.getSelectionModel().getSelectedItem();

        if (vende == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se ha seleccionado ninguna persona.");
            alert.showAndWait();
        } else {
            //eliminamos el vendedor
            vendedores.remove(vende);
            //actualizamos la tabla
            this.tblVendedores.refresh();
            //mensaje
            //mostramos un mensajito
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Vendedor despedido con éxito.");
            alert.showAndWait();
        }
    }

    @FXML
    private void modificarVendedor(ActionEvent event) {
        //Instanciamos una persona y le decimos que equivale al item seleccionado
        Vendedor vende = this.tblVendedores.getSelectionModel().getSelectedItem();

        //en caso de pinchar en vacío
        if (vende == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se ha seleccionado ningún vendedor.");
            alert.showAndWait();
        } else {
            try {
                // Cargo la vista
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaContratarVendedor.fxml"));

                // Cargo la ventana
                Parent root = loader.load();

                // Cojo el controlador
                ContratarVendedorController contratando = loader.getController();
                contratando.inicializarAtributos(vendedores);

                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                // cojo la persona devuelta
                Vendedor vendeor = contratando.getVendedor();
                if (!this.vendedores.contains(vendeor)) {
                    //actualizamos los datos
                    vende.setNombre(vendeor.getNombre());
                    vende.setApellidos(vendeor.getApellidos());
                    vende.setDNI(vendeor.getDNI());
                    vende.setSueldo(vendeor.getSueldo());
                    //actualizamos la tabla
                    this.tblVendedores.refresh();

                    //mostramos un mensajito
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Información");
                    alert.setContentText("Vendedor modificado con éxito.");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("¡Ese vendedor ya existe!");
                    alert.showAndWait();
                }
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void subirSueldo(ActionEvent event) {
        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaSubidaSueldo.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            SubidaSueldoController subiendo = loader.getController();
            subiendo.inicializarAtributos(vendedores);

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void bajarSueldo(ActionEvent event) {
        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaBajadaSueldo.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            BajadaSueldoController subiendo = loader.getController();
            subiendo.inicializarAtributos(vendedores);

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void darPlus(ActionEvent event) {
        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaDarPlus.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            DarPlusController pluseando = loader.getController();
            pluseando.inicializarAtributos(vendedores);

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void modificarVacaciones(ActionEvent event) {
        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaCambioVacaciones.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            CambioVacacionesController modificando = loader.getController();
            modificando.inicializarAtributos(vendedores);

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

}
