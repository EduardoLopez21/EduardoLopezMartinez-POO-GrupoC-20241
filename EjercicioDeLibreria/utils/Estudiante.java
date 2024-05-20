package utils;

public class Estudiante {

    private String id;

    private String nombre;

    private String telefono;

    public Estudiante(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }
}
