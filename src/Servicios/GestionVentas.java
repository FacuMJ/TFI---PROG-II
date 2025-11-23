package src.Servicios;

import src.Modelo.DetalleVenta;
import src.Modelo.Producto;
import src.Modelo.Venta;

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

    public List<Venta> listarVentas() {
        return ventas;
    }
}