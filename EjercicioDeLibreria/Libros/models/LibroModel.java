package Libros.models;
import Libros.Libro;

import java.util.ArrayList;

public class LibroModel {
    private ArrayList<Libro> accion;
    private ArrayList<Libro> drama;
    private ArrayList<Libro> comedia;

    public ArrayList<Libro> getAccion() {
        return accion;
    }

    public ArrayList<Libro> getDrama() {
        return drama;
    }

    public ArrayList<Libro> getComedia() {
        return comedia;
    }
}

