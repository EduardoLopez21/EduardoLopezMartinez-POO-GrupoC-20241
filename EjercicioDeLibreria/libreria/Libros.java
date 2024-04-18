package libreria;

public class Libros {
    private static int contadorIdLibros = 1; // Contador para generar automáticamente IDs únicos
    private int idLibros;
    private String titulo;
    private String autor;
    private String fechaDePublicacion;

    
    public Libros(String titulo, String autor, String fechaDePublicacion) {
        this.idLibros = contadorIdLibros++; 
        this.titulo = titulo;
        this.autor = autor;
        this.fechaDePublicacion = fechaDePublicacion;
    }


   
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
}


