import java.util.Scanner;

public class Rectangulo extends Shape {

    Scanner leer = new Scanner(System.in);

    double Base;
    double Altura;

    @Override
    public void CalcularArea() {

        System.out.println("Ingresa la Base: ");
        Base = leer.nextDouble();
        System.out.println("Ingresa la Altura: ");
        Altura = leer.nextDouble();
        double Area = Base * Altura;
        System.out.println("El Area del Rectangulo es: " + Area);
    }

    public void CalcularPerimetro() {
        System.out.println("Ingresa la Base: ");
        Base = leer.nextDouble();
        System.out.println("Ingresa la Altura: ");
        Altura = leer.nextDouble();
        double Perimetro = (2 * Altura) + (2 * Base);
        System.out.println("El perimetro del Rectangulo es: " + Perimetro);
    }
}