package SistemaDeArchivos;

import java.io.FileWriter;
import java.io.IOException;

public class C03_EscribirArchivo {
    public static void main(String[] args) {

        // FileWriter crea el archivo si no existe
        // true = modo append (agregar al final)
        // false (default) = sobreescribir
        try (FileWriter fw = new FileWriter("saludo.txt")) {

            fw.write("¡Hola Mundo desde Java!\n");
            fw.write("Línea número dos.\n");
            fw.write("Archivo creado exitosamente.");

            System.out.println("Archivo escrito correctamente");

        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
        // El try-with-resources cierra automáticamente el FileWriter
    }
}
