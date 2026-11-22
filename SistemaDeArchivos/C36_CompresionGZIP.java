package SistemaDeArchivos;

import java.io.*;
import java.util.zip.*;

public class C36_CompresionGZIP {
    public static void comprimir(String entrada, String salida) throws IOException {
        try (FileInputStream fis = new FileInputStream(entrada);
             GZIPOutputStream gzos = new GZIPOutputStream(
                     new FileOutputStream(salida))) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) gzos.write(buffer, 0, len);
        }
    }

    public static void descomprimir(String comprimido, String destino) throws IOException {
        try (GZIPInputStream gzis = new GZIPInputStream(
                     new FileInputStream(comprimido));
             FileOutputStream fos = new FileOutputStream(destino)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzis.read(buffer)) != -1) fos.write(buffer, 0, len);
        }
    }

    public static void main(String[] args) throws IOException {
        // Crear archivo de texto grande
        try (PrintWriter pw = new PrintWriter("grande.txt")) {
            for (int i = 1; i <= 500; i++)
                pw.println("Registro número " + i + " con datos de relleno xxxxxxxxxx");
        }

        comprimir("grande.txt", "grande.txt.gz");
        descomprimir("grande.txt.gz", "grande_restaurado.txt");

        long orig = new File("grande.txt").length();
        long comp = new File("grande.txt.gz").length();
        System.out.printf("Original:     %,d bytes%n", orig);
        System.out.printf("Comprimido:   %,d bytes%n", comp);
        System.out.printf("Ahorro:       %.1f%%%n", (1.0-comp/(double)orig)*100);
        System.out.println("Descompresión: OK");
    }
}
