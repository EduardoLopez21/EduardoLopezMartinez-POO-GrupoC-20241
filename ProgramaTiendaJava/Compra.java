import java.util.ArrayList;

public class Compra {
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private String fechaCompra;
    private String Producto;
    private int cantidad;
    private double total;

    // Constructor que incluye el cliente y los productos
    public Compra(Cliente cliente, ArrayList<Producto> productos, int cantidad, double total) {
        this.cliente = cliente;
        this.productos = productos;
        this.fechaCompra = java.time.LocalDate.now().toString();
        this.cantidad = cantidad;
        this.total = total;
    }

    // Métodos getter para el cliente y los productos
    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }

    public String getProducto() {
        return Producto;
    }



    // Método para agregar un producto a la lista de productos de la compra
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public String obtenerInformacion() {
        StringBuilder info = new StringBuilder();
        info.append("Cliente: ").append(cliente.getId()).append(", Productos:");
        for (Producto producto : productos) {
            info.append(" ").append(producto.getNombre());
        }
        info.append(", Fecha de compra: ").append(fechaCompra);
        return info.toString();
    }
}


