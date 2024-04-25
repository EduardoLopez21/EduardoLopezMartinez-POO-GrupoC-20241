import java.util.Scanner;

public class Paralelogramo extends Shape {

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
        System.out.println("El Area del Paralelogramo es: " + Area);
    }

    public void CalcularPerimetro() {
        System.out.println("Ingresa la Base: ");
        Base = leer.nextDouble();
        System.out.println("Ingresa la Altura: ");
        Altura = leer.nextDouble();

        double Perimetro = 2 * (Altura + Base);
        System.out.println("El perimetro del Paralelogramo es: " + Perimetro);
    }
}
