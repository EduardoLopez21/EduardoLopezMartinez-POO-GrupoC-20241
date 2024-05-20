package Usuarios;

import Usuarios.serializers.UsuarioSerializer;
import Usuarios.utils.Rol;
import Sistema.Sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import libreria.util.DatosComun;

import static libreria.Libreria.usuarios;

public class Cliente extends Usuario {
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, String telefono, String nombreUsuario, String contraseña, String fechaNacimiento) {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contraseña, fechaNacimiento);
        this.fechaRegistro = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("%s, Fecha de registro: %s", super.toString(), this.fechaRegistro);
    }

    public static void registrarClientes() {
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.CLIENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        String fechaNacimiento = datosComun.get(5);

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contraseña, fechaNacimiento);

        if (!Sistema.usuarios.containsKey(Rol.CLIENTE)) {
            Sistema.usuarios.put(Rol.CLIENTE, new ArrayList<>());
        }
        Sistema.usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("\n Cliente registrado exitosamente...");

        UsuarioSerializer.serialize();
    }

    public static void mostrarClientes() {
        System.out.println("\n Clientes en la Biblioteca");
        for (Usuario usuario : usuarios.get(Rol.CLIENTE)) {
            if (usuario.getRol() == Rol.CLIENTE) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
            }
        }
    }

    public static void eliminarCliente(int idCliente) {
        boolean encontrado = false;
        Iterator<Usuario> iterator = Sistema.usuarios.get(Rol.CLIENTE).iterator();
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
            UsuarioSerializer.serialize();
        } else {
            System.out.println("\nNo se encontró ningún cliente con ese ID.");
        }
    }
}

