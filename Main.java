

import java.util.Scanner;
import src.Servicios.*;
import src.Modelo.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GestionProductos gestionProductos = new GestionProductos();
        GestionVentas gestionVentas = new GestionVentas();
        MenuRestaurante menu = new MenuRestaurante(gestionProductos);

        int opcion = -1;


        
        while (opcion != 0) {
            System.out.println("\n=========== CAFETERÍA ===========");
            System.out.println("1. Gestionar productos");
            System.out.println("2. Hacer venta");
            System.out.println("3. Listar ventas");
            System.out.println("0. Salir");
            System.out.print("Elegir opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número.");
                continue;
            }

            switch (opcion) {

                case 1:
                    int opcionP = -1;
                    while (opcionP != 0) {
                        
                        System.out.println("\n=========== Gestion de Productos ===========");
                        System.out.println("1. Agregar producto");
                        System.out.println("2. Eliminar producto");
                        System.out.println("3. Listar productos");
                        System.out.println("4. Modificar producto");
                        System.out.println("0. Volver al menú principal");
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
                                break;
                            default:
                                System.out.println("Opción incorrecta.");
                            }
                    } 
                    break;
                case 2:
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

                case 3:
                    System.out.println("\n--- Lista de ventas ---");
                    for (Venta v : gestionVentas.listarVentas()) {
                        System.out.println(v);
                        System.out.println("------------------------");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }
        }

        sc.close();
    }
}