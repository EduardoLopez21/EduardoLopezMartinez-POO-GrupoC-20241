package tarea3;

public class Rectangulo {

    int base;
    int altura;
    int area;
    int perimetro;

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.area = altura;
        area = base * altura;
        perimetro = 2 * base + 2* altura;
    }

    void getRectangleInfo() {
        String data = String.format("Base: %d || Altura: %d || Area: %dm2 || Perimetro: %d", base, altura, area, perimetro);
        System.out.println(data);
    }
}
