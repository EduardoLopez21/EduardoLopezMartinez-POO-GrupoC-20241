package Usuarios.serializers;

import Sistema.Sistema;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import Usuarios.Models.UsuarioModel;
import Usuarios.utils.Rol;
import Usuarios.Usuario;
import Usuarios.Cliente;
import Usuarios.Asistente;
import Usuarios.Gerente;
import utils.LocalDateAdapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class UsuarioDeserializer {
    public static void deserialize() {
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.json"))) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .create();
            UsuarioModel usuarioModel = gson.fromJson(reader, UsuarioModel.class);

            if (usuarioModel != null) {
                // Deserializar y agregar clientes
                Sistema.usuarios.put(Rol.CLIENTE, new ArrayList<>(usuarioModel.getClientes()));

                // Deserializar y agregar asistentes
                Sistema.usuarios.put(Rol.ASISTENTE, new ArrayList<>(usuarioModel.getAsistentes()));

                // Deserializar y agregar gerentes
                Sistema.usuarios.put(Rol.GERENTE, new ArrayList<>(usuarioModel.getGerentes()));
            }
        } catch (IOException | JsonParseException e) {
            System.out.println(e);
        }
    }
}

