package SistemaDeArchivos;

import java.io.*;

public class C23_EstadisticasArchivo {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("notas.txt"))) {
            String linea;
            int totalLineas = 0, totalPalabras = 0, totalChars = 0;

            while ((linea = br.readLine()) != null) {
                totalLineas++;
                totalChars += linea.length();
                if (!linea.trim().isEmpty()) {
                    String[] palabras = linea.trim().split("\s+");
                    totalPalabras += palabras.length;
                }
            }

            System.out.println("ESTADÍSTICAS DEL ARCHIVO");
            System.out.println("============================");
            System.out.println("  Líneas:    " + totalLineas);
            System.out.println("  Palabras:  " + totalPalabras);
            System.out.println("  Caracteres:" + totalChars);

        } catch (IOException e) { e.printStackTrace(); }
    }
}
