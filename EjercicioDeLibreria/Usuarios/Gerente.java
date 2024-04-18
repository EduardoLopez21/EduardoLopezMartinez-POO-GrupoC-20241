package Usuarios;

import Usuarios.utils.Rol;

public class Gerente extends Usuario{
    private double sueldo;
    private String rfc;
    private String INE;
    
    public Gerente(String nombre, String apellido, String telefono, double sueldo, String rfc, String INE, String nombreUsuario, String contraseña) {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario, contraseña);
        this.sueldo = sueldo;
        this.INE = INE;
        this.rfc = rfc;
    }

    @Override

    public String toString() { //Aqui  lo estamos sobre escribiendo gracias al override y con eso el programa toma primero en cuenta la clase hija que el metodo de la clase padre
        return String.format("%s, Sueldo: %f, RFC: %s, INE: %s",
         super.toString(), this.sueldo, this.rfc, this.INE);
    }


}
