package javaapplication5;

import java.util.Scanner;

public class Tarea7 {

    public static void main(String[] args) {

        Banco banco = new Banco();
        
        Employee employee = new Employee("Juan", 25, 12.13, 23123);
        employee.getAccounts().add(new BankAccount(45678)); // Juan también tiene otra cuenta
        banco.agregarEmpleado(employee);

        Employee Secondemployee = new Employee("Pedro", 30, 32.21, 232132);
        banco.agregarEmpleado(Secondemployee);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu:");
            System.out.println("1. Mostrar a todos los usuarios con su información");
            System.out.println("2. Mostrar la información de algún usuario en específico");
            System.out.println("3. Listar todas las cuentas bancarias existentes");
            System.out.println("4. Mostrar información de alguna cuenta bancaria en específico");
            System.out.println("5. Salir");

            System.out.print("Ingrese la opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    banco.mostrarTodosLosUsuarios();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    banco.mostrarInformacionUsuario(nombreUsuario);
                    break;
                case 3:
                    banco.listarTodasLasCuentas();
                    break;
                case 4:
                    System.out.print("Ingrese el número de cuenta bancaria: ");
                    long numeroCuenta = scanner.nextLong();
                    banco.mostrarInformacionCuenta(numeroCuenta);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (opcion != 5);
    }
}
