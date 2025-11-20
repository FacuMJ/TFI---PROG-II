package src.Modelo;

import java.util.ArrayList;
import java.util.List;

public class MenuRestaurante {

    private List<Producto> productos;

    public MenuRestaurante() {
        this.productos = new ArrayList<>();
        inicializarProductosBase();  // <<--- agrega productos base
    }

    private void inicializarProductosBase() {
        // Puedes elegir los ID y precios que desees
        agregarProducto(new Producto(1, "Café", 750.0, "Bebida"));
        agregarProducto(new Producto(2, "Sanbuchito", 1800.0, "Comida"));
        agregarProducto(new Producto(3, "Agua", 500.0, "Bebida"));
        agregarProducto(new Producto(4, "Medialuna", 600.0, "Panadería"));
        // Puedes sumar más productos aquí...
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MENÚ DEL RESTAURANTE:\n");
        for (Producto p : productos) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}