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

    private List<Libros> librosRegistrados;
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();

    public Libreria() {
        usuarios.put(Rol.CLIENTE, new ArrayList<>());
        usuarios.put(Rol.ASISTENTE, new ArrayList<>());
        usuarios.put(Rol.GERENTE, new ArrayList<>());

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

    public void registrarClientes() {
        Cliente.registrarClientes();
    }

    public void mostrarClientes() {
        Cliente.mostrarClientes();
    }

    public void EliminarCliente(int idCliente) {
        Cliente.EliminarCliente(idCliente);
    }

    public void registrarAsistentes() {
        Asistente.registrarAsistentes();
    }

    public void mostrarAsistentes() {
        Asistente.mostrarAsistentes();
    }

    public void EliminarAsistente(int idAsistente) {
        Asistente.EliminarAsistente(idAsistente);
    }

    public void registrarGerente() {
        Gerente.registrarGerente();
    }

    public void mostrarGerente() {
        Gerente.mostrarGerente();
    }

    public void EliminarGerente(int idGerente, String nombreUsuario) {
        Gerente.EliminarGerente(idGerente, nombreUsuario);
    }

    public void registrarLibros() {
        Libros.registrarLibros();
    }

    public void mostrarLibros() {
        Libros.mostrarLibros();
    }

}

