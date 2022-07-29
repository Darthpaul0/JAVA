package pruebabd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection cnx = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                //crear conexión con la base de datos (driver:marcaBD:local o no:puerto:nombre_BD, usuario, clave)
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria", "root", "");
            } catch (SQLException ex) {
                throw new SQLException(ex);
            }
        }
        return cnx;
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
}
