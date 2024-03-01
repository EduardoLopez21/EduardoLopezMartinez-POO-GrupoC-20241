package tarea6;

public class Tarea6 {

    public static void main(String[] args) {

        Producto producto1 = new Producto("Producto 1", 25.99, 50);
        Producto producto2 = new Producto("Producto 2", 15.49, 10);

        imprimirInformacionProducto(producto1);
        imprimirInformacionProducto(producto2);

        producto1.aumentarStock(10);
        producto2.reducirStock(5);

        imprimirInformacionProducto(producto1);
        imprimirInformacionProducto(producto2);
    }

    private static void imprimirInformacionProducto(Producto producto) {
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Precio: $" + producto.getPrecio());
        System.out.println("Stock: " + producto.getStock());
        System.out.println("----------------------");
    }
}
