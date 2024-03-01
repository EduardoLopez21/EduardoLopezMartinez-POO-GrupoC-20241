package tarea6;

public class Tarea6 {

    public static void main(String[] args) {
// Crear instancias de Producto
        Producto producto1 = new Producto("Producto 1", 25.99, 50);
        Producto producto2 = new Producto("Producto 2", 15.49, 10);

        // Imprimir información de los productos
        imprimirInformacionProducto(producto1);
        imprimirInformacionProducto(producto2);

        // Modificar atributos de los productos
        producto1.aumentarStock(10);
        producto2.reducirStock(5);

        // Imprimir información actualizada
        imprimirInformacionProducto(producto1);
        imprimirInformacionProducto(producto2);
    }

    // Método para imprimir información de un producto
    private static void imprimirInformacionProducto(Producto producto) {
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Precio: $" + producto.getPrecio());
        System.out.println("Stock: " + producto.getStock());
        System.out.println("----------------------");
    }
}
