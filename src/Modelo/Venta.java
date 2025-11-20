package src.Modelo;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Venta {

    private int id;
    private Date fecha;
    private List<DetalleVenta> detalles;
    private double total;

    public Venta(int id) {
        this.id = id;
        this.fecha = new Date(System.currentTimeMillis());
        this.detalles = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarDetalle(DetalleVenta detalle) {
        detalles.add(detalle);
        total += detalle.getSubtotal();
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }   

    public double getTotal() {
        return total;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta ID: ").append(id)
          .append("\nFecha: ").append(fecha)
          .append("\nTotal: ").append(total)
          .append("\nDetalles:\n");
        for (DetalleVenta detalle : detalles) {
            sb.append(detalle).append("\n");
        }
        return sb.toString();
    }
    

}
