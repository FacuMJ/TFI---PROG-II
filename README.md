# TFI---PROG-II
Este es el trabajo final integrador de Programación II

# Sistema de Gestión de Cafetería

Sistema de gestión integral para una cafetería desarrollado en Java que permite administrar completamente las operaciones diarias del negocio. Incluye sistema de autenticación para empleados y gestión de las principales áreas del establecimiento.

##  Descripción del Proyecto
El sistema organiza todas las funcionalidades mediante una clase GestionMenuUsuario, que contiene los distintos menús de interacción.
El programa se ejecuta desde la clase principal Main.java, que invoca los menús correspondientes. 
Incluye:
- Gestión de clientes (CRUD completo)
- Gestión de productos del menú
- Procesamiento de ventas
- Control de acceso por autenticación de empleados
- Sistema de descuentos por puntos acumulados

##  Objetivos Cumplidos
- Sistema de autenticación con empleados y contraseñas seguras
- CRUD completo para Clientes, Productos y Ventas
- Menús interactivos con validación de entrada 
- Persistencia en memoria durante la ejecución
- Estructuras de datos propias implementadas (TreeMap para productos ordenados)
- Programación Orientada a Objetos con herencia y polimorfismo
- Manejo de excepciones completo y mensajes de error claros
- Datos de prueba pre-cargados 
- Sistema de fidelización por puntos con descuentos automáticos

##  Funcionalidades Principales

 Sistema de Autenticación
- Autenticación de Empleados
- Validación de legajo y contraseña
- Mensajes de error personalizados
- Recuperación de datos del empleado logueado
- 5 empleados pre-cargados para pruebas
- Mensajes de error específicos para credenciales incorrectas
 
  Gestión de Clientes (CRUD)
- Agregar: Registro con DNI, nombre, apellido, email
- Modificar: Actualización selectiva de campos individuales
- Eliminar: Baja por DNI con confirmación automática
- Buscar: Consulta rápida por DNI
- Listar: Visualización completa con puntos acumulados

 Gestión de Productos
- Catálogo inicial con 6 productos categorizados
- Agregar nuevos productos con ID único
- Modificar nombre, precio y categoría
- Eliminar productos por ID
- Listar productos ordenados 

 Sistema de Ventas
- Creación de tickets de venta únicos
- Selección múltiple de productos
- Especificación de cantidades
- Cálculo automático de totales
- Historial completo de ventas realizadas
- Aplicación automática de descuentos por puntos

 Sistema de Descuentos por Puntos

Niveles de Descuento
- Nivel Básico (500-999 puntos): 5% de descuento en todas las compras
- Nivel Avanzado (1000+ puntos): 10% de descuento en todas las compras
- Clientes nuevos (<500 puntos): Sin descuento (acumulan puntos)

Cómo funciona:
- Acumulación: Cada cliente acumula puntos con sus compras
- Verificación: Al realizar una venta, se verifica el nivel de puntos
- Aplicación: Se aplica automáticamente el descuento correspondiente
- Beneficio: Clientes fieles reciben mayores descuentos

##  Tecnologías Utilizadas
- Java 8+ - Lenguaje principal
- Programación Orientada a Objetos - Herencia, polimorfismo, encapsulamiento
- Estructuras de datos Java - ArrayList, TreeMap, List
- Manejo de excepciones - InputMismatchException, NullPointerException
- Entrada/Salida por consola

### Prerrequisitos
- JDK 8 o superior
- IDE recomendado: IntelliJ IDEA, Eclipse o VS Code

### Pasos para ejecutar
1. Clonar/descargar el proyecto
2. Abrir en cualquier IDE Java
3, Ejecutar la clase principal: 
Main.java
4. Usar datos de prueba:
- Legajo: 12345
- Contraseña: juanperez123

##  Datos de Prueba Pre-cargados
-Clientes con Sistema de Puntos
* Iara Avila - DNI: 43695548 - Puntos: 1500 (Descuento: 10%)
* Facundo Jáuregui - DNI: 48132534 - Puntos: 500 (Descuento: 5%)
* Leandro Espindola - DNI: 41040327 - Puntos: 450 (Descuento: 0%)

-Productos
* Café - $2000.0 - Bebida
* Sandwich - $4000.0 - Comida
* Agua - $1000.0 - Bebida
* Medialuna - $1100.0 - Comida
* Especial Jáuregui - $5000.0 - Comida
* Iariña Triple - $6000.0 - Comida

-Empleados
* Juan Perez - DNI: 23.456.789 - Email: jp@gmail.com 
   Legajo: 12345 - Contraseña: juanperez123
* Maria Lopez - DNI: 45.756.789 - Email: mary@gmail.com 
   Legajo: 54321 - Contraseña: 123123
* Pedro Martinez - DNI: 43.756.789 - Email: pedritovm@gmail.com
   Legajo: 56789 - Contraseña: 123123
* Mateo Avila - DNI: 35.656.789 - Email: matheus@gmail.com 
   Legajo: 98765 - Contraseña: 123123
* Judas Gonzalez - DNI: 40.467.567 - Email: nosoytraidor@gmail.com 
   Legajo: 34521 - Contraseña: 123123

## Flujo de Uso con Descuentos
- Inicio de sesión con credenciales de empleado
- Menú principal (Cliente / Producto / Venta)
Proceso de venta:
- Selección de productos
- Verificación automática de puntos del cliente
- Aplicación de descuento correspondiente
- Cálculo de total final
- Confirmación de venta con descuento aplicado

## Estructuras de Datos Implementadas
- Colecciones Utilizadas
- ArrayList<Cliente> - Lista de clientes registrados
- ArrayList<Empleado> - Lista de empleados del sistema
- TreeMap<int, Producto> - Productos ordenados por ID
- ArrayList<Venta> - Historial de ventas realizadas
- Sistema de puntos- Atributo en Cliente con lógica de descuentos

## Ventajas de TreeMap para Productos
- Orden automático por ID
- Búsqueda rápida (O(log n))
- Garantía de IDs únicos
- Iteración ordenada natural

## Validaciones Implementadas
- Validaciones de Entrada
- DNI/ID: Solo valores numéricos positivos
- Nombres/Apellidos: Strings no vacíos
- Precios: Valores positivos
- Cantidades: Enteros mayores a 0
- Opciones de menú: Dentro de rangos válidos
- Validaciones de Negocio
- DNI único para clientes
- ID único para productos
- Existencia previa antes de operaciones
- Integridad referencial en ventas
- Validación de puntos para descuentos

## Características Destacadas
 Robustez
- Recuperación automática tras errores
- Validaciones exhaustivas de datos
- Mensajes de error claros y específicos

Usabilidad
- Menús jerárquicos intuitivos
- Navegación sencilla entre opciones
- Confirmaciones de operaciones exitosas

Mantenibilidad
- Código bien comentado y documentado
- Separación clara de responsabilidades
- Nombres descriptivos de variables y métodos

 Extensibilidad
- Arquitectura modular para nuevas funcionalidades
- Clases base sólidas para extensión
- Interfaces flexibles para adaptación

## Sistema de Fidelización
- Beneficios para Clientes
- Acumulación progresiva: Más compras = más puntos
- Descuentos escalonados: Mayor puntaje = mayor descuento
- Reconocimiento: Clientes frecuentes reciben mejores beneficios
- Beneficios para la Cafetería
- Retención de clientes: Incentivos para compras recurrentes
- Datos valiosos: Seguimiento de preferencias de clientes
- Ventas incrementales: Clientes incentivados a alcanzar nuevos niveles


## Autores:
Avila López, Iara Camila
Jáuregui, Facundo Manuel

## Licencia
Proyecto académico desarrollado para UTN FRRE - Curso Programación 2 - Comisión 1- Año 2025
