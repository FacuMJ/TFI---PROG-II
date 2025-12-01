package com.gestionCafeteria.modelo;

public class Empleado extends Persona{
    private int legajo;
    private String contrasena;

    public Empleado(int dni, String nombre, String apellido, String email, int legajo, String contrasena) {
        super(dni, nombre, apellido, email);
        this.legajo = legajo;
        this.contrasena = contrasena;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
