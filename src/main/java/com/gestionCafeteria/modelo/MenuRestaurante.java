package com.gestionCafeteria.modelo;

import com.gestionCafeteria.servicios.GestionProductos;
import java.util.List;

public class MenuRestaurante {

    private GestionProductos gestionProductos;

    // ahora el menú no contiene su propia lista; lee desde la gestión central
    public MenuRestaurante(GestionProductos gestionProductos) {
        this.gestionProductos = gestionProductos;
    }

    public List<Producto> getProductos() {
        return gestionProductos.listarProductos();
    }

    public Producto buscarPorId(int id) {
        return gestionProductos.buscarProducto(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MENÚ DEL RESTAURANTE:\n");
        for (Producto p : getProductos()) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}