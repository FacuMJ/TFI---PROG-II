package com.cafeteria.modelo;

public class Mesa {
    // Los atributos
    private int numero;
    private int capacidad;
    private boolean disponible;

    // El constructor
    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.disponible = true;  // Por defecto está disponible
    }

    public int getNumero() {
        return numero;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public boolean estaDisponible() {
        return disponible;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Mesa #" + numero + " (" + capacidad + " personas)";
    }
}