package com.gestionCafeteria.servicios;

import com.gestionCafeteria.modelo.Empleado;

import java.util.ArrayList;

/**
 * Se utiliza para gestionar la lista de empleados y el inicio de sesión
 * */

public class GestionEmpleado {
    private static ArrayList<Empleado> listaEmpleados;

    private Empleado buscarEmpleado(int legajo) {
        //buscar
        return null;
    }

    private void iniciarSesion(int legajo, String contrasena) {
        Empleado empleado = buscarEmpleado(legajo);
        String contrasenaCorrecta = empleado.getContrasena();
        if (contrasena.equals(contrasenaCorrecta)) {
            System.out.println(String.format("Bievenido %s!", empleado.getNombre()));
        } else {
            System.out.println("Error: No se pudo iniciar sesión, legajo o contraseña incorrectas.");
        }
    }
}
