package utils;

public class Trabajador{

    private String id;

    private String nombre;

    private String telefono;

    public Trabajador(String id, String nombre, String telefono) {
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