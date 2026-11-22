package SistemaDeArchivos;

import org.json.*;
import java.nio.file.*;

public class C08_LeerJSON {
    public static void main(String[] args) throws Exception {

        // Leer todo el contenido del archivo
        String contenido = new String(Files.readAllBytes(Paths.get("estudiante.json")));

        // Parsear
        JSONObject obj = new JSONObject(contenido);

        // Acceder a los datos
        System.out.println("Nombre: " + obj.getString("nombre"));
        System.out.println("Edad: " + obj.getInt("edad"));
        System.out.println("Activo: " + obj.getBoolean("activo"));

        JSONArray materias = obj.getJSONArray("materias");
        System.out.print("Materias: ");
        for (int i = 0; i < materias.length(); i++) {
            System.out.print(materias.getString(i) + " | ");
        }
    }
}
