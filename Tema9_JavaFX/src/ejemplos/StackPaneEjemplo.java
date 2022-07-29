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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Ejemplo de panel StackPane.
 * @author JJBH
 */
public class StackPaneEjemplo extends Application {

        
    @Override
    public void start(Stage stage)  {
        // Crear el panel
        StackPane sp = new StackPane();
        
        // Establecer relleno
        sp.setPadding(new Insets(25));
        
        // Asignamos la alineacion al objeto
        sp.setAlignment(Pos.BOTTOM_RIGHT);
        sp.getChildren().addAll(new Circle(295, 150, 50, Color.BURLYWOOD),
                new Button("Botón"));
       
        // Crear panel
        Scene s = new Scene(sp,250,160);
        
        // Título del escenario
        stage.setTitle("StackPane ejemplo.");
        // Añadir escena al escenario
        stage.setScene(s);
        // Mostrar escenario
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
