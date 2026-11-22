package SistemaDeArchivos;

import java.io.*;

public class C28_MultipleExcepciones {

    public static void procesarArchivo(String ruta) {
        BufferedReader br = null;
        try {
            System.out.println("\nIntentando abrir: " + ruta);
            br = new BufferedReader(new FileReader(ruta));

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("  > " + linea);
            }
            System.out.println("Procesado exitosamente");

        } catch (FileNotFoundException e) {
            System.out.println("ARCHIVO NO ENCONTRADO: " + ruta);
            System.out.println("   Detalle: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("SIN PERMISOS para: " + ruta);
        } catch (IOException e) {
            System.out.println("ERROR DE LECTURA: " + e.getMessage());
        } finally {
            if (br != null) {
                try { br.close(); System.out.println("Stream cerrado"); }
                catch (IOException e) { System.out.println("Error al cerrar"); }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Crear archivo válido
        try (PrintWriter pw = new PrintWriter("valido.txt")) {
            pw.println("Contenido válido"); }

        procesarArchivo("valido.txt");         // funciona
        procesarArchivo("no_existe.txt");      // FileNotFoundException
    }
}
