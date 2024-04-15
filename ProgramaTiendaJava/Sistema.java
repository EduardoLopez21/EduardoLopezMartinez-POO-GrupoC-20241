
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sistema {
    private final String CONTRASEÑA = "H1/m";
    private Scanner scanner = new Scanner(System.in);
    private Tienda tienda = new Tienda();
    Map<Integer, Map<Integer, Producto>> inventario = inicializarInventario();
    private Map<Integer, Map<Integer, Producto>> inicializarInventario() {
        Map<Integer, Map<Integer, Producto>> inventario = new HashMap<>();

        return inventario;
    }

    Map<Integer, Map<Integer, Integer>> compras = new HashMap<>();
    int clienteID = 0;

    public void ejecutarPrograma() {
        boolean contraseñaValida = false;

        do {

            System.out.println("*** BIENVENIDO ***");
            System.out.print("INGRESA LA CONTRASEÑA PARA PODER ACCEDER AL SISTEMA: ");

            String contraseña = scanner.nextLine();

            if (validarContraseña(contraseña)) {
                contraseñaValida = true;
                mostrarMenuSistema();
            } else {
                System.out.println("Contraseña invalida intenta de nuevo.\n");
            }
        } while (!contraseñaValida);
    }

    private boolean validarContraseña(String contraseña) {
        return contraseña.equals(CONTRASEÑA);

    }

    private void mostrarMenuSistema() {

        int opcion = 0;

        do {

            System.out.println("\n ELIGE UNA OPCION PARA CONTINUAR\n ");
            System.out.println("*** BIENVENIDOS ***");
            System.out.println("1.- Agregar cliente"); // YA QUEDO
            System.out.println("2.- Agregar producto"); // YA QUEDO
            System.out.println("3.- Añadir a stock"); // YA QUEDO
            System.out.println("4.- Disminuir stock"); // YA QUEDO
            System.out.println("5.- Listar clientes"); // YA QUEDO
            System.out.println("6.- Listar productos"); // YA QUEDO
            System.out.println("7.- Consultar productos por categoria"); // YA QUEDO
            System.out.println("8.- Realizar compras"); // YA QUEDO
            System.out.println("9.- Consultar compras"); // YA QUEDO
            System.out.println("10.- Consultar total de productos y clientes"); // YA QUEDO
            System.out.println("11.- Eliminar producto"); // YA QUEDO
            System.out.println("12.- Eliminar cliente"); // YA QUEDO
            System.out.println("13.- Salir"); // YA QUEDO

            System.out.print("Ingresa la opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("*** HAZ SELECCIONADO LA OPCION DE AGREGAR CLIENTES \n");
                    tienda.registrarCliente();

                    break;
                case 2:
                    System.out.println("*** HAZ SELECCIONADO LA OPCION DE AGREGAR PRODUCTO \n");
                    System.out.println("Ingresa el tipo de producto que deseas agregar: ");
                    System.out.println("1.- Limpieza");
                    System.out.println("2.- Electrodomesticos");
                    System.out.println("3.- Alimento");
                    System.out.println("4.- Maquillaje");
                    System.out.print("Ingresar opcion: ");
                    int opcionProducto = scanner.nextInt();

                    switch (opcionProducto) {
                        case 1:
                            tienda.registrarProductoLimpieza();

                            break;
                        case 2:
                            tienda.registrarProductoElectrodomestico();
                            break;

                        case 3:
                            tienda.registrarProductoAlimento();
                            break;

                        case 4:
                            tienda.registrarProductoMaquillaje();
                            break;

                        default:
                            break;
                    }

                    break;

                case 3:
                    System.out.println("*** HAZ SELECCIONADO LA OPCION DE AGREGAR STOCK \n");
                    System.out.println("Ingresa el tipo de producto al que deseas agregarle más stock: ");
                    System.out.println("1.- Limpieza");
                    System.out.println("2.- Electrodomesticos");
                    System.out.println("3.- Alimento");
                    System.out.println("4.- Maquillaje");
                    System.out.print("Ingresar opción: ");
                    opcionProducto = scanner.nextInt();

                    switch (opcionProducto) {
                        case 1:
                            System.out.println("***Seleccionaste agregarle más stock a Limpieza***");
                            tienda.agregarStockLimpieza();
                            break;
                        case 2:
                            System.out.println("***Seleccionaste agregarle más stock a Electrodomestico***");
                            tienda.agregarStockElectrodomestico();
                            break;
                        case 3:
                            System.out.println("***Seleccionaste agregarle más stock a Alimento***");
                            tienda.agregarStockAlimento();
                            break;
                        case 4:
                            System.out.println("***Seleccionaste agregarle más stock a Maquillaje***");
                            tienda.agregarStockMaquillaje();
                            break;
                        default:
                            System.out.println("Selecciona una opción válida :D");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("*** HAZ SELECCIONADO LA OPCION DE DISMINUIR STOCK \n");
                    System.out.println("Ingresa el tipo de producto al que deseas quitarle más stock: ");
                    System.out.println("1.- Limpieza");
                    System.out.println("2.- Electrodomesticos");
                    System.out.println("3.- Alimento");
                    System.out.println("4.- Maquillaje");
                    System.out.print("Ingresar opción: ");
                    opcionProducto = scanner.nextInt();

                    switch (opcionProducto) {
                        case 1:
                            System.out.println("***Seleccionaste disminuir más stock a Limpieza***");
                            tienda.disminuirStockLimpieza();
                            break;
                        case 2:
                            System.out.println("***Seleccionaste disminuir más stock a Electrodomestico***");
                            tienda.disminuirStockElectrodomestico();
                            break;
                        case 3:
                            System.out.println("***Seleccionaste disminuir más stock a Alimento***");
                            tienda.disminuirStockAlimento();
                            break;
                        case 4:
                            System.out.println("***Seleccionaste disminuir más stock a Maquillaje***");
                            tienda.disminuirStockMaquillaje();
                            break;
                        default:
                            System.out.println("Selecciona una opción válida :D");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("*** HAZ SELECCIONADO LA OPCION DE CONSULTAR CLIENTES\n");
                    tienda.consultarClientes();
                    break;
                case 6:
                    System.out.println("*** HAZ SELECCIONADO LA OPCION DE CONSULTAR PRODUCTOS \n");
                    System.out.println("***PRODUCTOS DE LIMPIEZA***");
                    if (tienda.getProductosLimpieza().isEmpty()) {
                        System.out.println("No hay productos de limpieza registrados.");
                    } else {
                        tienda.consultarProductosLimpieza();
                    }

                    System.out.println("***PRODUCTOS DE ELECTRODOMESTICOS***");
                    if (tienda.getProductosElectrodomestico().isEmpty()) {
                        System.out.println("No hay productos de electrodomésticos registrados.");
                    } else {
                        tienda.consultarProductosElectrodomestico();
                    }

                    System.out.println("***PRODCUTOS DE ALIMENTOS***");
                    if (tienda.getProductosAlimento().isEmpty()) {
                        System.out.println("No hay productos de alimentos registrados.");
                    } else {
                        tienda.consultarProductosAlimento();
                    }

                    System.out.println("***PRODCUTOS DE MAQUILLAJE***");
                    if (tienda.getProductosMaquillaje().isEmpty()) {
                        System.out.println("No hay productos de maquillaje registrados.");
                    } else {
                        tienda.consultarProductosMaquillaje();
                    }
                    break;

                case 7:
                    System.out.println("*** HAZ SELECCIONADO LA OPCION DE CONSULTAR PRODUCTOS \n");
                    System.out.println("Ingresa el tipo de producto que deseas consultar");
                    System.out.println("1.- Limpieza");
                    System.out.println("2.- Electrodomesticos ");
                    System.out.println("3.- Alimento ");
                    System.out.println("4.- Maquillaje");

                    int opcionProductoConsulta = scanner.nextInt();

                    switch (opcionProductoConsulta) {
                        case 1:
                            tienda.consultarProductosLimpieza();
                            break;
                        case 2:
                            tienda.consultarProductosElectrodomestico();
                            break;
                        case 3:
                            tienda.consultarProductosAlimento();
                            break;
                        case 4:
                            tienda.consultarProductosMaquillaje();
                            break;

                    }

                    break;

                case 8:
                    tienda.realizarCompra();
                    break;

                case 9:
                    tienda.mostrarComprasRegistradas();

                    break;

                case 10:
                    System.out.println("***CLIENTES***");
                    tienda.consultarClientes();

                    System.out.println("***PRODUCTOS***");

                    System.out.println("***PRODUCTOS DE LIMPIEZA***");
                    if (tienda.getProductosLimpieza().isEmpty()) {
                        System.out.println("No hay productos de limpieza registrados.");
                    } else {
                        tienda.consultarProductosLimpieza();
                    }

                    System.out.println("***PRODUCTOS DE ELECTRODOMESTICOS***");
                    if (tienda.getProductosElectrodomestico().isEmpty()) {
                        System.out.println("No hay productos de electrodomésticos registrados.");
                    } else {
                        tienda.consultarProductosElectrodomestico();
                    }

                    System.out.println("***PRODCUTOS DE ALIMENTOS***");
                    if (tienda.getProductosAlimento().isEmpty()) {
                        System.out.println("No hay productos de alimentos registrados.");
                    } else {
                        tienda.consultarProductosAlimento();
                    }

                    System.out.println("***PRODCUTOS DE MAQUILLAJE***");
                    if (tienda.getProductosMaquillaje().isEmpty()) {
                        System.out.println("No hay productos de maquillaje registrados.");
                    } else {
                        tienda.consultarProductosMaquillaje();
                    }

                    break;

                case 11:
                    System.out.println("*** HAZ SELECCIONADO LA OPCION DE ELIMINAR PRODUCTO \n");
                    tienda.eliminarProducto();
                    break;

                case 12:
                    System.out.println("*** HAZ SELECCIONADO LA OPCION DE ELIMINAR CLIENTE \n");
                    scanner.nextLine();
                    System.out.print("Ingrese el ID del cliente a eliminar: ");
                    int idClienteEliminar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    tienda.eliminarCliente(idClienteEliminar);
                    break;

                case 13:
                    System.out.println("Saliendo del programa....");

                    break;

                default:
                    System.out.println("Ingresa una opcion valida por favor :D\n");
                    break;

            }

        } while (opcion != 13);

    }
}
