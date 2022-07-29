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
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Disposición de controles botón usando el layout BorderPane
 * @author Profesor
 */
public class BorderPaneEjemplo extends Application {
    
    private BorderPane raiz;
   
    @Override
    public void start(Stage stage)  {
        raiz = new BorderPane();
       
        raiz.setTop(new Button("ARRIBA -> TOP"));
        raiz.setBottom(new Button("ABAJO -> BOTTOM"));
        raiz.setLeft(new Button("IZQUIERDA -> LEFT"));
        raiz.setRight(new Button("DERECHA -> RIGHT"));
        raiz.setCenter(new Button("CENTRO -> CENTER"));
       
        Scene scene = new Scene(raiz, 300,190);
       
        stage.setTitle("Probando BorderPane");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);    
    }    
}
