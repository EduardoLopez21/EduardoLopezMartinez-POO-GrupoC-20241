package Usuarios.Models;

import Usuarios.Cliente;
import Usuarios.Asistente;
import Usuarios.Gerente;

import java.util.ArrayList;

public class UsuarioModel {
    private ArrayList<Cliente> clientes;
    private ArrayList<Asistente> asistentes;
    private ArrayList<Gerente> gerentes;

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Asistente> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(ArrayList<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    public void setGerentes(ArrayList<Gerente> gerentes) {
        this.gerentes = gerentes;
    }
}
