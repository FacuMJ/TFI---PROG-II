package com.gestionCafeteria.servicios;

import com.gestionCafeteria.modelo.Cliente;
import com.gestionCafeteria.modelo.Mesa;
import com.gestionCafeteria.modelo.Reserva;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GestionReserva {
    private static ArrayList<Reserva> listaReservas;
    private static Mesa[] listaDeMesas = new Mesa[15]; // No agrego ni quito mesas, por eso uso array.

    //Agregar reservas
    private static ArrayList<Reserva> reservasRegistradas;

    private static void agregarReserva(Reserva nuevaReserva) {
        reservasRegistradas.add(nuevaReserva);
        System.out.println(String.format("Reserva agregada correctamente: %s", nuevaReserva));
    }
    //Eliminar reservas
    private static Reserva buscarReserva(String idReserva) {
        // Implementar
        return null;
    }


    private static void eliminarReserva(String idReserva) {
        Reserva reservaAEliminar = buscarReserva(idReserva);
        reservasRegistradas.remove(reservaAEliminar);
    }

    //Modificar reserva
    //Listar


    //Mesas disponibles en relacion a Fecha Hora y Cantidad de Personas.

    //Buscar reservas
    private static Mesa buscarMesasDisponiblesPorFechaYCantidad(LocalDateTime fechaYHora, int cantPersonas) {

        //Busco en mi lista de Reservas mesas disponibles para esa fecha y hora
        //Busco mis reservas en esa fecha y hora (mas 2 horas aprox) Una mesa reservada a las 9 se libera a las 11.
        //De estas reservas que encontre arriba, obtengo las mesas
        //De mi lista de mesas devuelvo cualquier mesa que no sea una de estas.
        //Y que cumpla con la cantidad de personas

        // Se puede hacer con lambda filter

        return null;
    }
}
