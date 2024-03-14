package Tarea8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tarea8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        libreria libreria = new libreria();

        while (true) {
            System.out.println("*** BIENVENIDO AL GESTOR DE LIBRERIA ***");
            System.out.println("Menú:");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Registrar libro");
            System.out.println("3. Rentar libro");
            System.out.println("4. Listar usuarios");
            System.out.println("5. Listar libros");
            System.out.println("6. Listar usuarios con libros");
            System.out.println("7. Listar libros no rentados");
            System.out.println("8. Listar libros rentados");
            System.out.println("9. Salir del programa");

            System.out.print("INGRESA UNA OPCION: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del usuario:");
                    String nombreUsuario = scanner.nextLine();
                    System.out.println("Ingrese la edad del usuario:");
                    int edadUsuario = scanner.nextInt();
                    usuarios usuario = new usuarios(libreria.usuarios.size() + 1, nombreUsuario, edadUsuario);
                    libreria.registrarUsuario(usuario);
                    break;
                case 2:
                    System.out.println("Ingrese el título del libro:");
                    String tituloLibro = scanner.nextLine();
                    System.out.println("Ingrese el autor del libro:");
                    String autorLibro = scanner.nextLine();
                    libros libro = new libros(libreria.libros.size() + 1, tituloLibro, autorLibro);
                    libreria.registrarLibro(libro);
                    break;
                case 3:
                    System.out.println("Ingrese el id del usuario:");
                    int idUsuario = scanner.nextInt();
                    System.out.println("Ingrese el id del libro:");
                    int idLibro = scanner.nextInt();
                    libreria.rentarLibro(libreria.usuarios.get(idUsuario - 1), libreria.libros.get(idLibro - 1));
                    break;
                case 4:
                    libreria.listarUsuarios();
                    break;
                case 5:
                    libreria.listarLibros();
                    break;
                case 6:
                    libreria.listarUsuariosConLibros();
                    break;
                case 7:
                    libreria.listarLibrosNoRentados();
                    break;
                case 8:
                    libreria.listarLibrosRentados();
                    break;
                case 9:
                    System.out.println("Saliendo del programa, Bye bye :D");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}