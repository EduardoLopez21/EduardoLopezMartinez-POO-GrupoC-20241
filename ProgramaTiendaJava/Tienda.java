import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tienda {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Maquillaje> productosMaquillaje = new ArrayList<Maquillaje>();
    private ArrayList<Limpieza> productosLimpieza = new ArrayList<Limpieza>();
    private ArrayList<Alimento> productosAlimento = new ArrayList<Alimento>();
    private ArrayList<Electrodomestico> productosElectrodomestico = new ArrayList<Electrodomestico>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Compra> compras = new ArrayList<>();


    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private Scanner leer = new Scanner(System.in);

    public void registrarCliente() {
        int id = validarIdCliente();
        System.out.print("Ingresa el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa la direccion: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(id, nombre, direccion);
        clientes.add(cliente);

        System.out.println("¡Cliente registrado con exito!");
    }

    public void consultarClientes() {
        System.out.println("¨*** CLIENTES ***");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.obtenerInformacion());
        }
    }

    public int validarIdCliente() {
        boolean idValido = true;
        int id = random.nextInt(1000) + 1;

        do {
            for (Cliente cliente : clientes) {
                if (id == cliente.getId()) {
                    idValido = false;
                    id = random.nextInt(1000) + 1;
                }
            }

        } while (!idValido);

        return id;
    }

    public ArrayList<String> registrarDatosComun() {
        ArrayList<String> datos = new ArrayList<String>();
        System.out.print("Ingresa un nombre: ");
        String nombre = scanner.nextLine();
        datos.add(nombre);

        System.out.print("Ingresa el precio: ");
        double precio = scanner.nextDouble();
        datos.add(String.valueOf(precio));

        scanner.nextLine();
        System.out.print("Ingresa la fecha de importacion: ");
        String fecha = scanner.nextLine();
        datos.add(fecha);

        System.out.print("Ingresa el stock del producto: ");
        int Stock = scanner.nextInt();
        datos.add(String.valueOf(Stock));

        return datos;
    }

    public void registrarProductoLimpieza() {
        System.out.println("\n *** Elegiste registrar un producto de la categoria limpieza ***");

        // [Donas], 5.10, 9 de marzo, 10
        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));

        scanner.nextLine();
        System.out.print("Ingresa la marca: ");
        String marca = scanner.nextLine();

        Limpieza limpieza = new Limpieza(nombre, precio, fecha, stock, marca);

        productosLimpieza.add(limpieza);

    }

    public void consultarProductosLimpieza() {
        System.out.println("*** PRODUCTOS LIMPIEZA***");
        for (Limpieza producto : productosLimpieza) {
            System.out.println(producto.obtenerInformacionConMarca());
        }
    }

    public void registrarProductoMaquillaje() {
        System.out.println("\n *** Elegiste registrar un producto de la categoria Maquillaje ***");

        // [Labial, 12.05, 9 de marzo, 20]
        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));

        scanner.nextLine();
        System.out.print("Ingresar el color: ");
        String color = scanner.nextLine();

        Maquillaje maquillaje = new Maquillaje(nombre, precio, fecha, stock, color);

        productosMaquillaje.add(maquillaje);

    }

    public void consultarProductosMaquillaje() {
        System.out.println("*** PRODUCTOS MAQUILLAJE***");
        for (Maquillaje producto : productosMaquillaje) {
            System.out.println(producto.obtenerInformacionConColor());
        }
    }

    public void registrarProductoElectrodomestico() {
        System.out.println("\n *** Elegiste registrar un producto de la categoria Electrodomestico ***");

        // [Laptop, 11,500, 9 de marzo, 12]
        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));

        scanner.nextLine();
        System.out.print("Ingresar el voltaje: ");
        String voltaje = scanner.nextLine();

        Electrodomestico electrodomestico = new Electrodomestico(nombre, precio, fecha, stock, voltaje);

        productosElectrodomestico.add(electrodomestico);

        System.out.println("\n PRODUCTO REGISTRADO CON EXITO \n");

    }

    public void consultarProductosElectrodomestico() {
        System.out.println("*** PRODUCTOS ELECTRODOMESTICOS***");
        for (Electrodomestico producto : productosElectrodomestico) {
            System.out.println(producto.obtenerInformacionConVoltaje());
        }
    }

    public void registrarProductoAlimento() {
        System.out.println("\n *** Elegiste registrar un producto de la categoria Alimentos ***");

        // [Manzana, 12, 9 de marzo, 12]
        ArrayList<String> datosUsuario = registrarDatosComun();
        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));
        String fecha = datosUsuario.get(2);
        int stock = Integer.parseInt(datosUsuario.get(3));

        scanner.nextLine();
        System.out.print("Ingresar la caducidad: ");
        String caducidad = scanner.nextLine();

        Alimento alimento = new Alimento(nombre, precio, fecha, stock, caducidad);

        productosAlimento.add(alimento);

        System.out.println("\n PRODUCTO REGISTRADO CON EXITO \n");

    }

    public void consultarProductosAlimento() {
        System.out.println("*** PRODUCTOS ELECTRODOMESTICOS***");
        for (Alimento producto : productosAlimento) {
            System.out.println(producto.obtenerInformacionConCaducidad());
        }
    }


    public void eliminarCliente(int idCliente) {
        Cliente cliente = buscarClientePorId(idCliente);
        if (cliente != null) {
            // Verificar si el cliente tiene compras asociadas
            if (!clienteTieneComprasAsociadas(cliente)) {
                clientes.remove(cliente);
                System.out.println("Cliente eliminado exitosamente.");
            } else {
                System.out.println("No se puede eliminar el cliente porque tiene compras asociadas.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void eliminarProducto() {
        System.out.println("Selecciona la categoría del producto que deseas eliminar:");
        System.out.println("1. Limpieza");
        System.out.println("2. Electrodomésticos");
        System.out.println("3. Alimentos");
        System.out.println("4. Maquillaje");
        int opcionCategoria = scanner.nextInt();

        scanner.nextLine(); // Limpiar el buffer del scanner

        switch (opcionCategoria) {
            case 1:
                eliminarProductoLimpieza();
                break;
            case 2:
                eliminarProductoElectrodomestico();
                break;
            case 3:
                eliminarProductoAlimento();
                break;
            case 4:
                eliminarProductoMaquillaje();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void eliminarProductoLimpieza() {
        System.out.print("Ingrese el ID del producto de limpieza a eliminar: ");
        int idProducto = scanner.nextInt();
        eliminarProductoPorCategoria(productosLimpieza, idProducto);
    }

    private void eliminarProductoElectrodomestico() {
        System.out.print("Ingrese el ID del producto electrodoméstico a eliminar: ");
        int idProducto = scanner.nextInt();
        eliminarProductoPorCategoria(productosElectrodomestico, idProducto);
    }

    private void eliminarProductoAlimento() {
        System.out.print("Ingrese el ID del producto de alimento a eliminar: ");
        int idProducto = scanner.nextInt();
        eliminarProductoPorCategoria(productosAlimento, idProducto);
    }

    private void eliminarProductoMaquillaje() {
        System.out.print("Ingrese el ID del producto de maquillaje a eliminar: ");
        int idProducto = scanner.nextInt();
        eliminarProductoPorCategoria(productosMaquillaje, idProducto);
    }

    private void eliminarProductoPorCategoria(ArrayList<? extends Producto> listaProductos, int idProducto) {
        boolean encontrado = false;
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = listaProductos.get(i);
            if (producto.getId() == idProducto) {
                // Verificar si el producto tiene compras asociadas
                if (!productoTieneComprasAsociadas(producto)) {
                    listaProductos.remove(i);
                    System.out.println("Producto eliminado exitosamente.");
                    encontrado = true;
                    break; // Salir del bucle una vez que se elimina el producto
                } else {
                    System.out.println("No se puede eliminar el producto porque tiene compras asociadas.");
                    encontrado = true;
                    break; // Salir del bucle si se encuentra el producto pero no se puede eliminar
                }
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }


    private boolean clienteTieneComprasAsociadas(Cliente cliente) {
        for (Compra compra : compras) {
            if (compra.getCliente().getId() == cliente.getId()) {
                return true;
            }
        }
        return false;
    }

    private boolean productoTieneComprasAsociadas(Producto producto) {
        for (Compra compra : compras) {
            for (Producto p : compra.getProductos()) {
                if (p.getNombre().equalsIgnoreCase(producto.getNombre())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Cliente buscarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public ArrayList<Limpieza> getProductosLimpieza() {
        return productosLimpieza;
    }

    public ArrayList<Electrodomestico> getProductosElectrodomestico() {
        return productosElectrodomestico;
    }

    public ArrayList<Alimento> getProductosAlimento() {
        return productosAlimento;
    }

    public ArrayList<Maquillaje> getProductosMaquillaje() {
        return productosMaquillaje;
    }


    // AGREGAR MAS STOCK


    public void agregarStockLimpieza() {
        System.out.print("Ingrese el ID del producto de limpieza al que desea agregar más stock: ");
        int idProducto = scanner.nextInt();
        Producto producto = buscarProductoPorId(productosLimpieza, idProducto);
        if (producto != null) {
            System.out.print("Ingrese la cantidad de stock a agregar: ");
            int cantidad = scanner.nextInt();
            producto.agregarStock(cantidad);
            System.out.println("Stock agregado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }


    public Producto buscarProductoPorId(ArrayList<? extends Producto> listaProductos, int idProducto) {
        for (Producto producto : listaProductos) {
            if (producto.getId() == idProducto) {
                return producto;
            }
        }
        return null;
    }


    public void agregarStockElectrodomestico() {
        System.out.print("Ingrese el ID del producto electrodoméstico al que desea agregar más stock: ");
        int idProducto = scanner.nextInt();
        Producto producto = buscarProductoPorId(productosElectrodomestico, idProducto);
        if (producto != null) {
            System.out.print("Ingrese la cantidad de stock a agregar: ");
            int cantidad = scanner.nextInt();
            producto.agregarStock(cantidad);
            System.out.println("Stock agregado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void agregarStockAlimento() {
        System.out.print("Ingrese el ID del producto de alimento al que desea agregar más stock: ");
        int idProducto = scanner.nextInt();
        Producto producto = buscarProductoPorId(productosAlimento, idProducto);
        if (producto != null) {
            System.out.print("Ingrese la cantidad de stock a agregar: ");
            int cantidad = scanner.nextInt();
            producto.agregarStock(cantidad);
            System.out.println("Stock agregado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void agregarStockMaquillaje() {
        System.out.print("Ingrese el ID del producto de maquillaje al que desea agregar más stock: ");
        int idProducto = scanner.nextInt();
        Producto producto = buscarProductoPorId(productosMaquillaje, idProducto);
        if (producto != null) {
            System.out.print("Ingrese la cantidad de stock a agregar: ");
            int cantidad = scanner.nextInt();
            producto.agregarStock(cantidad);
            System.out.println("Stock agregado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }


    // DISMINUIR STOCK


    public void disminuirStockLimpieza() {
        System.out.print("Ingrese el ID del producto de limpieza al que desea quitarle stock: ");
        int idProducto = scanner.nextInt();
        Producto producto = buscarProductoPorId(productosLimpieza, idProducto);

        if (producto != null) {
            System.out.print("Ingrese la cantidad de stock que desea quitar: ");
            int cantidad = scanner.nextInt();
            producto.eliminarStock(cantidad);
            System.out.println("Stock del producto de limpieza actualizado correctamente.");
        } else {
            System.out.println("Producto de limpieza no encontrado.");
        }
    }

    public void disminuirStockElectrodomestico() {
        System.out.print("Ingrese el ID del producto electrodoméstico al que desea quitarle stock: ");
        int idProducto = scanner.nextInt();
        Producto producto = buscarProductoPorId(productosElectrodomestico, idProducto);

        if (producto != null) {
            System.out.print("Ingrese la cantidad de stock que desea quitar: ");
            int cantidad = scanner.nextInt();
            producto.eliminarStock(cantidad);
            System.out.println("Stock del producto electrodoméstico actualizado correctamente.");
        } else {
            System.out.println("Producto electrodoméstico no encontrado.");
        }
    }


    public void disminuirStockAlimento() {
        System.out.print("Ingrese el ID del producto de alimento al que desea quitarle stock: ");
        int idProducto = scanner.nextInt();
        Producto producto = buscarProductoPorId(productosAlimento, idProducto);

        if (producto != null) {
            System.out.print("Ingrese la cantidad de stock que desea quitar: ");
            int cantidad = scanner.nextInt();
            producto.eliminarStock(cantidad);
            System.out.println("Stock del producto de alimento actualizado correctamente.");
        } else {
            System.out.println("Producto de alimento no encontrado.");
        }
    }

    public void disminuirStockMaquillaje() {
        System.out.print("Ingrese el ID del producto de maquillaje al que desea quitarle stock: ");
        int idProducto = scanner.nextInt();
        Producto producto = buscarProductoPorId(productosMaquillaje, idProducto);

        if (producto != null) {
            System.out.print("Ingrese la cantidad de stock que desea quitar: ");
            int cantidad = scanner.nextInt();
            producto.eliminarStock(cantidad);
            System.out.println("Stock del producto de maquillaje actualizado correctamente.");
        } else {
            System.out.println("Producto de maquillaje no encontrado.");
        }
    }

    public void realizarCompra() {
        System.out.print("Ingrese el ID del cliente que realiza la compra: ");
        int idCliente = scanner.nextInt();
        Cliente cliente = buscarClientePorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Seleccione la categoría del producto:");
        System.out.println("1. Limpieza");
        System.out.println("2. Maquillaje");
        System.out.println("3. Alimento");
        System.out.println("4. Electrodoméstico");
        int opcionCategoria = scanner.nextInt();
        ArrayList<? extends Producto> listaProductos = null;
        switch (opcionCategoria) {
            case 1:
                listaProductos = productosLimpieza;
                break;
            case 2:
                listaProductos = productosMaquillaje;
                break;
            case 3:
                listaProductos = productosAlimento;
                break;
            case 4:
                listaProductos = productosElectrodomestico;
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        System.out.println("Productos disponibles:");
        for (Producto producto : listaProductos) {
            System.out.println(producto.obtenerInformacion());
        }

        System.out.print("Ingrese el ID del producto que desea comprar: ");
        int idProducto = scanner.nextInt();
        Producto productoSeleccionado = buscarProductoPorId(listaProductos, idProducto);
        if (productoSeleccionado == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Ingrese la cantidad que desea comprar: ");
        int cantidadCompra = scanner.nextInt();
        if (cantidadCompra > productoSeleccionado.getStock()) {
            System.out.println("La cantidad seleccionada supera el stock disponible.");
            return;
        }

        // Realizar la compra
        double totalCompra = productoSeleccionado.getPrecio() * cantidadCompra;
        Compra compra = new Compra(cliente, new ArrayList<>(), cantidadCompra, totalCompra);
        compra.agregarProducto(productoSeleccionado); // Agregar el producto comprado a la lista de productos de la compra


        // Agregar la compra a la lista de compras del cliente
        cliente.agregarCompra(compra);

        // Actualizar el stock del producto según la cantidad comprada
        productoSeleccionado.disminuirStock(cantidadCompra);

        // Agregar la compra a la lista general de compras
        compras.add(compra);

        System.out.println("Compra realizada con éxito.");
    }


    public void mostrarComprasRegistradas() {
        System.out.println("Compras registradas:");
        for (Compra compra : compras) {
            System.out.println(compra.obtenerInformacion());
        }
    }

}


        














