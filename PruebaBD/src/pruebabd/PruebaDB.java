package pruebabd;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaDB {
/** Clase principal y método MAIN
     * @param args */
    public static void main(String[] args) {
        //Aquí introducimos la consulta SQL
        String consulta="SELECT email FROM empleado";
        
        try {
            Statement sentencia=Conexion.obtener().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            while (resultado.next())
            {
                //aquí hay que especificarle qué queremos obtener y el número de columnas
                //en este caso, obtendremos una columna tipo String 
                System.out.println (resultado.getString (1));
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}