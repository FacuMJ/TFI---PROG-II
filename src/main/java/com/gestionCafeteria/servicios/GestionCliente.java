package com.gestionCafeteria.servicios;


import com.gestionCafeteria.modelo.Cliente;

import java.util.ArrayList;


/**
 * Se utiliza para manejar la lista de los Clientes. Realizar altas bajas y modificaciones
 *
 * */
public class GestionCliente {
    private static ArrayList<Cliente> clientesRegistrados = new ArrayList<>();

    public static void agregarCliente(Cliente nuevoCliente) {
        clientesRegistrados.add(nuevoCliente);
        System.out.println(String.format("Cliente agregado correctamente: %s", nuevoCliente));
    }

    public static Cliente buscarCliente(int dniCliente) {
        for (Cliente cliente : clientesRegistrados) {
            if (cliente.getDni() == dniCliente) {
                System.out.println(String.format("Cliente con DNI: %d encontrado!\n%s", dniCliente, cliente));
                return cliente;
            }
        }
        System.out.println(String.format("Error: Cliente con DNI: %d no encontrado!", dniCliente));
        return null;
    }

    public static void eliminarCliente(int dniCliente) {
        Cliente clienteAEliminar = buscarCliente(dniCliente);
        if (clienteAEliminar != null) {
            System.out.println(String.format("Cliente eliminado correctamente: %s", clienteAEliminar));
            clientesRegistrados.remove(clienteAEliminar);
        }
    }

    public static void listarClientes() {
        System.out.println("Lista de clientes registrados:");
        clientesRegistrados.stream().forEach(System.out::println);
    }

    public static void modificarCliente(int dniCliente) {
        //Busco cliente
        //Lo muestro
        //Pregunto que atributo quiere modificar
        //Pido el nuevo valor para ese atributo
        //hago la modificacion con cliente.set
    }




}
