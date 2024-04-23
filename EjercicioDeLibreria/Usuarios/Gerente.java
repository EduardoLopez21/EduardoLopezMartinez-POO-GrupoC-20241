package Usuarios;

import Usuarios.utils.Rol;
import libreria.Libreria;
import libreria.util.DatosComun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static libreria.Libreria.usuarios;
import static libreria.util.DatosComun.obtenerDatosComun;

public class Gerente extends Usuario {
    private double sueldo;
    private String rfc;
    private String INE;

    public Gerente(String nombre, String apellido, String telefono, double sueldo, String rfc, String INE, String nombreUsuario, String contraseña) {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario, contraseña);
        this.sueldo = sueldo;
        this.INE = INE;
        this.rfc = rfc;
    }

    @Override

    public String toString() { //Aqui  lo estamos sobre escribiendo gracias al override y con eso el programa toma primero en cuenta la clase hija que el metodo de la clase padre
        return String.format("%s, Sueldo: %f, RFC: %s, INE: %s",
                super.toString(), this.sueldo, this.rfc, this.INE);
    }

    public static void registrarGerente() {
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


    public static void mostrarGerente() {
        System.out.println("\n Asistentes en la Biblioteca");
        for (Usuario usuario : usuarios.get(Rol.GERENTE)) {
            if (usuario.getRol() == Rol.GERENTE) {
                Gerente gerente = (Gerente) usuario;
                System.out.println(gerente.toString());
            }
        }
    }

    public static void EliminarGerente(int idGerente, String nombreUsuario) {
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


}
