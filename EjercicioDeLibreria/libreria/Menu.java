package libreria;

import java.sql.SQLOutput;
import java.util.Scanner;

import Usuarios.Usuario;
import utils.UsuarioEnSesion;


/*
- Realizar el registro de cliente, registro de libros y consulta de clientes y libros
- Opcional: Tratar de almacenar el usuario en sesion (UsuarioEnSesion) y verificar el comportamiento
- Ahora tenemos que hacer todo con el HashMap y tambien ver que pedo con el login
 */

public class Menu {

    private Libreria libreria = new Libreria();
    private Scanner scanner = new Scanner(System.in);


    public void inicioSesion() {
        boolean datosCorrectos = false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Bienvenido al sistema de la Biblioteca\n");
            System.out.print("Para continuar, inicia sesion\n");
            System.out.print("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Ingresa tu contraseña: ");
            String contraseña = scanner.nextLine();


            Usuario usuarioActual = libreria.verificarInicioSesion(usuario, contraseña);
            if (usuarioActual != null) {
                datosCorrectos = true;
                UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                seleccionarMenu();
            } else {
                System.out.println("\n Usuario o contraseña incorrectos, intenta de nuevo.\n");
            }

        } while (!datosCorrectos);

    }

    private void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
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
        int opcion = 0;
        do {
            System.out.println("\n *** MENU DE CLIENTES ***\n");
            System.out.println("1.- Ver libros disponibles");
            System.out.println("2.- Consultar sus rentas");
            System.out.println("3.- Mostrar mis datos");
            System.out.println("4.- Editar mi informacion");
            System.out.println("5.- Cerrar Sesion");
            System.out.print("\n Ingrese la opcion del Cliente: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionaste Ver libros disponibles");

                    break;

                case 2:
                    System.out.println("Seleccionaste Consultar rentas");

                    break;

                case 3:
                    System.out.println("Seleccionaste Mostrar mis datos");
                    break;

                case 4:
                    System.out.println("Seleccionaste Editar Informacion");
                    break;

                case 5:
                    System.out.println("Cerrando sesion.....");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    inicioSesion();
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
            System.out.println("1.- Registrar clientes: ");
            System.out.println("2.- Registrar libro: ");
            System.out.println("3.- Mostrar clientes: ");
            System.out.println("4.- Mostrar libro: ");
            System.out.println("5.- Modificar clientes: ");
            System.out.println("6.- Modificar libro: ");
            System.out.println("7.- Eliminar clientes: ");
            System.out.println("8.- Eliminar libro: ");
            System.out.println("9.- Cerrar Sesion: ");
            System.out.print("\n Ingrese la opcion del Asistente: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionaste Registrar Clientes");
                    libreria.registrarClientes();

                    break;

                case 2:
                    System.out.println("Seleccionaste Registrar Libros");
                    libreria.registrarLibros();
                    break;

                case 3:
                    System.out.println("Seleccionaste Mostrar Clientes");
                    libreria.mostrarClientes();
                    break;
                case 4:
                    System.out.println("Seleccionaste Mostrar Libros");
                    libreria.mostrarLibros();
                    break;

                case 5:
                    System.out.println("Seleccionaste Modificar Clientes");
                    break;

                case 6:
                    System.out.println("Seleccionaste Modificar Libros");
                    break;

                case 7:
                    System.out.println("Seleccionaste Eliminar Clientes");
                    scanner.nextLine();
                    System.out.print("Ingresa el ID del Cliente a eliminar: ");
                    int idCliente = scanner.nextInt();
                    System.out.println("\n Eliminando Cliente...");
                    libreria.EliminarCliente(idCliente);
                    break;

                case 8:
                    System.out.println("Seleccionaste Eliminar Libros");

                    break;
                case 9:
                    System.out.println("Cerrando Sesion......");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    inicioSesion();
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
            System.out.println("\n *** MENU DE GERENTE ***\n");
            System.out.println("1. Registrar cliente.");
            System.out.println("2. Registrar asistente.");
            System.out.println("3.- Registrar Gerente");
            System.out.println("4. Registrar libro.");
            System.out.println("5. Modificar cliente.");
            System.out.println("6. Modificar asistente.");
            System.out.println("7. Modificar Gerente.");
            System.out.println("8. Modificar libro.");
            System.out.println("9. Elimimar cliente.");
            System.out.println("10. Eliminar asistente.");
            System.out.println("11. Eliminar Gerente.");
            System.out.println("12. Eliminar libro.");
            System.out.println("13. Mostrar clientes.");
            System.out.println("14. Mostrar asistentes.");
            System.out.println("15. Mostrar Gerentes.");
            System.out.println("16. Mostrar libros.");
            System.out.println("17. Mostrar libros rentados.");
            System.out.println("18. Rentar libro.");
            System.out.println("19. Cerrar sesión");
            System.out.print("\n Ingrese la opcion del Gerente: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionaste Registrar Cliente");
                    libreria.registrarClientes();
                    break;

                case 2:
                    System.out.println("Seleccionaste Registrar Asistente");
                    libreria.registrarAsistentes();
                    break;

                case 3:
                    System.out.println("Seleccionaste Registrar Gerente");
                    libreria.registrarGerente();
                    break;

                case 4:
                    System.out.println("Seleccionaste Registrar Libros");
                    libreria.registrarLibros();
                    break;

                case 5:
                    System.out.println("Seleccionaste modificar Cliente");
                    break;

                case 6:
                    System.out.println("Seleccionaste Modificar Asistente");
                    break;

                case 7:
                    System.out.println("Seleccionaste Modificar Gerente");
                    break;

                case 8:
                    System.out.println("Seleccionaste Mofidicar Libros");
                    break;

                case 9:
                    System.out.println("Seleccionaste Eliminar Clientes");
                    scanner.nextLine();
                    System.out.print("Ingresa el ID del Cliente a eliminar: ");
                    int idCliente = scanner.nextInt();
                    System.out.println("\n Eliminando Cliente...");
                    libreria.EliminarCliente(idCliente);
                    break;

                case 10:
                    System.out.println("Seleccionaste Eliminar Asistente");
                    scanner.nextLine();
                    System.out.print("Ingresa el ID del Cliente a eliminar: ");
                    int idAsistente = scanner.nextInt();
                    System.out.println("\n Eliminando Cliente...");
                    libreria.EliminarAsistente(idAsistente);
                    break;

                case 11:
                    System.out.println("Seleccionaste Eliminar Asistente");
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Ingresa el ID del gerente que deseas eliminar: ");
                    int idGerente = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.print("Ingresa el nombre de usuario del usuario que desea eliminar al gerente: ");
                    String nombreUsuarioEliminarGerente = scanner.nextLine();
                    libreria.EliminarGerente(idGerente, nombreUsuarioEliminarGerente);

                    break;

                case 12:
                    System.out.println("Seleccionaste Eliminar Libros");
                    break;

                case 13:
                    System.out.println("Seleccionaste Mostrar Clientes");
                    libreria.mostrarClientes();
                    break;

                case 14:
                    System.out.println("Seleccionaste Mostrar Asistentes");
                    libreria.mostrarAsistentes();
                    break;

                case 15:
                    System.out.println("Seleccionaste Mostrar Gerente");
                    libreria.mostrarGerente();
                    break;

                case 16:
                    System.out.println("Seleccionaste Mostrar Libros");
                    libreria.mostrarLibros();
                    break;

                case 17:
                    System.out.println("Seleccionaste Mostrar Libros Rentados");
                    break;

                case 18:
                    System.out.println("Seleccionaste Rentar Libro");
                    break;

                case 19:
                    System.out.println("Cerrando Sesion.....");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    inicioSesion();
                    break;

                default:
                    System.out.println("\n Ingresar una opcion valida.....");
                    break;


            }

        } while (opcion != 19);


    }
}








