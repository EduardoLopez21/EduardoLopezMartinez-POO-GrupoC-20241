package libreria;

import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import com.sun.nio.sctp.AbstractNotificationHandler;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.*;

public class Libreria {
    // private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Libros> librosRegistrados;
    HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();

    public Libreria() {
        usuarios.put(Rol.CLIENTE, new ArrayList<>());
        usuarios.put(Rol.ASISTENTE, new ArrayList<>());
        usuarios.put(Rol.GERENTE, new ArrayList<>());

        // Agregar usuarios de ejemplo
        Asistente asistente = new Asistente("Juan", "Rivera", "443831893122", 15000, "RUJU231231", "juan123", "12345");
        usuarios.get(Rol.ASISTENTE).add(asistente);

        Gerente gerente = new Gerente("Lalo", "Lopez", "4471178990", 20000, "LOME121590A1", "L2919OOME", "Lalito12", "12lolo");
        usuarios.get(Rol.GERENTE).add(gerente);

        this.librosRegistrados = new ArrayList<>();
    }


    public Usuario verificarInicioSesion(String nombreUsuario, String contraseña) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                    return usuario;
                }
            }
        }
        return null;
    }


    private ArrayList<String> obtenerDatosComun(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<String>();
        String rolUsuario = rol == Rol.CLIENTE ? "CLIENTE" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente";
        System.out.println(String.format("Bienvenido al registro del %s", rolUsuario));
        System.out.print("\n Ingresa los siguientes datos para continuar");
        System.out.print("\n Ingresa el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa los Apellidos: ");
        String apellido = scanner.nextLine();
        String telefono = registrarTelefonoUsuario();
        String nombreUsuario = registrarNombreUsuario();
        System.out.print("Ingresa tu contraseña: ");
        String contraseña = scanner.nextLine();

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contraseña));
        return datosComun;
    }

    public void registrarClientes() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.CLIENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contraseña);

        if (!usuarios.containsKey(Rol.CLIENTE)) {
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("\n Cliente registrado exitosamente...");

    }

    public void mostrarClientes() {
        System.out.println("\n Clientes en la Biblioteca");
        for (Usuario usuario : usuarios.get(Rol.CLIENTE)) {
            if (usuario.getRol() == Rol.CLIENTE) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
            }
        }
    }


    public void registrarAsistentes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Registrando Asistente");
        ArrayList<String> datosComun = obtenerDatosComun(Rol.ASISTENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);

        System.out.print("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();

        scanner.nextLine();
        System.out.print("Ingresa el RFC: ");
        String rfc = scanner.nextLine();


        Asistente asistente = new Asistente(nombre, apellido, telefono, sueldo, rfc, nombreUsuario, contraseña);
        if (!usuarios.containsKey(Rol.ASISTENTE)) {
            usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.ASISTENTE).add(asistente);
        System.out.println("\n Cliente registrado exitosamente...");

    }

    public void mostrarAsistentes() {
        System.out.println("\n Asistentes en la Biblioteca");
        for (Usuario usuario : usuarios.get(Rol.ASISTENTE)) {
            if (usuario.getRol() == Rol.ASISTENTE) {
                Asistente asistente = (Asistente) usuario;
                System.out.println(asistente.toString());
            }
        }
    }

    public void registrarGerente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Registrando Gerente.....");
        System.out.println("Ingresar los siguientes datos para continuar");
        ArrayList<String> datosComun = obtenerDatosComun(Rol.ASISTENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);

        System.out.print("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();

        scanner.nextLine();
        System.out.print("Ingresa el RFC: ");
        String rfc = scanner.nextLine();

        System.out.print("Ingresa la INE: ");
        String INE = scanner.nextLine();

        Gerente gerente = new Gerente(nombre, apellido, telefono, sueldo, rfc, INE, nombreUsuario, contraseña);
        if (!usuarios.containsKey(Rol.GERENTE)) {
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);
        System.out.println("\n Cliente registrado exitosamente...");
    }


    public void mostrarGerente() {
        System.out.println("\n Asistentes en la Biblioteca");
        for (Usuario usuario : usuarios.get(Rol.GERENTE)) {
            if (usuario.getRol() == Rol.GERENTE) {
                Gerente gerente = (Gerente) usuario;
                System.out.println(gerente.toString());
            }
        }
    }

    private String registrarTelefonoUsuario() {
        Scanner scanner = new Scanner(System.in);

        boolean telefonoExistente = true;
        String telefono = "";
        do {
            System.out.print("Ingresa el teléfono: ");
            telefono = scanner.nextLine();

            telefonoExistente = false;
            for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getTelefono().equals(telefono)) {
                        telefonoExistente = true;
                        break;
                    }
                }


                if (telefonoExistente) {
                    System.out.println("\n El telefono ya se encuentra registrado. Intenta de nuevo.");
                }
            }
        } while (telefonoExistente);

        return telefono;
    }

    private String registrarNombreUsuario() {
        Scanner scanner = new Scanner(System.in);

        String nombreUsuario = "";
        boolean nombreUsuarioExistente = true;
        do {
            System.out.print("Ingresa el nombre de usuario: ");
            nombreUsuario = scanner.nextLine();

            nombreUsuarioExistente = false;
            for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                        nombreUsuarioExistente = true;
                        break;
                    }
                }

                if (nombreUsuarioExistente) {
                    System.out.println("\n Ya existe un registro con ese nombre de usuario. Intenta de nuevo.");
                }
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }


    public void EliminarAsistente(int idAsistente) {
        boolean encontrado = false;
        Iterator<Usuario> iterator = usuarios.get(Rol.ASISTENTE).iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario instanceof Asistente && ((Asistente) usuario).getId() == idAsistente) {
                iterator.remove();
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("\nCliente eliminado exitosamente.");
        } else {
            System.out.println("\nNo se encontró ningún cliente con ese ID.");
        }
    }

    public void EliminarCliente(int idCliente) {
        boolean encontrado = false;
        Iterator<Usuario> iterator = usuarios.get(Rol.CLIENTE).iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario instanceof Cliente && ((Cliente) usuario).getId() == idCliente) {
                iterator.remove();
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("\nCliente eliminado exitosamente.");
        } else {
            System.out.println("\nNo se encontró ningún cliente con ese ID.");
        }
    }


    public void EliminarGerente(int idGerente, String nombreUsuario) {
        Usuario gerente = null;
        Usuario usuarioEliminar = null;

        for (Usuario usuario : usuarios.get(Rol.GERENTE)) {
            if (usuario instanceof Gerente && usuario.getId() == idGerente) {
                gerente = usuario;
                break;
            }
        }

        if (gerente == null) {
            System.out.println("\nNo se encontró ningún gerente con ese ID.");
            return;
        }

        for (Usuario usuario : usuarios.values().stream().flatMap(List::stream).toList()) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                usuarioEliminar = usuario;
                break;
            }
        }

        if (usuarioEliminar != null && usuarioEliminar instanceof Gerente && usuarioEliminar.getNombreUsuario().equals(nombreUsuario)) {
            usuarios.get(Rol.GERENTE).remove(gerente);
            System.out.println("\nGerente eliminado exitosamente.");
        } else {
            System.out.println("\nEl usuario no es un gerente o el nombre de usuario no coincide. No se puede eliminar al gerente.");
        }
    }


    public void registrarLibros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Registrando Libros");
        System.out.println("Ingresar los siguientes datos para continuar");

        System.out.print("Ingresa el Titulo del Libro: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingresa el Autor del Libro: ");
        String autor = scanner.nextLine();

        System.out.print("Ingresa la Fecha de Publicacion del Libro: ");
        String fechaDePublicacion = scanner.nextLine();

        Libros libro = new Libros(titulo, autor, fechaDePublicacion);
        librosRegistrados.add(libro);
        System.out.println("\n¡Libro registrado exitosamente!\n");

    }

    public void mostrarLibros() {
        System.out.println("\nLibros registrados en la Biblioteca:");
        for (Libros libro : librosRegistrados) {
            System.out.println(libro.getInfoLibro());
        }
    }


}

// ------------------- NOTAS DE CLASE :D ------------------


// MODIFICACIONES PARA LOS CLIENTES

//if (!usuarios.containsKey(Rol.CLIENTE)){
//    usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
//       }
//  usuarios.get(Rol.CLIENTE).add(cliente);


