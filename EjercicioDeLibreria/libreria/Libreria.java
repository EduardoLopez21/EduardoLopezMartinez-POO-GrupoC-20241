package libreria;

import Usuarios.Usuario;

import java.util.ArrayList;

public class Libreria {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Usuario verificarInicioSesion(String nombreUsuario, String contraseña){
        for (Usuario usuarios : usuarios){
            if (usuarios.getNombreUsuario().equals(nombreUsuario)){
                if (usuarios.getContraseña().equals(contraseña)){
                    return usuarios;
                }
                return null;
            }
        }
        return  null;
    }

}
