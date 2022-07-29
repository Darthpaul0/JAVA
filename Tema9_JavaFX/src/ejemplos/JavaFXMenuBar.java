/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Pablo
 */
public class JavaFXMenuBar extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Crear barra de menú
        MenuBar menuBar = new MenuBar();
        // Añadir la barra a un panel contenedor
        VBox vBox = new VBox(menuBar);
        
        // Crear un menú llamado Archivo
        Menu menu = new Menu("Archivo");
        // Añadir dos elementos de menú       
        MenuItem menuItem1 = new MenuItem("Abrir");
        MenuItem menuItem2 = new MenuItem("Cerrar");
        // Añadir los elementos de menú al menú
        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);
        
        // Especificamos las acciones a tomar si se pincha en las opciones 
        // de menú
        menuItem1.setOnAction(e -> {
            System.out.println("Se seleccionó la opción abrir");
        });
        menuItem2.setOnAction(e -> {
            System.out.println("Se seleccionó la opción cerrar");
            primaryStage.close();
        });

        // Añadir el menú a la barra de menú
        menuBar.getMenus().add(menu);

        // Crear la escena
        Scene scene = new Scene(vBox, 700, 500);
        primaryStage.setTitle("Barra de menú");
        primaryStage.setScene(scene);
        primaryStage.show();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}