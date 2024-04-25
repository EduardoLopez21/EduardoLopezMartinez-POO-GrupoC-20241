import java.util.Scanner;

public class Cuadrado extends Shape {

    Scanner leer = new Scanner(System.in);

    double Lado;

    @Override
    public void CalcularArea() {
        System.out.println("Ingresa la longitud del lado: ");
        Lado = leer.nextDouble();
        double Area = Lado * Lado;
        System.out.println("El Area del cuadrado es: " + Area);
    }

    public void CalcularPerimetro() {
        System.out.println("Ingresa la longitud del lado: ");
        Lado = leer.nextDouble();
        double Perimetro = 4 * Lado;
        System.out.println("El perimetro del cuadrado es: " + Perimetro);
    }
}
