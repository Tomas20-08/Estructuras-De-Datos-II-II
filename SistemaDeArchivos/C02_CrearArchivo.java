package SistemaDeArchivos;

import java.io.File;
import java.io.IOException;

public class C02_CrearArchivo {
    public static void main(String[] args) {

        // Paso 1: Crear objeto File (aún no existe en disco)
        File archivo = new File("mi_archivo.txt");

        try {
            // Paso 2: Crear físicamente en disco
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
                System.out.println("Ruta: " + archivo.getAbsolutePath());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
