package com.gestionCafeteria.modelo;

import java.time.LocalDateTime;
import java.util.Date;

public class Reserva {
    private String idReserva;
    private Cliente cliente;
    private LocalDateTime fechaYHora;
    private int cantidadPersonas;
    private Mesa mesa;

    public Reserva(String idReserva, Mesa mesa, int cantidadPersonas, LocalDateTime fechaYHora, Cliente cliente) {
        this.idReserva = idReserva;
        this.mesa = mesa;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaYHora = fechaYHora;
        this.cliente = cliente;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}
