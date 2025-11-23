package src.Modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Venta {

    private int id;
    private LocalDateTime fecha;
    private List<DetalleVenta> detalles;

    public Venta(int id) {
        this.id = id;
        this.fecha = LocalDateTime.now();
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetalleVenta detalle) {
        if (detalle == null) throw new IllegalArgumentException("Detalle no puede ser null");
        detalles.add(detalle);
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public double getTotal() {
        double suma = 0.0;
        for (DetalleVenta d : detalles) {
            suma += d.getSubtotal();
        }
        return suma;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta ID: ").append(id)
          .append("\nFecha: ").append(fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
          .append("\nDetalles:\n");
        for (DetalleVenta detalle : detalles) {
            sb.append(" - ").append(detalle).append("\n");
        }
        sb.append("\nTotal: $").append(getTotal());
        return sb.toString();
    }
}