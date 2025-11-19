package com.cafeteria.modelo;

public class Cliente {
    //Los atributos
    private String DNI;
    private String nombre;
    private String telefono;
    private String email;

    // El constructor
    public Cliente(String DNI, String nombre, String telefono) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = "";
    }

    // Los getters
    public String getDNI() {
        return DNI;
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
    public void setDNI(String id) {
        this.DNI = id;
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
        return nombre + " (" + telefono + ")";
    }
}
