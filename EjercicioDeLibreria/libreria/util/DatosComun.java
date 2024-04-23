package libreria.util;

import Usuarios.Usuario;
import Usuarios.utils.Rol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import libreria.Libreria;

import static libreria.Libreria.usuarios;

public class DatosComun {

    public static ArrayList<String> obtenerDatosComun(Rol rol) {
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

    private static String registrarTelefonoUsuario() {
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

    private static String registrarNombreUsuario() {
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
}
