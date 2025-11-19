package com.cafeteria.modelo;

public class Mesa {
    // Los atributos
    private String id;
    private int numero;
    private int capacidad;
    private boolean disponible;

    // El constructor
    public Mesa(String id, int numero, int capacidad) {
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
        this.disponible = true;  // Por defecto está disponible
    }

    // Los getters
    public String getId() {
        return id;
    }
    public int getNumero() {
        return numero;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public boolean isDisponible() {
        return disponible;
    }

    // Los setters
    public void setId(String id) {
        this.id = id;
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