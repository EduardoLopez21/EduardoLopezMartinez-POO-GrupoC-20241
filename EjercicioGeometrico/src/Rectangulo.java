class Rectangulo implements Shape {
    double base;
    double altura;

    @Override
    public void calcularArea() {
        System.out.println("Ingresa la Base: ");
        base = Shape.leer.nextDouble();
        System.out.println("Ingresa la Altura: ");
        altura = Shape.leer.nextDouble();
        double area = base * altura;
        System.out.println("El Area del Rectangulo es: " + area);
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Ingresa la Base: ");
        base = Shape.leer.nextDouble();
        System.out.println("Ingresa la Altura: ");
        altura = Shape.leer.nextDouble();
        double perimetro = (2 * altura) + (2 * base);
        System.out.println("El perimetro del Rectangulo es: " + perimetro);
    }
}