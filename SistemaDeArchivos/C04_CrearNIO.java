package SistemaDeArchivos;

import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class C04_CrearNIO {
    public static void main(String[] args) throws Exception {

        Path ruta = Paths.get("datos.txt");

        // Escribir lista de líneas de un golpe
        List<String> lineas = Arrays.asList(
            "Nombre: Carlos",
            "Edad: 22",
            "Ciudad: Bogotá"
        );

        Files.write(ruta, lineas,
            StandardOpenOption.CREATE,
            StandardOpenOption.WRITE);

        // Leer todo de un golpe
        String contenido = new String(Files.readAllBytes(ruta));
        System.out.println("Contenido:\n" + contenido);
    }
}
