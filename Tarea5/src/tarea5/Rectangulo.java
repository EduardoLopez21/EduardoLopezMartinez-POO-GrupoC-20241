package tarea5;

public class Rectangulo {

    String Area(int largo, int ancho){
        int suma = largo * ancho;
        return String.format("El area es: %d", suma);
    }
    String Perimetro(int largo, int ancho){
        int suma = 2*largo + 2*ancho;
        return String.format("El perimetro es: %d", suma);
    }
    String Area(double largo, double ancho){
        double suma = largo * ancho;
        return String.format("El area (double) es: %f", suma);
    }
    String Perimetro(double largo, double ancho){
        double suma = 2*largo + 2*ancho;
        return String.format("El perimetro (double) es: %f", suma);
    }
}
