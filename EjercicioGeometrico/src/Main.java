import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué figura desea calcular?");
        System.out.println("1. Triángulo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Rectángulo");
        System.out.println("4. Paralelogramo");
        System.out.print("Ingresa tu opcion: ");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                calcularTriangulo();
                break;
            case 2:
                calcularCuadrado();
                break;
            case 3:
                calcularRectangulo();
                break;
            case 4:
                calcularParalelogramo();
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    public static void calcularTriangulo() {
        Triangulo triangulo = new Triangulo();
        System.out.println("Calcular Area");
        triangulo.calcularArea();
        System.out.println("Calcular Perimetro");
        triangulo.calcularPerimetro();
    }

    public static void calcularCuadrado() {
        Cuadrado cuadrado = new Cuadrado();
        System.out.println("Calcular Area");
        cuadrado.calcularArea();
    System.out.println("Calcular Perimetro");
        cuadrado.calcularPerimetro();
    }

    public static void calcularRectangulo() {
        Rectangulo rectangulo = new Rectangulo();
        System.out.println("Calcular Area");
        rectangulo.calcularArea();
        System.out.println("Calcular Perimetro");
        rectangulo.calcularPerimetro();
    }

    public static void calcularParalelogramo() {
        Paralelogramo paralelogramo = new Paralelogramo();
        System.out.println("Calcular Area");
        paralelogramo.calcularArea();
        System.out.println("Calcular Perimetro");
        paralelogramo.calcularPerimetro();
    }
}