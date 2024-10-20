package modelo;

public abstract class Producto {
    protected int id;
    protected String nombre;
    protected double precio;
    protected int stock;
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Precio: " + precio + ", Stock: " + stock;
    }
    

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setStock(int stock) { this.stock = stock; }
}
