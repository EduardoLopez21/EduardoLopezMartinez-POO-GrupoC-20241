public class Main {

    public static void main(String[] args) {

        Triangulo triangulo = new Triangulo();
        Cuadrado cuadrado = new Cuadrado();
        Rectangulo rectangulo = new Rectangulo();
        Paralelogramo paralelogramo = new Paralelogramo();

        triangulo.CalcularArea();
        triangulo.CalcularPerimetro();

        System.out.println("------------------------------------------------------");

        cuadrado.CalcularArea();
        cuadrado.CalcularPerimetro();

        System.out.println("------------------------------------------------------");

        rectangulo.CalcularArea();
        rectangulo.CalcularPerimetro();

        System.out.println("------------------------------------------------------");

        paralelogramo.CalcularArea();
        paralelogramo.CalcularPerimetro();

    }
}