package javaapplication5;
import java.util.ArrayList;
public class Banco {

    private ArrayList<Employee> empleados;

    public Banco() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Employee empleado) {
        empleados.add(empleado);
    }

    public void mostrarTodosLosUsuarios() {
        System.out.println("Información de todos los usuarios:");
        for (Employee empleado : empleados) {
            System.out.println(empleado.getData());
            for (BankAccount cuenta : empleado.getAccounts()) {
                System.out.println("  " + cuenta.getAccountInfo());
            }
            System.out.println();
        }
    }

    public void mostrarInformacionUsuario(String nombre) {
        for (Employee empleado : empleados) {
            if (empleado.getName().equals(nombre)) {
                System.out.println(empleado.getData());
                for (BankAccount cuenta : empleado.getAccounts()) {
                    System.out.println("  " + cuenta.getAccountInfo());
                }
                return;
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    public void listarTodasLasCuentas() {
        System.out.println("Listado de todas las cuentas bancarias:");
        for (Employee empleado : empleados) {
            for (BankAccount cuenta : empleado.getAccounts()) {
                System.out.println(cuenta.getAccountInfo());
            }
        }
    }

    public void mostrarInformacionCuenta(long numeroCuenta) {
        for (Employee empleado : empleados) {
            for (BankAccount cuenta : empleado.getAccounts()) {
                if (cuenta.getAccountNumber() == numeroCuenta) {
                    System.out.println(cuenta.getAccountInfo());
                    return;
                }
            }
        }
        System.out.println("Cuenta no encontrada.");
    }
}
