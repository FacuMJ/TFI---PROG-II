package com.gestionCafeteria.servicios;

import com.gestionCafeteria.modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GestionProductos {

    // TreeMap para mantener los productos ordenados por id
    private Map<Integer, Producto> productosById = new TreeMap<>();

    public GestionProductos() {
        this.productosById = new TreeMap<>();
        inicializarProductosBase();
    }

    private void inicializarProductosBase() {
        agregarProducto(new Producto(1, "Café", 2000.0, "Bebida"));
        agregarProducto(new Producto(2, "Sandwich", 4000.0, "Comida"));
        agregarProducto(new Producto(3, "Agua", 1000.0, "Bebida"));
        agregarProducto(new Producto(4, "Medialuna", 1100.0, "Comida"));
        agregarProducto(new Producto(5, "Especial Jáuregui", 5000.0, "Comida"));
        agregarProducto(new Producto(6, "Iariña Triple", 6000.0, "Comida"));
    }

    // devuelve true si se agregó, false si ya existía un producto con ese id
    public boolean agregarProducto(Producto p) {
        if (p == null) return false;
        if (productosById.containsKey(p.getId())) return false;
        productosById.put(p.getId(), p);
        return true;
    }

    public Producto buscarProducto(int id) {
        return productosById.get(id);
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(productosById.values());
    }

    public void eliminarProducto(int id) {
        Producto p = buscarProducto(id);
        if (p != null) {
            productosById.remove(id);
            System.out.println("Producto eliminado: " + p);
        }
    }

    public void modificarProducto(int id, String nuevoNombre, double nuevoPrecio, String nuevaCategoria) {
        Producto p = buscarProducto(id);
        if (p != null) {
            p.setNombre(nuevoNombre);
            p.setPrecio(nuevoPrecio);
            p.setCategoria(nuevaCategoria);
            System.out.println("Producto modificado: " + nuevoNombre);
        }
    }

}