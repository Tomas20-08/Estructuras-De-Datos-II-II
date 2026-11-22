package SistemaDeArchivos;

import java.io.*;
public class C42_CombinarArchivos {
    static void combinar(String[] fuentes, String destino) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {
            for (String src : fuentes) {
                bw.write("=== ARCHIVO: " + src + " ==="); bw.newLine();
                try (BufferedReader br = new BufferedReader(new FileReader(src))) {
                    String l;
                    while ((l=br.readLine())!=null){ bw.write(l); bw.newLine(); }
                } catch (FileNotFoundException e) {
                    bw.write("[ARCHIVO NO ENCONTRADO]"); bw.newLine();
                }
                bw.newLine();
            }
        }
        System.out.println("Archivos combinados en " + destino);
    }
    public static void main(String[] a) throws IOException {
        combinar(new String[]{"notas.txt","log.txt","inexistente.txt"}, "resultado.txt");
    }
}
