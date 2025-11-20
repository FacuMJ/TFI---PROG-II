package src.Modelo;

import java.util.ArrayList;
import java.util.List;

public class MenuRestaurante {

    private List<Producto> productos;

    public MenuRestaurante() {
        this.productos = new ArrayList<>();
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
            sb.append(p.toString()).append("\n\n");
        }
        return sb.toString();
    }
}
