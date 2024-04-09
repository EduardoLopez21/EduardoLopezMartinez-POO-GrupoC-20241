package Usuarios;

import utils.Rol;

public class Gerente extends Usuario{
    private double sueldo;
    private String rfc, ine;
    
    public Gerente(String nombre, String apellido, String telefono, double sueldo, String rfc, String ine) {
        super(nombre, apellido, telefono, Rol.GERENTE);
        this.sueldo = sueldo;
        this.ine = ine;
        this.rfc = rfc;
    }

    @Override

    public String toString() { //Aqui  lo estamos sobreescribiendo gracias al override y con eso el programa toma primero en cuenta la clase hija que el metodo de la clase padre
        return String.format("%s, Sueldo: %f, RFC: %s, INE: %s",
         super.toString(), this.sueldo, this.rfc, this.ine);
    }

}
