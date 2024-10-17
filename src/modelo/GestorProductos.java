package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
    private Connection connection;

    public GestorProductos() {
        try {
            // Cambia la URL, usuario y contraseña según tu configuración de base de datos
            String url = "jdbc:mysql://localhost:3306/ods_db";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarProductoSostenible(String nombre, double precio, int stock) {
        String query = "INSERT INTO productos_sostenibles (nombre, precio, stock) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);
            stmt.setInt(3, stock);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarProductoNoSostenible(String nombre, double precio, int stock) {
        String query = "INSERT INTO productos_no_sostenibles (nombre, precio, stock) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);
            stmt.setInt(3, stock);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> mostrarProductos() {
        List<Producto> productos = new ArrayList<>();
        String querySostenibles = "SELECT * FROM productos_sostenibles";
        String queryNoSostenibles = "SELECT * FROM productos_no_sostenibles";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rsSostenibles = stmt.executeQuery(querySostenibles);
            while (rsSostenibles.next()) {
                int id = rsSostenibles.getInt("id");
                String nombre = rsSostenibles.getString("nombre");
                double precio = rsSostenibles.getDouble("precio");
                int stock = rsSostenibles.getInt("stock");
                productos.add(new ProductoSostenible(id, nombre, precio, stock));
            }

            ResultSet rsNoSostenibles = stmt.executeQuery(queryNoSostenibles);
            while (rsNoSostenibles.next()) {
                int id = rsNoSostenibles.getInt("id");
                String nombre = rsNoSostenibles.getString("nombre");
                double precio = rsNoSostenibles.getDouble("precio");
                int stock = rsNoSostenibles.getInt("stock");
                productos.add(new ProductoNoSostenible(id, nombre, precio, stock));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    public String mostrarProductosComoString() {
        StringBuilder sb = new StringBuilder();
        List<Producto> productos = mostrarProductos();

        if (productos.isEmpty()) {
            return "No hay productos disponibles.";
        }

        for (Producto producto : productos) {
            sb.append(producto.toString()).append("\n");
        }

        return sb.toString();
    }

    public void actualizarProducto(int id, String nuevoNombre, double nuevoPrecio, int nuevoStock) {
        String query = "UPDATE productos_sostenibles SET nombre = ?, precio = ?, stock = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nuevoNombre);
            stmt.setDouble(2, nuevoPrecio);
            stmt.setInt(3, nuevoStock);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


    
    
