package src.Servicios;


import src.Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class GestionProductos {

    private List<Producto> productos;

    public GestionProductos() {
        this.productos = new ArrayList<>();
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
