import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Excepciones {

    public void probarNumberFormatException(String cadena) {
        System.out.println("1.- NumberFormatException: Se lanza cuando se intenta convertir una cadena a un tipo numérico, pero la cadena no tiene el formato adecuado.");
        try {
            int numero = Integer.parseInt(cadena);
            System.out.println("Número ingresado: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("La cadena no se puede convertir a un número.");
        }
    }

    public void probarArrayIndexOutOfBoundsException() {
        System.out.println("2.- ArrayIndexOutOfBoundsException: Se lanza cuando se intenta acceder a un índice fuera del rango de un array.");
        int[] array = {1, 2, 3};
        try {
            System.out.println("{1,2,3} || Ingrese el índice al que desea acceder: ");
            Scanner scanner = new Scanner(System.in);
            int indice = scanner.nextInt();
            int valor = array[indice];
            System.out.println("Valor en el índice " + indice + ": " + valor);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Índice fuera del rango del array.");
        }
    }

    public void probarNullPointerException() {
        System.out.println("3.- NullPointerException: Se lanza cuando se intenta acceder a un objeto que es nulo.");
        System.out.println("Ingrese una cadena:");
        Scanner scanner = new Scanner(System.in);
        String cadena = scanner.nextLine();
        try {
            int longitud = cadena.length();
            System.out.println("Longitud de la cadena: " + longitud);
        } catch (NullPointerException e) {
            System.out.println("La cadena es nula.");
        }
    }

    public void probarArithmeticException() {
        System.out.println("4.- ArithmeticException: Se lanza cuando ocurre una operación aritmética inválida, como la división por cero.");
        System.out.println("Ingrese el divisor:");
        Scanner scanner = new Scanner(System.in);
        int divisor = scanner.nextInt();
        try {
            int resultado = 10 / divisor;
            System.out.println("Resultado de la división: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("División por cero.");
        }
    }

    public void probarClassCastException() {
        System.out.println("5.- ClassCastException: Se lanza cuando se intenta convertir un objeto a un tipo incompatible.");
        System.out.println("Ingrese un número:");
        Scanner scanner = new Scanner(System.in);
        Object objeto = scanner.nextInt();
        try {
            String cadena = (String) objeto;
            System.out.println("Cadena convertida: " + cadena);
        } catch (ClassCastException e) {
            System.out.println("No se puede convertir el objeto a una cadena.");
        }
    }

    public void probarIllegalArgumentException() {
        System.out.println("6.- IllegalArgumentException: Se lanza cuando se pasa un argumento ilegal a un método.");
        System.out.println("Ingrese una cadena que no sea un número:");
        Scanner scanner = new Scanner(System.in);
        String cadena = scanner.nextLine();
        try {
            int numero = Integer.parseInt(cadena);
            System.out.println("Número ingresado: " + numero);
        } catch (IllegalArgumentException e) {
            System.out.println("Argumento ilegal.");
        }
    }

    public void probarInterruptedException() {
        System.out.println("7.- InterruptedException: Se lanza cuando un hilo está esperando, durmiendo o inactivo y es interrumpido.");
        try {
            System.out.println("El programa se dormirá durante 3 segundos...");
            Thread.sleep(3000);
            System.out.println("El programa ha despertado.");
        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido mientras dormía.");
        }
    }

    public void probarUnsupportedOperationException() {
        System.out.println("8.- UnsupportedOperationException: Se lanza cuando se intenta realizar una operación que no está soportada.");
        try {
            throw new UnsupportedOperationException("Operación no soportada.");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    public void probarFileNotFoundException() {
        System.out.println("9.- FileNotFoundException: Se lanza cuando se intenta acceder a un archivo que no existe.");
        System.out.println("Ingrese el nombre del archivo:");
        Scanner scanner = new Scanner(System.in);
        String nombreArchivo = scanner.nextLine();
        try {
            throw new java.io.FileNotFoundException("Archivo '" + nombreArchivo + "' no encontrado.");
        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public void probarParseException(String fechaString) {
        System.out.println("10.- ParseException: Se lanza cuando ocurre un error al analizar (parsear) una cadena a una fecha.");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = sdf.parse(fechaString);
            System.out.println("Fecha parseada correctamente: " + fecha);
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha. Formato incorrecto.");
        }
    }
}

