package com.gestionCafeteria.servicios;

//1. Menu para iniciar sesion - Hecho
//2. Menu Principal (Cliente, Reserva, Productos) - Hecho
//        Cliente:
//              Agregar
//              Modificar
//                  Preguntar que campo modificar
//                  Preguntar el nuevo valor
//              Eliminar
//              Buscar
//        Reserva: ...
//        Producto: ...

import com.gestionCafeteria.modelo.Cliente;
import com.gestionCafeteria.modelo.Empleado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionMenuUsuario {

    public static void main(String[] args) {
        GestionEmpleado.agregarEmpleadosParaData();


        mostrarMenuInicioSesion();
        mostrarMenuPrincipal();

    }

    private static Scanner scanner = new Scanner(System.in);

    private static String textoInicioSesion = "=========================================================\n" +
            "Bievenido al software de Gestion de Cafeteria!\n" +
            "Por favor ingrese su legajo:\n" +
            "=========================================================\n";
    private static String textoMenuPrincipal = "=========================================================\n" +
            "Menu Principal de Gestiones\n" +
            "Por favor seleccione una de las siguientes opciones:\n" +
            "\t1. Cliente\n" +
            "\t2. Reserva\n" +
            "\t3. Producto\n" +
            "\t4. Salir\n" +
            "=========================================================\n";
    private static String textoMenuClientes = "=========================================================\n" +
            "Menu Principal de Gestion de Cliente\n" +
            "Por favor seleccione una de las siguientes opciones:\n" +
            "\t1. Agregar Cliente\n" +
            "\t2. Modificar Cliente\n" +
            "\t3. Eliminar Cliente\n" +
            "\t4. Buscar Cliente\n" +
            "\t5. Atras\n" +
            "=========================================================\n";
    private static String textoModificarCliente = "\n=== MODIFICAR CLIENTE === \n"+
                                                  "\t¿Que desea modificar?\n"+
                                                  "\t1- Nombre\n"+
                                                  "\t2- Apellido\n"+
                                                  "\t3- Email\n"+
                                                  "\t Seleccione una opción (1-3): \n";

    public static void mostrarMenuInicioSesion() {
        System.out.println(textoInicioSesion);
        try {
            int legajo = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Por favor ingrese su contraseña: ");
            String contrasena = scanner.nextLine();
            boolean inicioCorrecto = GestionEmpleado.iniciarSesion(legajo, contrasena);

            //No se pudo iniciar sesion, pido los datos de nuevo con recursividad
            if (inicioCorrecto) {
                Empleado empleado = GestionEmpleado.buscarEmpleado(legajo);
                String nombreDelEmpleado = empleado.getNombre();
                System.out.println(String.format("Bienvenido %s!", nombreDelEmpleado));
            } else {
                System.out.println("Error: No se pudo iniciar sesión. Legajo o contraseña incorrecta.");
                mostrarMenuInicioSesion();
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Legajo invalido, por favor ingrese un legajo con valor numerico.");
            //Recursividad hasta que el legajo sea valido
            scanner.nextLine();
            mostrarMenuInicioSesion();
        }
    }

    public static void mostrarMenuPrincipal() {
        System.out.println(textoMenuPrincipal);
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarMenuCliente();
                    break;
                case 2:
                    //Menu producto
                    break;
                case 3:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Error: Opcion invalida. Por favor ingrese un valor numerico (1, 2, o 3)");
                    mostrarMenuPrincipal();
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Opcion invalida. Por favor ingrese un valor numerico (1, 2 o 3");
            scanner.nextLine();
            mostrarMenuPrincipal();
        }
    }

    public static void mostrarMenuCliente() {
        System.out.println(textoMenuClientes);
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            int dni;
            switch (opcion) {
                case 1:
                    // Agregar
                    // Se puede agregar validacion de datos para el DNI y email.
                    System.out.println("Ingrese el DNI del cliente");
                    dni = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre del cliente");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del cliente");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese el email del cliente");
                    String email = scanner.nextLine();
                    Cliente nuevoCliente = new Cliente(dni, nombre, apellido, email);
                    GestionCliente.agregarCliente(nuevoCliente);
                    break;
                case 2:
                    //Modificar
                    System.out.println("Ingrese el DNI del cliente a modificar");
                    dni = scanner.nextInt();
                    scanner.nextLine();
                    Cliente clienteAModificar = GestionCliente.buscarCliente(dni);
                    System.out.println(String.format(" ===DATOS ACTUALES DEL CLIENTE ===\n%s", clienteAModificar));
                    System.out.println(textoModificarCliente);
                    int opcionModificar = scanner.nextInt();
                    scanner.nextLine();
                    String nuevoValor;
                    switch (opcionModificar) {
                        case 1:
                            System.out.print("Ingrese nuevo nombre: ");
                            nuevoValor = scanner.nextLine();
                            break;
                        case 2:
                            System.out.print("Ingrese nuevo apellido: ");
                            nuevoValor = scanner.nextLine();
                            break;
                        case 3:
                            System.out.print("Ingrese nuevo email: ");
                            nuevoValor = scanner.nextLine();
                            break;
                        default:
                            System.out.println("ERROR: Opción inválida, por favor, elija una opcion entre 1 a 3");
                            return;
                    }
                    GestionCliente.modificarCliente(dni,opcionModificar,nuevoValor);
                    clienteAModificar =  GestionCliente.buscarCliente(dni);
                    System.out.println(String.format("\n==== CLIENTE CON DATOS ACTUALIZADOS ====\n%s", clienteAModificar));
                    break;
                case 3:
                    //Eliminar
                    System.out.println("Ingrese el DNI del cliente a eliminar");
                    dni = scanner.nextInt();
                    scanner.nextLine();
                    GestionCliente.eliminarCliente(dni);
                    break;
                case 4:
                    //Buscar
                    System.out.println("Ingrese el DNI del cliente que quiere buscar");
                    dni = scanner.nextInt();
                    scanner.nextLine();
                    GestionCliente.buscarCliente(dni);
                    break;
                case 5:
                    //Atras
                    mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println("Error: Opcion invalida. Por favor ingrese un valor numerico (1, 2, 3, 4 o 5)");
                    mostrarMenuCliente();
            }
            if (opcion != 5) {
                //Si la opcion es 5 no quiero esperar ni presionar una tecla para continuar.
                System.out.println("Presione enter para continuar");
                scanner.nextLine();
                mostrarMenuCliente();
            }


        } catch (InputMismatchException e) {
            System.out.println("Error: Opcion invalida. Por favor ingrese un valor numerico (1, 2, 3, 4 o 5)");
            scanner.nextLine();
            mostrarMenuCliente();
        }
    }
}
