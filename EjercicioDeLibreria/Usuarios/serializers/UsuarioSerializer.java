package Usuarios.serializers;

import Sistema.Sistema;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Usuarios.Models.UsuarioModel;
import Usuarios.utils.Rol;
import Usuarios.Cliente;
import Usuarios.Asistente;
import Usuarios.Gerente;
import utils.LocalDateAdapter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class UsuarioSerializer {
    public static void serialize() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.json"))) {
            UsuarioModel usuarioModel = new UsuarioModel();
            usuarioModel.setClientes(castList(Sistema.usuarios.get(Rol.CLIENTE), Cliente.class));
            usuarioModel.setAsistentes(castList(Sistema.usuarios.get(Rol.ASISTENTE), Asistente.class));
            usuarioModel.setGerentes(castList(Sistema.usuarios.get(Rol.GERENTE), Gerente.class));
            gson.toJson(usuarioModel, writer);
            System.out.println("Usuarios guardados correctamente en usuarios.json");
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    private static <T> ArrayList<T> castList(Object obj, Class<T> clazz) {
        ArrayList<T> result = new ArrayList<>();
        if (obj instanceof ArrayList<?>) {
            ArrayList<?> list = (ArrayList<?>) obj;
            for (Object o : list) {
                if (clazz.isInstance(o)) {
                    result.add(clazz.cast(o));
                }
            }
        }
        return result;
    }
}

