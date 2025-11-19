package com.gestionCafeteria.servicios;


import com.gestionCafeteria.modelo.Cliente;

import java.util.ArrayList;

/**
 * Se utiliza para manejar la lista de los Clientes. Realizar altas bajas y modificaciones
 *
 * */
public class GestionCliente {
    private static ArrayList<Cliente> clientesRegistrados;

    private static void agregarCliente(Cliente nuevoCliente) {
        clientesRegistrados.add(nuevoCliente);
        System.out.println(String.format("Cliente agregado correctamente: %s", nuevoCliente));
    }

    private static Cliente buscarCliente(int dniCliente) {
        // Implementar
        return null;
    }

    private static void eliminarCliente(int dniCliente) {
        Cliente clienteAEliminar = buscarCliente(dniCliente);
        clientesRegistrados.remove(clienteAEliminar);
    }

    private static void listarClientes() {
        // Implementar despues, se puede usar Expresiones Lambda
    }

    private static void modificarCliente(int dniCliente) {
        //Busco cliente
        //Lo muestro
        //Pregunto que atributo quiere modificar
        //Pido el nuevo valor para ese atributo
        //hago la modificacion con cliente.set
    }

}
