import java.util.Scanner;

public class Triangulo extends Shape {

  Scanner leer = new Scanner(System.in);

  double Base;
  double Altura;
  double Lado1;
  double Lado2;
  double Lado3;

  @Override
  public void CalcularArea() {
    System.out.println("Ingresa la Base: ");
    Base = leer.nextDouble();
    System.out.println("Ingresa la Altura: ");
    Altura = leer.nextDouble();

    double Area = (Base * Altura) / 2;
    System.out.println("El Area del triangulo es: " + Area);
  }

  public void CalcularPerimetro() {

    System.out.println("Ingresa el primer Lado: ");
    Lado1 = leer.nextDouble();
    System.out.println("Ingresa el Segundo Lado: ");
    Lado2 = leer.nextDouble();
    System.out.println("Ingresa el Tercer Lado: ");
    Lado3 = leer.nextDouble();

    double Perimetro = Lado1 + Lado2 + Lado3;
    System.out.println("El perimetro del triangulo es: " + Perimetro);
  }
}