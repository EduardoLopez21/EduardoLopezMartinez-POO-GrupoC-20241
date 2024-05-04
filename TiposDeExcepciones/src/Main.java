import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Excepciones excepciones = new Excepciones();

        int opcion;

        do {
            System.out.println("\nIngrese el número correspondiente a la excepción que desea probar:");
            System.out.println("1. Probar: NumberFormatException");
            System.out.println("2. Probar: ArrayIndexOutOfBoundsException");
            System.out.println("3. Probar: NullPointerException");
            System.out.println("4. Probar: ArithmeticException");
            System.out.println("5. Probar: ClassCastException");
            System.out.println("6. Probar: IllegalArgumentException");
            System.out.println("7. Probar: InterruptedException");
            System.out.println("8. Probar: UnsupportedOperationException");
            System.out.println("9. Probar: FileNotFoundException");
            System.out.println("10. Probar: ParseException");
            System.out.println("11. SALIR DEL PROGRAMA");
            System.out.print("¿Qué opción deseas ejecutar?: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese una cadena que no sea un número:");
                    String cadena1 = scanner.nextLine();
                    excepciones.probarNumberFormatException(cadena1);
                    break;
                case 2:
                    excepciones.probarArrayIndexOutOfBoundsException();
                    break;
                case 3:
                    excepciones.probarNullPointerException();
                    break;
                case 4:
                    excepciones.probarArithmeticException();
                    break;
                case 5:
                    excepciones.probarClassCastException();
                    break;
                case 6:
                    excepciones.probarIllegalArgumentException();
                    break;
                case 7:
                    excepciones.probarInterruptedException();
                    break;
                case 8:
                    excepciones.probarUnsupportedOperationException();
                    break;
                case 9:
                    excepciones.probarFileNotFoundException();
                    break;
                case 10:
                    System.out.println("Ingrese una fecha en formato dd/MM/yyyy:");
                    String fechaString = scanner.nextLine();
                    excepciones.probarParseException(fechaString);
                    break;
                case 11:
                    System.out.println("¡Hasta luego! \nSaliendo del programa.....");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 11);
    }
}