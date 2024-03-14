package Tarea8;

import java.util.ArrayList;
import java.util.List;

class usuarios {
    private int id;
    private String nombre;
    private int edad;
    private List<libros> librosRentados = new ArrayList<>();

    public usuarios(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public void agregarLibroRentado(libros libro) {
        librosRentados.add(libro);
    }

    public List<libros> getLibrosRentados() {
        return librosRentados;
    }

    @Override
    public String toString() {
        return "Usuario:" + "id:" + id + ", nombre:'" + nombre + '\'' + ", edad:" + edad;
    }
}
