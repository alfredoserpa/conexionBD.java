package control;

import modelo.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PruebaConexion {

    public static void main(String[] args) {
        // Obtener la instancia de la conexión
        ConexionBD conexionBD = ConexionBD.getInstancia();
        Connection conexion = conexionBD.getConexion();
        
        if (conexion != null) {
            try {
                // Crear una consulta de prueba
                Statement stmt = conexion.createStatement();
                String query = "SELECT * FROM productos_sostenibles";
                ResultSet rs = stmt.executeQuery(query);

                // Imprimir los resultados de la consulta
                while (rs.next()) {
                    System.out.println("Producto: " + rs.getString("nombre") + ", Precio: " + rs.getDouble("precio"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error al conectar con la base de datos.");
        }
    }
}
