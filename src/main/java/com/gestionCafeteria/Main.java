package com.gestionCafeteria;

import com.gestionCafeteria.servicios.GestionCliente;
import com.gestionCafeteria.servicios.GestionEmpleado;
import com.gestionCafeteria.servicios.GestionMenuUsuario;
public class Main {

    public static void main(String[] args) {
        GestionEmpleado.agregarEmpleadosParaData();
        GestionCliente.agregarClientesParaData();

        GestionMenuUsuario.mostrarMenuInicioSesion();
        GestionMenuUsuario.mostrarMenuPrincipal();
        
    }
}
