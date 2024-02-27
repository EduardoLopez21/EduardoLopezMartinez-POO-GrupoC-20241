package tarea5;

public class Empleado {

    String Sueldo(int sueldobase) {
        
        return String.format("El sueldo base es: %d", sueldobase);
    }

    String Sueldo(double sueldobase, double bonificacion) {
    return String.format("|| El sueldo base es: %f  ||   La bonificacion es: %f", sueldobase, bonificacion);
    }

    String Sueldo(int sueldobase, double bonificacion, int horas) {
        int horasExtras = horas*20;
        String customString = "El sueldo base es: " + sueldobase + "   || La bonificacion es: " + bonificacion + "  || Las horas extras son: " + horasExtras;
        return String.format(customString, sueldobase, bonificacion, horasExtras);
    }

}
