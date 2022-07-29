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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo de uso del layout VBox 
 * @author JJBH
 */
public class VBoxEjemplo extends Application {
    // Declarar el layout
    private VBox caja ;

    @Override
    public void start(Stage stage) {
        // Asignar 10 píxeles de separación entre los nodos
        caja = new VBox(10); 
        // Agregar un relleno de 15 píxeles para separarlo del borde de la ventana
        caja.setPadding(new Insets(15)); 
        // Llamando al metodo addAll podemos agregar nodos en una sola línea
        caja.getChildren().addAll(new Button("Botón 1"), new Button("Botón 2"), 
                new Button("Botón 3"));
        
               
        Scene s = new Scene(caja);
        stage.setScene(s);
        stage.setTitle("Vertical");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
