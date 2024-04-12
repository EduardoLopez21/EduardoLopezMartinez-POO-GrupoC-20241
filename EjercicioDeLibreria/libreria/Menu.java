package libreria;

import java.util.Scanner;

import Usuarios.Usuario;

public class Menu {

    private Libreria libreria = new Libreria();
    private Scanner scanner = new Scanner(System.in);

    public void inicioSesion() {
        boolean datosCorrectos = false;

        do {
            System.out.println("Bienvenido al sistema de la Biblioteca");
            System.out.println("Para continual inicia sesion");
            System.out.print("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Ingresa tu contraseña: ");
            String contraseña = scanner.nextLine();


            Usuario usuarioActual = libreria.verificarInicioSesion(usuario, contraseña);
            if (usuarioActual != null) {
                datosCorrectos = true;
                seleccionarMenu(usuarioActual);
            } else {
                System.out.println("Usuario o contraseña incorrectos, intenta de nuevo.");
            }

        } while (!datosCorrectos);

    }

    private void seleccionarMenu(Usuario usuario) {
        switch (usuario.getRol()) {
            case CLIENTE -> mostrarMenuCliente();
            case ASISTENTE -> mostrarMenuAsistente();
            case GERENTE -> mostrarMenuGerente();
        }

// Cliente - ver los libros, consultar sus rentas
//Asistente - CRUD (Create, Reed, Update, Delete)
//Gerente - CRUD completo del sistemea ademas de realizar rentas

    }

    private void mostrarMenuCliente() {
        int opcion;
        do {
            System.out.println("\n *** MENU DE CLIENTES ***\n");
            System.out.println("1.- Ver libros disponibles");
            System.out.println("2.- Consultar sus rentas");
            System.out.println("3.- Cerrar Sesion");
            System.out.print("\n Ingrese la opcion del Cliente: \n");
            System.out.println();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionaste Ver libros disponibles");

                    break;

                case 2:
                    System.out.println("Seleccionaste Consultar rentas");

                    break;

                case 3:
                    System.out.println("Cerrando sesion.....");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");


            }

        } while (opcion != 3);
    }

    private void mostrarMenuAsistente() {
        int opcion;
        do {
            System.out.println("\n *** MENU DE ASISTENTE ***\n");
            System.out.print("1.- Registrar clientes: ");
            System.out.print("2.- Registrar libro: ");
            System.out.print("3.- Mostrar clientes");
            System.out.print("4.- Mostrar libro:");
            System.out.print("5.- Modificar clientes: ");
            System.out.println("6.- Modificar libro:");
            System.out.println("7.- Eliminar clientes: ");
            System.out.println("8.- Eliminar libro:");
            System.out.println("9.- Cerrar Sesion ");
            System.out.print("\n Ingrese la opcion del Cliente: \n");
            System.out.println();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionaste Registrar Clientes");

                    break;

                case 2:
                    System.out.println("Seleccionaste Registrar Libros");

                    break;

                case 3:
                    System.out.println("Seleccionaste Mostrar Clientes");
                    break;
                case 4:
                    System.out.println("Seleccionaste Mostrar Libros");
                    break;

                case 5:
                    System.out.println("Seleccionaste Modificar Clientes");
                    break;

                case 6:
                    System.out.println("Seleccionaste Modificar Libros");
                    break;

                case 7:

                    System.out.println("Seleccionaste Eliminar Clientes");
                    break;

                case 8:
                    System.out.println("Seleccionaste Eliminar Libros");

                    break;
                case 9:
                    System.out.println("Cerrando Sesion......");
                    break;

                default:
                    System.out.println("Seleccion invalida, intenta con otro numero");
                    break;


            }

        } while (opcion != 10);
    }

    private void mostrarMenuGerente() {
        int opcion;

        do {
            System.out.println("\n *** MENU DE ASISTENTE ***\n");
            System.out.println("1. Registrar cliente.");
            System.out.println("2. Registrar asistente.");
            System.out.println("3. Registrar libro.");
            System.out.println("4. Modificar cliente.");
            System.out.println("5. Modificar asistente.");
            System.out.println("6. Modificar libro.");
            System.out.println("7. Elimimar cliente.");
            System.out.println("8. Eliminar asistente.");
            System.out.println("9. Eliminar libro.");
            System.out.println("10. Mostrar clientes.");
            System.out.println("11. Mostrar asistentes.");
            System.out.println("12. Mostrar libros.");
            System.out.println("13. Mostrar libros rentados.");
            System.out.println("14. Rentar libro.");
            System.out.println("15. Cerrar sesión");
            System.out.print("\n Ingrese la opcion del Cliente: \n");
            System.out.println();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionaste Registrar Cliente");

                    break;

                case 2:
                    System.out.println("Seleccionaste Registrar Asistente");

                    break;

                case 3:
                    System.out.println("Seleccionaste Registrar Libros");
                    break;

                case 4:
                    System.out.println("Seleccionaste modificar Cliente");

                    break;

                case 5:
                    System.out.println("Seleccionaste MOdificar Asistente");

                    break;

                case 6:
                    System.out.println("Seleccionaste Mofidicar Libros");
                    break;

                case 7:
                    System.out.println("Seleccionaste Eliminar Clientes");

                    break;

                case 8:
                    System.out.println("Seleccionaste Eliminar Asistente");

                    break;

                case 9:
                    System.out.println("Seleccionaste Eliminar Libros");
                    break;

                case 10:
                    System.out.println("Seleccionaste Mostrar Clientes");

                    break;

                case 11:
                    System.out.println("Seleccionaste Mostrar Asistentes");

                    break;

                case 12:
                    System.out.println("Seleccionaste Mostrar Libros");

                    break;

                case 13:
                    System.out.println("Seleccionaste Mostrar Libros Rentados");

                    break;

                case 14:
                    System.out.println("Seleccionaste Rentar Libro");

                    break;

                case 15:
                    System.out.println("Cerrando Sesion.....");
                    break;
                default:
                    System.out.println("Ingresar una opcion valida.....");
                    break;


            }

        } while (opcion != 15);


    }
}








