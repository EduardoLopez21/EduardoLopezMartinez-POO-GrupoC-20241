package tarea3;

public class Rectangulo {

    int base;
    int altura;
    int resultado;

    public Rectangulo(int ancho, int largo) {
        this.base = ancho;
        this.altura = largo;
        resultado = ancho * largo;
    }

    void getRectangleInfo() {
        String data = String.format("Base: %d || Altura: %d || Resultado: %dm2", base, altura, resultado);
        System.out.println(data);
    }
}
