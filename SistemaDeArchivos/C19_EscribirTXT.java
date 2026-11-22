package SistemaDeArchivos;

import java.io.*;

public class C19_EscribirTXT {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("notas.txt"))) {
            bw.write("=== NOTAS DEL CURSO ===");
            bw.newLine();
            bw.write("Programación: 9.5");
            bw.newLine();
            bw.write("Base de Datos: 8.0");
            bw.newLine();
            bw.write("Redes: 7.5");
            System.out.println("Archivo escrito exitosamente");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
