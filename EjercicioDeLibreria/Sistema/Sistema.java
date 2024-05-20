package Sistema;

import Usuarios.utils.Rol;
import Usuarios.Usuario;
import Usuarios.serializers.UsuarioSerializer;
import Usuarios.serializers.UsuarioDeserializer;
import libreria.Menu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.LocalDateAdapter;

import java.time.LocalDate;

public class Sistema {
    public static HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<>();

    public static void main(String[] args) {
        // Verificar si el archivo usuarios.json existe y crearlo si no existe
        String filePath = "usuarios.json";
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("El archivo usuarios.json se ha creado correctamente.");
                } else {
                    System.out.println("No se pudo crear el archivo usuarios.json.");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo usuarios.json: " + e.getMessage());
            }
        }

        // Crear un GsonBuilder y registrar el adaptador LocalDateAdapter
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();

        // Deserializar los datos de los usuarios al iniciar la aplicación
        UsuarioDeserializer.deserialize();

        // Crear el menú y manejar la lógica de inicio de sesión
        Menu menu = new Menu();
        menu.inicioSesion();

        // Serializar los datos de los usuarios al finalizar la aplicación
        UsuarioSerializer.serialize();
    }
}



















//        Estudiante estudiante = new Estudiante("1", "Juan", "4423290132");
//        Estudiante estudiante2 = new Estudiante("2", "Pedrito", "432132");
//
//        Trabajador trabajador = new Trabajador("T1", "Lalo", "4423321312");
//        Trabajador trabajador2 = new Trabajador("T2", "Milka", "4321323212");
//
//        HashMap<String, ArrayList<?>> data = new HashMap<>();
//
//        ArrayList<Trabajador> trabajadores = new ArrayList<>();
//
//        trabajadores.add(trabajador);
//        trabajadores.add(trabajador2);
//
//        ArrayList<Estudiante> estudiantes = new ArrayList<>();
//
//        estudiantes.add(estudiante);
//        estudiantes.add(estudiante2);
//
//        data.put("trabajadores", trabajadores);
//        data.put("estudiantes", estudiantes);
//
//        Gson json = new GsonBuilder().setPrettyPrinting().create();
//
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("data.json"));
//            json.toJson(data, writer);
//            writer.close();
//        } catch (IOException e) {
//            System.out.println(e);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//}


//---------------------------------------------------------------------------------------------------------------
// Tema del Martes - Streams


//        try{
//            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
//            writer.write(estudiante.getId());
//            writer.newLine();
//            writer.write( estudiante.getNombre());
//            writer.newLine();
//            writer.write(estudiante.getTelefono());
//            writer.close();
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//    }

// --------------------------------------------------------------------------------------------------------------------


/*
 System.out.println("123");
        System.out.println("123");
        try {
            //Aqui va lo que deseamos probar
            System.out.println(10 / 0);
            String cadena = null;
            System.out.println(cadena.length());

        } catch (ArithmeticException error) {
            //Dentro de aqui manejamos el error
            System.out.println("Aqui hubo un error");

        } catch (NullPointerException error) {
            System.out.println("Hubo error");

        } catch (Exception error) {
            System.out.println("Hubo un error");

        } finally {
        system.out.println("Se ejecuto al final");
        }

        System.out.println("123");
        System.out.println("123");


        -TAREA: INVESTIGAR 10 TIPOS DE EXCEPCIONES CON EJEMPLOS ------------ tarea3/unidad4
        -SUBIR AVANCE DE LA LIBRERIA CON FECHAS -------------- tarea3/unidad4
        -INVESTIGAR QUE ES UNA LIBRERIA, PARA QUE SIRVE, Y COMO SE INSTALAN EN UN PROYECTO DE JAVA ----- Subirlo a Teams

 */