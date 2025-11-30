package com.gestionCafeteria.servicios;

import com.gestionCafeteria.modelo.Empleado;

import java.util.ArrayList;

/**
 * Se utiliza para gestionar la lista de empleados y el inicio de sesión
 * */

public class GestionEmpleado {
    private static ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    public static Empleado buscarEmpleado(int legajo) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getLegajo() == legajo) {
                return empleado;
            }
        }
        return null;
    }

    public static void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public static boolean iniciarSesion(int legajo, String contrasena) {
        Empleado empleado = buscarEmpleado(legajo);
        String contrasenaCorrecta = empleado.getContrasena();
        if (contrasena.equals(contrasenaCorrecta)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo no final, solo se usa para tener empleados para hacer pruebas
     * Se puede eliminar despues
     *
     *
     */
    public static void agregarEmpleadosParaData() {
        Empleado empleado1 = new Empleado(23456789, "Juan", "Perez", "jp@gmail.com", 12345, "juanperez123");
        Empleado empleado2 = new Empleado(45756789, "Maria", "Lopez", "mary@gmail.com", 54321, "123123");
        Empleado empleado3 = new Empleado(43756789, "Pedro", "Martinez", "pedritovm@gmail.com", 56789, "123123");
        Empleado empleado4 = new Empleado(35656789, "Mateo", "Avila", "matheus@gmail.com", 98765, "123123");
        Empleado empleado5 = new Empleado(40467567, "Judas", "Gonzalez", "nosoytraidor@gmail.com", 34521, "123123");

        listaEmpleados.add(empleado1);
        listaEmpleados.add(empleado2);
        listaEmpleados.add(empleado3);
        listaEmpleados.add(empleado4);
        listaEmpleados.add(empleado5);
    }
}
