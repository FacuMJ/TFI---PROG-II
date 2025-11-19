package com.cafeteria.modelo;

import java.util.Date;

public class Reserva {
    // Los atributos
    private String id;
    private Cliente cliente;
    private Mesa mesa;
    private Date fechaReserva;
    private int cantidadPersonas;
    private String estado; // CONFIRMADA, PENDIENTE, CANCELADA
    private String notas;

    // El constructor
    public Reserva(String id, Cliente cliente, Mesa mesa, Date fechaReserva, int cantidadPersonas) {
        this.id = id;
        this.cliente = cliente;
        this.mesa = mesa;
        this.fechaReserva = fechaReserva;
        this.cantidadPersonas = cantidadPersonas;
        this.estado = "PENDIENTE";
        this.notas = "";
    }

    // Los getters
    public String getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Mesa getMesa() {
        return mesa;
    }
    public Date getFechaReserva() {
        return fechaReserva;
    }
    public int getCantidadPersonas() {
        return cantidadPersonas;
    }
    public String getEstado() {
        return estado;
    }
    public String getNotas() {
        return notas;
    }

    // Los setters
    public void setId(String id) {
        this.id = id;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    public void setCantidadPersonas(int cantidadPersonas) {
        if (cantidadPersonas > 0) {
            this.cantidadPersonas = cantidadPersonas;
        }
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setNotas(String notas) {
        this.notas = notas;
    }

    // Métodos especiales
    public void confirmarReserva() {
        setEstado("CONFIRMADA");
        System.out.println(" Reserva " + this.id + " confirmada");
    }

    public void cancelarReserva() {
        setEstado("CANCELADA");
        System.out.println("Reserva " + this.id + " cancelada");
    }

    public boolean estaConfirmada() {
        return "CONFIRMADA".equalsIgnoreCase(this.estado);
    }

    public boolean puedeCancelarse() {
        return "PENDIENTE".equalsIgnoreCase(this.estado) || "CONFIRMADA".equalsIgnoreCase(this.estado);
    }

    @Override
    public String toString() {
        return "Reserva #" + id + " - " + cliente.getNombre() + " - Mesa " + mesa.getNumero() + " - " + estado;
    }
}