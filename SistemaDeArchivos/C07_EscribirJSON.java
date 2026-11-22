package SistemaDeArchivos;

import org.json.JSONObject;
import org.json.JSONArray;
import java.io.*;

public class C07_EscribirJSON {
    public static void main(String[] args) throws IOException {

        // Crear el JSON
        JSONObject obj = new JSONObject();
        obj.put("nombre", "Ana Gómez");
        obj.put("edad", 21);
        obj.put("activo", true);

        JSONArray materias = new JSONArray();
        materias.put("Programación");
        materias.put("Base de Datos");
        materias.put("Redes");
        obj.put("materias", materias);

        // Guardar en archivo
        try (FileWriter fw = new FileWriter("estudiante.json")) {
            fw.write(obj.toString(4));  // 4 = espacios de indentación
        }
        System.out.println("JSON guardado:\n" + obj.toString(4));
    }
}
