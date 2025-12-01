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
//        Producto: 
//             Agregar
//             Modificar
//             Eliminar
//             Listar
//        Venta:
//             Hacer venta

import com.gestionCafeteria.modelo.Cliente;
import com.gestionCafeteria.modelo.Empleado;
import com.gestionCafeteria.modelo.Producto;
import com.gestionCafeteria.modelo.Venta;
import com.gestionCafeteria.modelo.MenuRestaurante;


import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionMenuUsuario {

    public static void main(String[] args) {
        GestionEmpleado.agregarEmpleadosParaData();
        GestionCliente.agregarClientesParaData();


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
            "\t2. Producto\n" +
            "\t3. Venta\n" +
            "\t0. Salir\n" +
            "=========================================================\n";
    private static String textoMenuClientes = "=========== Gestion de Clientes ===========\n" +
            "Por favor seleccione una de las siguientes opciones:\n" +
            "\t1. Agregar Cliente\n" +
            "\t2. Modificar Cliente\n" +
            "\t3. Eliminar Cliente\n" +
            "\t4. Buscar Cliente\n" +
            "\t5. Listar Clientes\n"+
            "\t0. Atras\n";
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
                System.out.println(String.format("Bienvenido/a %s!", nombreDelEmpleado));
            } else {
                System.out.println("Error: No se pudo iniciar sesión. Legajo o contraseña incorrecta.");
                mostrarMenuInicioSesion();
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Legajo invalido, por favor ingrese un legajo con valor numerico.");
            //Recursividad hasta que el legajo sea valido
            scanner.nextLine();
            mostrarMenuInicioSesion();
        } catch (NullPointerException e) {
            System.out.println("Error inesperado al iniciar sesion: " + e.getMessage());
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
                    mostrarMenuProducto();
                    break;
                case 3:
                    mostrarMenuVenta();
                    break;
                case 0:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor ingrese (1, 2, 3 o 0)");
                    mostrarMenuPrincipal();
            }

        } catch (InputMismatchException e) {
            System.out.println("Opcion invalida. Por favor ingrese (1, 2, 3 o 0)");
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
                    int puntos = 0;
                    Cliente nuevoCliente = new Cliente(dni, nombre, apellido, email, puntos );
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
                case 5: // Listar
                    System.out.println("== Lista de Clientes ==");
                    GestionCliente.listarClientes();
                case 0:
                    //Atras
                    mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println("Error: Opcion invalida. Por favor ingrese un valor numerico (1, 2, 3, 4, 5 o 0)");
                    mostrarMenuCliente();
            }
            if (opcion != 0) {
                //Si la opcion es 0 no quiero esperar ni presionar una tecla para continuar.
                System.out.println("Presione enter para continuar");
                scanner.nextLine();
                mostrarMenuCliente();
            }


        } catch (InputMismatchException e) {
            System.out.println("Error: Opcion invalida. Por favor ingrese un valor numerico (1, 2, 3, 4 o 0)");
            scanner.nextLine();
            mostrarMenuCliente();
        }
    }
    public static void mostrarMenuProducto() {
        int opcionP = -1;
        Scanner sc = new Scanner(System.in);
        GestionProductos gestionProductos = new GestionProductos();

        while (opcionP != 0) {
            System.out.println("\n=========== Gestion de Productos ===========\n" +
                "Por favor seleccione una de las siguientes opciones:");
            System.out.println("\t1. Agregar producto");
            System.out.println("\t2. Eliminar producto");
            System.out.println("\t3. Listar productos");
            System.out.println("\t4. Modificar producto");
            System.out.println("\t0. Volver al menú principal");
            System.out.print("Elegir opción: ");
                        
            try {
                opcionP = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número.");
                continue;
            }

            switch (opcionP) {
                case 1:
                    System.out.println("\n--- Agregar producto ---");
                    try {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine().trim();

                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(sc.nextLine().trim());

                        System.out.print("Categoría: ");
                        String categoria = sc.nextLine().trim();

                        Producto nuevo = new Producto(id, nombre, precio, categoria);
                        boolean agregado = gestionProductos.agregarProducto(nuevo);
                        if (agregado) {
                            System.out.println("Producto agregado.");
                        } else {
                            System.out.println("No se pudo agregar: ya existe un producto con ese ID.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Datos inválidos. Operación cancelada.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Eliminar producto ---");
                    try {
                        System.out.print("ID del producto a eliminar: ");
                        int idEliminar = Integer.parseInt(sc.nextLine().trim());
                        gestionProductos.eliminarProducto(idEliminar);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido. Operación cancelada.");
                    }
                                
                case 3:
                    System.out.println("\n--- Lista de productos ---");
                    for (Producto p : gestionProductos.listarProductos()) {
                        System.out.println(p);
                        System.out.println("--------------------");
                    }
                    break;
                            
                case 4:
                    System.out.println("\n--- Modificar producto ---");
                    try {
                        System.out.print("ID del producto a modificar: ");
                        int idModificar = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = sc.nextLine().trim();

                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = Double.parseDouble(sc.nextLine().trim());

                        System.out.print("Nueva categoría: ");
                        String nuevaCategoria = sc.nextLine().trim();

                        gestionProductos.modificarProducto(idModificar, nuevoNombre, nuevoPrecio, nuevaCategoria);
                    } catch (NumberFormatException e) {
                        System.out.println("Datos inválidos. Operación cancelada.");
                    }
                    break;

                case 0:
                    System.out.println("Volviendo al menú principal...");
                    mostrarMenuPrincipal();
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }
        } 
        sc.close();
    }

    public static void mostrarMenuVenta() {
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        GestionProductos gestionProductos = new GestionProductos();
        GestionVentas gestionVentas = new GestionVentas();
        MenuRestaurante menu = new MenuRestaurante(gestionProductos);

        while (opcion != 0) {
            System.out.println("=========== MENU VENTA ===========");
            System.out.println("\t1. Hacer venta");
            System.out.println("\t2. Lista de ventas");
            System.out.println("\t0. Volver al menu principal");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Hacer venta ---");

                    Venta venta = gestionVentas.crearVenta();
                    int seguir = 1;

                    while (seguir == 1){
                        
                        System.out.println(menu);

                        System.out.print("ID del producto: ");
                        int idProd;
                        try {
                            idProd = Integer.parseInt(sc.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("ID inválido.");
                            continue;
                        }

                        Producto prod = gestionProductos.buscarProducto(idProd);
                        if (prod == null) {
                            System.out.println("Producto no encontrado.");
                            continue;
                        }

                        System.out.print("Cantidad: ");
                        int cant;
                        try {
                            cant = Integer.parseInt(sc.nextLine().trim());
                            if (cant <= 0) {
                                System.out.println("Cantidad debe ser mayor que 0.");
                                continue;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Cantidad inválida.");
                            continue;
                        }

                        gestionVentas.agregarProductoAVenta(venta, prod, cant);
                        System.out.println("Producto agregado a la venta.");

                        System.out.print("¿Agregar otro? (1=Sí / Otro=No): ");
                        try {
                            seguir = Integer.parseInt(sc.nextLine().trim());
                            if (seguir != 0 && seguir != 1) {
                                seguir = 0;
                            }
                        } catch (NumberFormatException e) {
                            seguir = 0;
                        }
                    }

                    System.out.println("\nVenta registrada.");
                    System.out.println(venta);
                    break;

                case 2:
                    System.out.println("\n--- Lista de ventas ---");
                    for (Venta v : gestionVentas.listarVentas()) {
                        System.out.println(v);
                        System.out.println("------------------------");
                    }
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");  
                    mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        }
       sc.close();
    }
    
}
