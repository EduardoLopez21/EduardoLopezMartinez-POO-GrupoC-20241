class Cuadrado implements Shape {
    double lado;

    @Override
    public void calcularArea() {
        System.out.println("Ingresa la longitud del lado: ");
        lado = Shape.leer.nextDouble();
        double area = lado * lado;
        System.out.println("El Area del cuadrado es: " + area);
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Ingresa la longitud del lado: ");
        lado = Shape.leer.nextDouble();
        double perimetro = 4 * lado;
        System.out.println("El perimetro del cuadrado es: " + perimetro);
    }
}
