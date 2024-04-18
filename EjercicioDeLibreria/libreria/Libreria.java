package libreria;

import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Libreria {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Libros> librosRegistrados;

    public Libreria() {
        Asistente asistente = new Asistente("Juan", "Rivera", "443831893122", 15000, "RUJU231231", "LOME3892893", "juan123", "12345");
        usuarios.add(asistente);

        Gerente gerente = new Gerente("Lalo", "Lopez", "4471178990", 20000, "LOME121590A1", "L2919OOME", "Lalito12", "12lolo");
        usuarios.add(gerente);

        this.librosRegistrados = new ArrayList<>();
    }


    public Usuario verificarInicioSesion(String nombreUsuario, String contraseña) {
        for (Usuario usuarios : usuarios) {
            if (usuarios.getNombreUsuario().equals(nombreUsuario)) {
                if (usuarios.getContraseña().equals(contraseña)) {
                    return usuarios;
                }
                return null;
            }
        }
        return null;
    }

    public void registrarClientes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Registrando Cliente");
        System.out.println("Ingresar los siguientes datos para continuar");

        System.out.print("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa los apellidos: ");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoUsuario();
        String nombreUsuario = registrarNombreUsuario();

        System.out.print("Ingresa el password: ");
        String contraseña = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contraseña);
        usuarios.add(cliente);
        System.out.println("\n¡Cliente registrado exitosamente!\n");

    }

    public void mostrarClientes() {
        System.out.println("\n Clientes en la Biblioteca");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.CLIENTE) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
            }
        }
    }


    public void registrarAsistentes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Registrando Asistente");
        System.out.println("Ingresar los siguientes datos para continuar");

        System.out.print("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa los apellidos: ");
        String apellido = scanner.nextLine();


        String telefono = registrarTelefonoUsuario();

        System.out.print("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();

        scanner.nextLine();
        System.out.print("Ingresa el RFC: ");
        String rfc = scanner.nextLine();

        System.out.print("Ingresa la INE: ");
        String INE = scanner.nextLine();

        String nombreUsuario = registrarNombreUsuario();

        System.out.print("Ingresa el password: ");
        String contraseña = scanner.nextLine();

        Asistente asistente = new Asistente(nombre, apellido, telefono, sueldo, rfc, INE, nombreUsuario, contraseña);
        usuarios.add(asistente);
        System.out.print("\n¡Cliente registrado exitosamente!\n");

    }

    public void mostrarAsistentes() {
        System.out.println("\n Asistentes en la Biblioteca");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.ASISTENTE) {
                Asistente asistente = (Asistente) usuario;
                System.out.println(asistente.toString());
            }
        }
    }

    public void registrarGerente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Registrando Gerente");
        System.out.println("Ingresar los siguientes datos para continuar");

        System.out.print("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa los apellidos: ");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoUsuario();

        System.out.print("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();

        scanner.nextLine();
        System.out.print("Ingresa el RFC: ");
        String rfc = scanner.nextLine();

        System.out.print("Ingresa la INE: ");
        String INE = scanner.nextLine();

        String nombreUsuario = registrarNombreUsuario();

        System.out.print("Ingresa el password: ");
        String contraseña = scanner.nextLine();

        Gerente gerente = new Gerente(nombre, apellido, telefono, sueldo, rfc, INE, nombreUsuario, contraseña);
        usuarios.add(gerente);
        System.out.println("\n¡Cliente registrado exitosamente!\n");

    }

    public void mostrarGerente() {
        System.out.println("\n Asistentes en la Biblioteca");
        for (Usuario usuario : usuarios) {
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
            for (Usuario usuario : usuarios) {
                if (usuario.getTelefono().equals(telefono)) {
                    telefonoExistente = true;
                    break;
                }
            }

            if (telefonoExistente) {
                System.out.println("\n El telefono ya se encuentra registrado. Intenta de nuevo.");
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
            for (Usuario usuario : usuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    nombreUsuarioExistente = true;
                    break;
                }
            }

            if (nombreUsuarioExistente) {
                System.out.println("\n Ya existe un registro con ese nombre de usuario. Intenta de nuevo.");
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }


    public void EliminarAsistente(int idAsistente) {
        Usuario asistente = null;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Asistente && ((Asistente) usuario).getId() == idAsistente) {
                asistente = usuario;
                break;
            }
        }
        if (asistente != null) {
            usuarios.remove(asistente);
            System.out.println("\nAsistente eliminado exitosamente.");
        } else {
            System.out.println("\nNo se encontró ningún cliente con ese ID.");
        }
    }

    public void EliminarCliente(int idCliente) {
        Usuario cliente = null;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente && ((Cliente) usuario).getId() == idCliente) {
                cliente = usuario;
                break;
            }
        }
        if (cliente != null) {
            usuarios.remove(cliente);
            System.out.println("\nCliente eliminado exitosamente.");
        } else {
            System.out.println("\nNo se encontró ningún cliente con ese ID.");
        }
    }

    public void EliminarGerente(int idGerente) {
        Usuario gerente = null;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente && ((Cliente) usuario).getId() == idGerente) {
                gerente = usuario;
                break;
            }
        }
        if (gerente != null) {
            usuarios.remove(gerente);
            System.out.println("\nGerente eliminado exitosamente.");
        } else {
            System.out.println("\nNo se encontró ningún cliente con ese ID.");
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
