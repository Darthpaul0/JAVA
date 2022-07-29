/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

/**
 *
 * @author Pablo
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo de uso del control Lista (ListView)
 * @author JJBH
 */
public class Lista extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lista de postres.");

        // Crear la lista
        ListView listView = new ListView();

        // Añadir los elementos
        listView.getItems().add("Bizcocho");
        listView.getItems().add("Tortada");
        listView.getItems().add("Helado");

        // Añadir la lista al layout
        VBox vbox = new VBox(listView);

        // Añadir layout a la escena
        Scene scene = new Scene(vbox, 300, 120);
        
        // Añadir la escena al escenario
        primaryStage.setScene(scene);
        
        // Mostrar el escenario
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
