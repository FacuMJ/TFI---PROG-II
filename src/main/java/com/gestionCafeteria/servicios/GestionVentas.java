package com.gestionCafeteria.servicios;

import com.gestionCafeteria.modelo.DetalleVenta;
import com.gestionCafeteria.modelo.Producto;
import com.gestionCafeteria.modelo.Venta;
import com.gestionCafeteria.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class GestionVentas {

    private List<Venta> ventas;
    private int contadorVentas;

    public GestionVentas() {
        this.ventas = new ArrayList<>();
        this.contadorVentas = 1;
    }

    public Venta crearVenta() {
        Venta v = new Venta(contadorVentas++);
        ventas.add(v);
        return v;
    }

    public void agregarProductoAVenta(Venta venta, Producto p, int cantidad) {
        if (venta == null || p == null) {
            throw new IllegalArgumentException("venta o producto nulos");
        }
        DetalleVenta detalle = new DetalleVenta(p, cantidad);
        venta.agregarDetalle(detalle);
    }

    public double agregarDescuentoVenta(Venta venta, Cliente cliente) {
        if (venta == null) {
            throw new IllegalArgumentException("venta nula");
        }

        if (cliente.getPuntos() >= 1000) {
            return 0.10;
        } else if (cliente.getPuntos() >= 500) {
            return 0.05;
        }else {
            return 0.0;
        }
    }

    public List<Venta> listarVentas() {
        return ventas;
    }
}