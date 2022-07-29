package javafxconcssespecificapadre;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo donde se usa un layout VBox, al cual se añaden dos botones. Ese vbox
 * se añade a la escena.
 * @author JJBH
 */
public class JavaFXconCssEspecificaPadre extends Application {
    
    @Override
    public void start(Stage primaryStage) {
              
        // Nodo raiz, de clase StackPane
        StackPane root = new StackPane();
        
        // Crear un Nodo de clase Button
        Button btn = new Button();
        
        // Establecer el texto del botñn
        btn.setText("Botón que no pertenece al panel VBox");
             
        
        // Creamos dos botones
        Button button1 = new Button("Botón 1");
        Button button2 = new Button("Botón 2");

        // Añadimos los botones al Vbox
        VBox vbox = new VBox(button1, button2);
        vbox.getStylesheets().add("recursos/css/JMetroLightTheme.css");
        
        // Añadimos el vbox como hijo de rañz
        root.getChildren().add(vbox);
        
        // Añadimos el botñn como hijo de raiz. Nñtese que ñste no es hijo del VBox
        root.getChildren().add(btn);
        
        // Crear la escena para que contenga la rañz
        Scene scene = new Scene(root, 300, 250);
        
        // Tñtulo de la ventana        
        primaryStage.setTitle("Prueba Specific Parent CSS");
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
