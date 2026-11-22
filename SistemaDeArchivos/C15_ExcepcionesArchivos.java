package SistemaDeArchivos;

import java.io.*;
import java.nio.file.*;

public class C15_ExcepcionesArchivos {

    /**
     * Lectura segura con manejo completo de excepciones
     */
    public static String leerArchivoSeguro(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            StringBuilder sb = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append("\n");
            }
            return sb.toString();

        } catch (FileNotFoundException e) {
            // Caso específico: archivo no existe
            System.err.println("Archivo no encontrado: " + ruta);
            System.err.println("   Verifica la ruta: " + new File(ruta).getAbsolutePath());
            return null;

        } catch (SecurityException e) {
            // Sin permisos de lectura
            System.err.println("Sin permisos para leer: " + ruta);
            return null;

        } catch (IOException e) {
            // Error genérico de I/O
            System.err.println("Error de I/O: " + e.getMessage());
            return null;
        }
    }

    /**
     * Escritura segura con try-with-resources
     * El recurso se cierra AUTOMÁTICAMENTE, incluso si hay excepción
     */
    public static boolean escribirSeguro(String ruta, String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {

            // Verificar que el directorio padre exista
            File padre = new File(ruta).getParentFile();
            if (padre != null && !padre.exists()) {
                padre.mkdirs();  // crear directorios si no existen
            }

            bw.write(contenido);
            return true;

        } catch (IOException e) {
            System.err.println("No se pudo escribir: " + e.getMessage());
            return false;
        }
    }

    /**
     * Verificar existencia antes de operar
     * (Patrón defensivo)
     */
    public static void procesarConValidacion(String ruta) {
        File archivo = new File(ruta);

        // Validaciones previas
        if (!archivo.exists()) {
            System.out.println("El archivo no existe");
            return;
        }
        if (!archivo.canRead()) {
            System.out.println("Sin permisos de lectura");
            return;
        }
        if (archivo.length() == 0) {
            System.out.println("El archivo está vacío");
            return;
        }

        // Si pasó todas las validaciones, procesar
        String contenido = leerArchivoSeguro(ruta);
        System.out.println("Contenido:\n" + contenido);
    }

    public static void main(String[] args) {
        // Test 1: archivo inexistente
        leerArchivoSeguro("no_existe.txt");

        // Test 2: escritura y lectura exitosa
        escribirSeguro("prueba.txt", "Hola desde Java con excepciones");
        procesarConValidacion("prueba.txt");

        // Test 3: archivo vacío
        escribirSeguro("vacio.txt", "");
        procesarConValidacion("vacio.txt");
    }
}
