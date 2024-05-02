class Triangulo implements Shape {
    double base;
    double altura;

    @Override
    public void calcularArea() {
        System.out.println("Ingresa la Base: ");
        base = Shape.leer.nextDouble();
        System.out.println("Ingresa la Altura: ");
        altura = Shape.leer.nextDouble();

        double area = (base * altura) / 2;
        System.out.println("El Area del triangulo es: " + area);
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Ingresa el primer Lado: ");
        double lado1 = Shape.leer.nextDouble();
        System.out.println("Ingresa el Segundo Lado: ");
        double lado2 = Shape.leer.nextDouble();
        System.out.println("Ingresa el Tercer Lado: ");
        double lado3 = Shape.leer.nextDouble();

        double perimetro = lado1 + lado2 + lado3;
        System.out.println("El perimetro del triangulo es: " + perimetro);
    }
}