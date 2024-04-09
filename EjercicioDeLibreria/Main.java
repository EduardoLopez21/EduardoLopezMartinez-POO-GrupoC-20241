import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Usuario;
import Usuarios.Gerente;
import utils.Rol;

public class Main {
    public static void main(String[] args) {
       // System.out.println(Rol.ASISTENTE);

       System.out.println("Prueba de que funciona el Cliente: ");

       Cliente cliente = new Cliente("Juan", "Rivera", "443390");
       System.out.println(cliente.toString());

       System.out.println("Prueba de que funciona el Asistente: ");

       Asistente asistente = new Asistente("Geovanny", "Pérez", "443567", 43.7, "FRED677GG");
       System.out.println(asistente.toString());

       System.out.println("Prueba de que funciona el Gerente: ");

       Gerente gerente = new Gerente("Hugo", "Garcia", "4474689", 100, "GHFUJJG877", "HUJHHIHJK88");
        System.out.println(gerente.toString());
    }
    
}
