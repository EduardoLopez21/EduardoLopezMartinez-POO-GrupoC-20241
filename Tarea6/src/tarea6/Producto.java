package tarea6;

public class Producto {

    private String Nombre;

    private double precio;

    private int stock;

    public Producto(String Nombre, double precio, int stock) {
        this.Nombre = Nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(String nombre, double precio) {
        this(nombre, precio, 0);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        if (Nombre != null) {
            this.Nombre = Nombre;
        } else {
            System.out.println("El nombre no puede ser nulo");
        }

    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("El precio no puede ser negativo");
        }

    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("El Stock no puede ser negativo");
        }

    }

    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            setStock(getStock() + cantidad);
        } else {
            System.out.println("La cantidad tiene que ser mayor a cero");
        }
    }

    public void reducirStock(int cantidad) {
        if (cantidad > 0 && cantidad <= getStock()) {
            setStock(getStock() - cantidad);
        } else {
            System.out.println("La cantidad tiene que ser mayor a cero");
        }
    }

}
