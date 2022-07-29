/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Coche;
import modelo.Moto;
import modelo.Persona;
import modelo.Serializar;
import modelo.Vehículo;
import modelo.Vendedor;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class VistaPrincipalController implements Initializable {

    @FXML
    private Button menubtnVendedores;
    @FXML
    private Button menubtnVehiculos;
    @FXML
    private Button btnEconomia;
    @FXML
    private Button btnSalir;
    @FXML
    private MenuItem subItemCargarPred;
    @FXML
    private MenuItem subitemCargar;
    @FXML
    private MenuItem subItemGuardar;

    //lista donde guardaremos los vendedores
    private ObservableList<Vendedor> vendedores;
    //lista donde almacenamos los vehiculos
    private ObservableList<Vehículo> vehiculos;
    //lista utilizada para poder filtrar
    private ObservableList<Vehículo> filtroVehiculos;
    //ingresos y gastos del concesionario
    private double ingresos, gastos;
    /*Necesitamos crear un ArrayList para cada ObservableList, 
        ya que sino no se puede serializar**/
    ArrayList<Vendedor> humanos;
    ArrayList<Vehículo> maquinas;

    //Instancia encargada de serializar
    Serializar serializa = new Serializar();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vendedores = FXCollections.observableArrayList();
        vehiculos = FXCollections.observableArrayList();
        filtroVehiculos = FXCollections.observableArrayList();
        humanos = new ArrayList<>();
        maquinas = new ArrayList<>();

        /*generoPersonas(vendedores);
        generoVehiculos(vehiculos);*/
    }

    private void buscarVehiculo(ActionEvent event) {
        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaBuscarVehiculo.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            BuscarVehiculoController buscando = loader.getController();
            buscando.inicializarAtributos(vehiculos, filtroVehiculos);

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

    private void venderVehiculo(ActionEvent event) {
        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaVenderVehiculo.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            VenderVehiculoController vendiendo = loader.getController();
            vendiendo.inicializarAtributos(vehiculos);

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

    private void añadirVehiculo(ActionEvent event) {
        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaAñadirVehiculo.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            AñadirVehiculoController añadiendo = loader.getController();
            añadiendo.inicializarAtributos(vehiculos);

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
    private void verBalance(ActionEvent event) {

        //Hacemos aquí el cálculo de los gastos correspondientes a salarios
        for (Persona sueldo : vendedores) {
            gastos += ((Vendedor) sueldo).getSueldo();
        }
        double beneficios = ingresos - gastos;
        if (beneficios > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Ingresos del concesionario: " + ingresos + "€" + "\n"
                    + "Gastos del concesionario: " + gastos + "€" + "\n"
                    + "Balance final: " + beneficios + " € de beneficio." + "\n"
                    + "---" + "\n"
                    + "El negocio va bien.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Balance final: " + beneficios + " € de beneficio.");
            alert.setContentText("Ingresos del concesionario: " + ingresos + "€" + "\n"
                    + "Gastos del concesionario: " + gastos + "€" + "\n"
                    + "Balance final: " + beneficios + " € de beneficio." + "\n"
                    + "---" + "\n"
                    + "El negocio se hunde, hay que vender más.");
            alert.showAndWait();
        }
    }

    @FXML
    private void abandonarAplicacion(ActionEvent event) {// Cerrar la ventana
        Stage stage = (Stage) this.btnSalir.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cargarDatosPredeterminados(ActionEvent event) {
        //Limpiamos cargas anteriores
        vendedores.clear();
        vehiculos.clear();

        //Cargamos los datos en los ArrayList
        humanos = (ArrayList<Vendedor>) serializa.leerObjeto("vendedoresPred.dat");
        maquinas = (ArrayList<Vehículo>) serializa.leerObjeto("vehiculosPred.dat");

        //Pasamos la información a los ObservableList
        vendedores.addAll(humanos);
        vehiculos.addAll(maquinas);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText("Datos predeterminados cargados con éxito.");
        alert.showAndWait();
    }

    @FXML
    private void cargarDatos(ActionEvent event) {
        //Limpiamos cargas anteriores
        vendedores.clear();
        vehiculos.clear();

        //Cargamos los datos en los ArrayList
        humanos = (ArrayList<Vendedor>) serializa.leerObjeto("vendedoresUltimo.dat");
        maquinas = (ArrayList<Vehículo>) serializa.leerObjeto("vehiculosUltimo.dat");

        //Pasamos la información a los ObservableList
        vendedores.addAll(humanos);
        vehiculos.addAll(maquinas);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText("Datos cargados con éxito.");
        alert.showAndWait();
    }

    @FXML
    private void guardarDatos(ActionEvent event) {
        //Guardamos la información en los ArrayList
        humanos.addAll(vendedores);
        maquinas.addAll(vehiculos);
        serializa.escribirObjeto(humanos, "vendedoresUltimo.dat");
        serializa.escribirObjeto(maquinas, "vehiculosUltimo.dat");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText("Guardado correctamente.");
        alert.showAndWait();

    }

    @FXML
    private void mostrarInfo(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText("Aplicación realizada con JavaFX" + "\n"
                + "Autor: Pablo Fernández Rodríguez (1º DAW 2021)");
        alert.showAndWait();
    }

    @FXML
    private void verVentanaVendedores(ActionEvent event) {
        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaVendedores.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            VistaVendedoresController vistaVendedor = loader.getController();
            vistaVendedor.inicializarAtributos(vendedores);

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
    private void verVentanaVehiculos(ActionEvent event) {
    }

    public static void generoPersonas(ObservableList<Vendedor> listaPersonas) {
        //Añadimos unos cuantos vendedores de prueba
        listaPersonas.add(new Vendedor(3000, 10, "Ciencias Políticas", 90, "Pedro", "Tima D'Or", "14151213M", 50));
        listaPersonas.add(new Vendedor(1000, 1, "Bellas Artes", 30, "Juan", "Tahúr Gordo", "55668899D", 40));
        listaPersonas.add(new Vendedor(1500, 3, "Finanzas", 45, "Margarita", "Flores del Campo", "77443311K", 30));
    }

    public static void generoVehiculos(ObservableList<Vehículo> listaVehiculos) {
        //Añadimos vehículos variados a la oferta del concesionario
        listaVehiculos.add(new Coche("BMW", "525", 2016, 400, 5, false, 1475, 175, 450, 150, "negro", 32000, "1523JTD", 10000, 4, 2500, 192, "Diésel"));
        listaVehiculos.add(new Coche("Honda", "Accord", 2010, 370, 5, false, 1325, 170, 375, 140, "azul", 16000, "4715HRF", 110000, 4, 2200, 150, "Gasolina"));
        listaVehiculos.add(new Coche("Mercedes", "Clase C", 2002, 500, 5, false, 1700, 198, 500, 155, "azul oscuro", 6000, "4578BTD", 200000, 4, 3000, 241, "Diésel"));
        listaVehiculos.add(new Moto("Yamaha", "RT1200", 2010, false, 250, 90, 210, 160, "azul", 15000, "2358GDS", 20000, 2, 1200, 120, "Gasolina"));
        listaVehiculos.add(new Moto("Harley-Davidson", "GS650", 2007, false, 180, 70, 200, 160, "negra", 11000, "4586DFT", 0, 2, 650, 50, "Gasolina"));
        listaVehiculos.add(new Moto("BMW", "F800GS", 2010, false, 180, 70, 200, 160, "verde oscuro", 10000, "6233GHB", 0, 2, 800, 84, "Gasolina"));

    }
}
