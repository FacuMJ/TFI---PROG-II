package src.Modelo;

public class DetalleVenta {

    private Producto producto;
    private int cantidad;

    public DetalleVenta(Producto producto, int cantidad) {
        if (producto == null) throw new IllegalArgumentException("Producto no puede ser null");
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad debe ser > 0");
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    // calculado dinámicamente para evitar inconsistencias si cambia el precio fuera
    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return  producto.getNombre()+ " x" + cantidad + " - Subtotal:" + getSubtotal();
    }
}