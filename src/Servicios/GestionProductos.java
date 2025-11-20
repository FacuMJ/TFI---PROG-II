package src.Servicios;

import src.Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class GestionProductos {

    private List<Producto> productos;

    public GestionProductos() {
        this.productos = new ArrayList<>();
        inicializarProductosBase();
    }

    /**
     * Agrega automáticamente algunos productos predeterminados al iniciar.
     */
    private void inicializarProductosBase() {
        agregarProducto(new Producto(1, "Café", 750.0, "Bebida"));
        agregarProducto(new Producto(2, "Sanbuchito", 1800.0, "Comida"));
        agregarProducto(new Producto(3, "Agua", 500.0, "Bebida"));
        agregarProducto(new Producto(4, "Medialuna", 600.0, "Panadería"));
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public boolean eliminarProducto(int id) {
        return productos.removeIf(p -> p.getId() == id);
    }
}