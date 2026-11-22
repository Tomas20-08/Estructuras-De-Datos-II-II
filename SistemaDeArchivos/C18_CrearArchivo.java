package SistemaDeArchivos;

import java.io.File;
import java.io.IOException;

public class C18_CrearArchivo {
    public static void main(String[] args) {
        File archivo = new File("primer_archivo.txt");
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
                System.out.println("Ruta: " + archivo.getAbsolutePath());
                System.out.println("Tamaño: " + archivo.length() + " bytes");
            } else {
                System.out.println("El archivo ya existía");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
