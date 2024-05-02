package libreria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Libros {
    private static int contadorIdLibros = 1; // Contador para generar automáticamente IDs únicos
    private int idLibros;
    private String titulo;
    private String autor;
    private String fechaDePublicacion;
    private static List<Libros> librosRegistrados = new ArrayList<>(); // Lista para almacenar libros registrados

    // Constructor
    public Libros(String titulo, String autor, String fechaDePublicacion) {
        this.idLibros = contadorIdLibros++; // Asignamos un ID único cada vez que se crea un libro
        this.titulo = titulo;
        this.autor = autor;
        this.fechaDePublicacion = fechaDePublicacion;
    }


    // Getters
    public int getIdLibros() {
        return idLibros;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public String getInfoLibro() {
        return String.format("ID: %d, Título: %s, Autor: %s, Fecha de Publicación: %s", idLibros, titulo, autor, fechaDePublicacion);
    }

    public static void registrarLibros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrando Libros");
        System.out.println("Ingresar los siguientes datos para continuar");

        System.out.print("Ingresa el Título del Libro: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingresa el Autor del Libro: ");
        String autor = scanner.nextLine();

        System.out.print("Ingresa la Fecha de Publicación del Libro: ");
        String fechaDePublicacion = scanner.nextLine();

        Libros libro = new Libros(titulo, autor, fechaDePublicacion);
        librosRegistrados.add(libro);
        System.out.println("\n¡Libro registrado exitosamente!\n");
    }

    // Método para mostrar libros
    public static void mostrarLibros() {
        System.out.println("\nLibros registrados en la Biblioteca:");
        for (Libros libro : librosRegistrados) {
            System.out.println(libro.getInfoLibro());
        }
    }
}



