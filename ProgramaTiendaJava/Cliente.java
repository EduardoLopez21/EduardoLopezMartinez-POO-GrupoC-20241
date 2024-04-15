import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nombre;
    private String direccion;
    private ArrayList<Compra> compras = new ArrayList<>();

    public Cliente(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCompra(Compra compra) {
        compras.add(compra);
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public String obtenerInformacion() {
        return String.format("Id: %d Nombre: %s y direccion: %s", id, nombre, direccion);
    }
}

