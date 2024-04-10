import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Usuario;
import Usuarios.Gerente;
import utils.Rol;

public class Sistema {
    public static void main(String[] args) {
       // System.out.println(Rol.ASISTENTE);

       System.out.println("Prueba de que funciona el Cliente: ");

       Cliente cliente = new Cliente("Pablito", "Tellez", "443390");
       System.out.println(cliente.toString());

       System.out.println("Prueba de que funciona el Asistente: ");

       Asistente asistente = new Asistente("Milka", "Tilina", "44356217", 46.1, "FdADADA");
       System.out.println(asistente.toString());

       System.out.println("Prueba de que funciona el Gerente: ");

       Gerente gerente = new Gerente("Melissa", "Garcia", "2321312", 40, "G87DADSD7", "DOALDAWD99");
        System.out.println(gerente.toString());
    }
    
}
