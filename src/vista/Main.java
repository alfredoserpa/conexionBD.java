package vista;

import modelo.GestorProductos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Producto;

public class Main extends JFrame {
    private GestorProductos gestor;

    public Main() {
        gestor = new GestorProductos();
        configurarVentana();
        crearComponentes();
    }

    private void configurarVentana() {
        setTitle("Gestión de Productos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
    }

    private void crearComponentes() {
        // Campo para nombre
        JLabel nombreLabel = new JLabel("Nombre del Producto:");
        JTextField nombreField = new JTextField(15);
        add(nombreLabel);
        add(nombreField);

        // Campo para precio
        JLabel precioLabel = new JLabel("Precio:");
        JTextField precioField = new JTextField(15);
        add(precioLabel);
        add(precioField);

        // Campo para stock
        JLabel stockLabel = new JLabel("Stock:");
        JTextField stockField = new JTextField(15);
        add(stockLabel);
        add(stockField);

        // Botón para agregar producto sostenible
        JButton agregarSostenibleButton = new JButton("Agregar Sostenible");
        agregarSostenibleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                double precio = Double.parseDouble(precioField.getText());
                int stock = Integer.parseInt(stockField.getText());
                gestor.agregarProductoSostenible(nombre, precio, stock);
                JOptionPane.showMessageDialog(null, "Producto Sostenible Agregado");
                nombreField.setText(""); // Limpiar el campo
                precioField.setText(""); // Limpiar el campo
                stockField.setText(""); // Limpiar el campo
            }
        });
        add(agregarSostenibleButton);

        // Botón para agregar producto no sostenible
        JButton agregarNoSostenibleButton = new JButton("Agregar No Sostenible");
        agregarNoSostenibleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                double precio = Double.parseDouble(precioField.getText());
                int stock = Integer.parseInt(stockField.getText());
                gestor.agregarProductoNoSostenible(nombre, precio, stock);
                JOptionPane.showMessageDialog(null, "Producto No Sostenible Agregado");
                nombreField.setText(""); // Limpiar el campo
                precioField.setText(""); // Limpiar el campo
                stockField.setText(""); // Limpiar el campo
            }
        });
        add(agregarNoSostenibleButton);

        // Botón para mostrar productos
        JButton mostrarButton = new JButton("Mostrar Productos");
mostrarButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String productosString = gestor.mostrarProductosComoString();
        JOptionPane.showMessageDialog(null, productosString);
    }
});
add(mostrarButton);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main ui = new Main();
            ui.setVisible(true);
        });
    }
}
