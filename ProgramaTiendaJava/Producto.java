public class Producto {
    public static int CANTIDAD_PRODUCTOS = 0;

    private int id;
    private String nombre;
    private double precio;
    private String fechaImportacion;
    private int numeroSerie;
    private int stock;

    public Producto(String nombre, double precio, String fechaImportacion, int stock) {
        this.id = ++CANTIDAD_PRODUCTOS;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaImportacion = fechaImportacion;
        this.stock = stock;
        this.numeroSerie = CANTIDAD_PRODUCTOS;
    }

    public void agregarStock(int cantidad) {
        stock += cantidad;

    }

    public void eliminarStock(int cantidad) {
        if (validadStock()) {
            System.out.println("");
        } else {
            stock -= cantidad;
        }
    }

    private boolean validadStock() {
        return stock == 0 ? true : false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public void disminuirStock() {
        if (stock > 0) {
            stock--;
        }
    }
    public double getPrecio() {
        return precio;
    }

    public void disminuirStock(int cantidad) {
        this.stock -= cantidad;
    }


    public String obtenerInformacion(){
        System.out.println("Producto registrado con ID: " + getId());
        return String.format("ID: %d, Nombre: %s, precio: %f, fecha importacion: %s, stock: %d, numero de serie:  %d", id, nombre, precio, fechaImportacion, stock, numeroSerie);
    }



}
