package com.gestionCafeteria.modelo;

public class Cliente extends Persona {
    private int puntos; //Acumula puntos con sus reservas, obtiene promociones en base a los puntos


    public Cliente(int dni, String nombre, String apellido, String email) {
        super(dni, nombre, apellido, email);
        this.puntos = 0; // Cuando se crea un cliente, empieza con 0 puntos.
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return super.toString() + ", Puntos: " + this.puntos;
    }
}
