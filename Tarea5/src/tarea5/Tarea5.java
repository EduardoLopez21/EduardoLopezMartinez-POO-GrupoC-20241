package tarea5;

public class Tarea5 {

    public static void main(String[] args) {
        // Crear una instancia de la clase Rectangulo
        Rectangulo Rectangulo = new Rectangulo();

        // Llamar a los métodos de la clase Rectangulo
        System.out.println(Rectangulo.Area(5, 10));
        System.out.println(Rectangulo.Perimetro(5, 10));
        System.out.println(Rectangulo.Area(5.5, 10.5));
        System.out.println(Rectangulo.Perimetro(5.5, 10.5));

        System.out.println("///////////////////////////////////////////////////");
        // Crear una instancia de la clase Empleado
        Empleado Empleado = new Empleado();

        // Llamar a los métodos de la clase Empleado
        System.out.println(Empleado.Sueldo(12));

        System.out.println(Empleado.Sueldo(21.5, 32.3));

        System.out.println(Empleado.Sueldo(200, 300.50, 2));

        System.out.println("///////////////////////////////////////////////////");

        CalculadoraImpuestos calculadora = new CalculadoraImpuestos();

        System.out.println(calculadora.calcularImpuestos(2100));

        System.out.println(calculadora.calcularImpuestos(25, 57.50));

        System.out.println(calculadora.calcularImpuestos(15, 70, 32));
    }

}


