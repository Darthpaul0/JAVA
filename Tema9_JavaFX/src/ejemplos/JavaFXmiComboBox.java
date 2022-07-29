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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo de uso de un control Combobox en JavaFX
 * @author JJBH
 */
public class JavaFXmiComboBox extends Application {
    
    private Label miEtiqueta ;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Título del escenario
        primaryStage.setTitle("Ejemplo ComboBox");

        // Crear combobox
        ComboBox comboBox = new ComboBox();
        
        // Añadir elementos al combobox
        comboBox.getItems().add("Java");
        comboBox.getItems().add("C#");
        comboBox.getItems().add("Ada");
        comboBox.getItems().add("Lisp");
        comboBox.getItems().add("Visual Basic");
                        
        miEtiqueta = new Label("Seleccionado: ") ;
        
        // Añadir EventHandler al checkbox
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
                String valor = (String) comboBox.getValue();
                
                if (valor != null) {
                    // Establecer el texto de una etiqueta
                    miEtiqueta.setText("Seleccionado: " + valor);
                } else {
                    // Establecer el texto de una etiqueta
                    miEtiqueta.setText("No se selecciona nada.");
                }
                
            }
        });
            

        // Declarar el layout y añadirle el comboBox y la etiqueta
        VBox sp = new VBox(comboBox, miEtiqueta);

        // Crear la escena y pasarle el layout
        Scene scene = new Scene(sp, 300, 120);
        // A�adir escena al escenario
        primaryStage.setScene(scene);
        // Mostrar el escenario
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}