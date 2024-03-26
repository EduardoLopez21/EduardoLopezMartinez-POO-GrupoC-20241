import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        ArrayList<Employee> empleados = new ArrayList<Employee>(); // ArrayList para almacenar empleados

        int opcion = 0;

        do {
            System.out.println("\n*** BIENVENIDO AL PROGRAMA ***");
            System.out.println("\nMenú:");
            System.out.println("1. Registrar empleado");
            System.out.println("2.- Mostrar informacion de empleados");
            System.out.println("3. Registrar visitante");
            System.out.println("4.- Mostrar informacion del visitante");
            System.out.println("5. Registrar visita al zoo");
            System.out.println("6. Registrar animal");
            System.out.println("7.- Mostrar informacion del animal");
            System.out.println("8. Realizar mantenimiento de animal");
            System.out.println("9. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = leer.nextInt();

            switch (opcion) {

                case 1:

                    // Aqui seria la opcion 1.- Registrar empleado

                    System.out.println("Haz seleccionado la opcion 1 \n");
                    // Ingresar información del empleado
                    System.out.println("\nIngreso de información del empleado:");
                    System.out.print("Nombre: ");
                    String nombre = leer.nextLine();
                    leer.nextLine();

                    System.out.print("Apellidos: ");
                    String apellidos = leer.nextLine();

                    System.out.print("Fecha de nacimiento (DD-MM-YYYY): ");
                    String fechaNacimiento = leer.nextLine();

                    System.out.print("Fecha de ingreso como trabajador (DD-MM-YYYY): ");
                    String fechaIngreso = leer.nextLine();

                    System.out.print("RFC: ");
                    String rfc = leer.nextLine();

                    System.out.print("CURP: ");
                    String curp = leer.nextLine();

                    System.out.print("Salario: ");
                    double salario = leer.nextDouble();

                    leer.nextLine(); // Limpiar el scanner
                    System.out.print("Horario (Dias y horas): ");
                    String horario = leer.nextLine();

                    System.out.print("Rol: ");
                    String rol = leer.nextLine();

                    // Crear el objeto empleado con los datos ingresados y agregarlo al ArrayList
                    Employee nuevoEmpleado = new Employee(nombre, apellidos, fechaNacimiento, fechaIngreso, rfc, curp,
                            salario, horario, rol);
                    empleados.add(nuevoEmpleado);
                    System.out.println("Empleado registrado con éxito.");

                    break;
                case 2:
                    // Aqui seria la opcion 2.- Mostrar informacion de empleados
                    System.out.println("Haz seleccionado la opcion 2 \n");

                    if (!empleados.isEmpty()) { // Este condicional verifica si la lista de empleados (empleados) no
                                                // está vacía. isEmpty() es un método de la clase ArrayList que devuelve
                                                // true si la lista está vacía y false
                        for (Employee empleado : empleados) { // Este bucle for-each itera sobre todos los elementos de
                                                              // la lista de empleados (empleados). En cada iteración,
                                                              // el objeto empleado toma el valor del siguiente empleado
                                                              // en la lista.
                            System.out.println(empleado.getData());
                        }
                    } else {
                        System.out.println(
                                "No hay información de empleados disponible. Por favor, ingrese los datos de al menos un empleado primero.");
                    }
                    break;

                case 3:
                    System.out.println("Haz seleccionado la opcion 3 \n");
                    // Aqui seria la opcion 3.- Registrar visitante
                    break;

                case 4:
                    System.out.println("Haz seleccionado la opcion 4 \n");
                    // Aqui seria la opcion 4.- Mostrar informacion del visitante
                    break;

                case 5:
                    System.out.println("Haz seleccionado la opcion 5 \n");
                    // Aqui seria la opcion 5.- Registrar visita al zoo
                    break;
                case 6:
                    System.out.println("Haz seleccionado la opcion 6 \n");
                    // Aqui seria la opcion 6.- Registrar animal
                    break;

                case 7:
                    // Aqui seria la opcion 7.- Mostrar info animal
                    break;

                case 8:
                    // Aqui seria la opcion 8.- Realizar mantenimineto del animal
                    break;

                case 9:
                    System.out.println("\n Saliendo del programa.... ¡Hasta luego!");
                    System.out.println("\n Leaving the program.... See you later!\n");
                    // Opcion.- Salir
                    break;

            }

        } while (opcion != 9);
    }
}
