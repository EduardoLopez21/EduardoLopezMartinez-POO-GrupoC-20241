package Tarea8;

import java.util.ArrayList;
import java.util.List;

class libreria {
    List<usuarios> usuarios = new ArrayList<>();
    List<libros> libros = new ArrayList<>();

    public void registrarUsuario(usuarios usuario) {
        usuarios.add(usuario);
    }

    public void registrarLibro(libros libro) {
        libros.add(libro);
    }

    public void rentarLibro(usuarios usuario, libros libro) {
        if (!libro.EsRentado()) {
            libro.setEsRentado(true);
            usuario.agregarLibroRentado(libro);
        } else {
            System.out.println("El libro ya está rentado.");
        }
    }

    public void listarUsuarios() {
        for (usuarios usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void listarLibros() {
        for (libros libro : libros) {
            System.out.println(libro);
        }
    }

    public void listarUsuariosConLibros() {
        for (usuarios usuario : usuarios) {
            if (!usuario.getLibrosRentados().isEmpty()) {
                System.out.println(usuario);
            }
        }
    }

    public void listarLibrosNoRentados() {
        for (libros libro : libros) {
            if (!libro.EsRentado()) {
                System.out.println(libro);
            }
        }
    }

    public void listarLibrosRentados() {
        for (libros libro : libros) {
            if (libro.EsRentado()) {
                System.out.println(libro);
            }
        }
    }
}

