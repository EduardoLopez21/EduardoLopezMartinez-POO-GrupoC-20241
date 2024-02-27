package tarea5;

public class CalculadoraImpuestos {

    String calcularImpuestos(int ingresos) {
        double Totaldeingresos = ingresos + 0.15;
        return String.format("Los ingresos son: %f", Totaldeingresos);
    }

    String calcularImpuestos(double ventas, double porcentajeImpuestos) {
        double impuesto;
        impuesto = ventas * (porcentajeImpuestos / 100);
        return String.format("El porcentaje total es: %f", impuesto);
    }

    String calcularImpuestos(double exencion, double porcentajeImpuestos, double dividendos) {

        double impuestoTotal = dividendos * (porcentajeImpuestos / 100);
        if (impuestoTotal < exencion) {
            return "No se puede";
        } else {
            impuestoTotal = impuestoTotal - exencion;
            return String.format("El impuesto total es: %f", impuestoTotal);
        }
    }

}
