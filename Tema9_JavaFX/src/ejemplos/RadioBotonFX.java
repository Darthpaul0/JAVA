/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Pablo
 */
public class RadioBotonFX extends Application {
    
    @Override
    public void start(Stage primaryStage)  {
        // Título de la ventana
        primaryStage.setTitle("Canales de TV");

        // Crear cuatro radiobotones
        RadioButton radioButton1 = new RadioButton("La 1");
        RadioButton radioButton2 = new RadioButton("La 2");
        RadioButton radioButton3 = new RadioButton("Antena 3");
        RadioButton radioButton4 = new RadioButton("Cuatro");
        // Crear un layout HBox y añadirle los radiobotones
        HBox hbox = new HBox(radioButton1, radioButton2, radioButton3, 
                radioButton4);
        
        // Establecer espaciado entre los elementos del layout en 10px
        hbox.setSpacing(10);
        
        // Crear un ToggleGroup
        ToggleGroup grupo = new ToggleGroup();
        // Añadir todos los readiobotnes al ToggleGroup
        grupo.getToggles().addAll(radioButton1, radioButton2, radioButton3,
                radioButton4);
        
        // Seleccionar el primer radiobotón
        radioButton1.setSelected(true);

        // Crear la escena con el layout recién creado
        Scene scene = new Scene(hbox, 300, 100);
        // Añadir la escena al escenario
        primaryStage.setScene(scene);
        // Mostrar el escenario
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
