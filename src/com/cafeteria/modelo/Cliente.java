package com.cafeteria.modelo;

public class Cliente {
    //Los atributos
    private int dni;
    private String nombre;
    private String telefono;
    private String email;

    // El constructor
    public Cliente(int dni, String nombre, String telefono, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // Los getters
    public int getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getEmail() {
        return email;
    }

    //Los Setters
    public void setDni(int dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return dni + ", " + nombre + " (" + telefono + ")" + " (" + email + ")";
    }
}
