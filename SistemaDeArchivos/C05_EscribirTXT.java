package SistemaDeArchivos;

import java.io.*;

public class C05_EscribirTXT {
    public static void main(String[] args) {

        // BufferedWriter para mayor eficiencia
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("estudiantes.txt"))) {

            bw.write("=== LISTA DE ESTUDIANTES ===");
            bw.newLine();                   // <- salto de línea portable
            bw.write("Ana Gómez - Nota: 9.5");
            bw.newLine();
            bw.write("Carlos Ruiz - Nota: 8.0");
            bw.newLine();
            bw.write("María López - Nota: 10.0");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // MODO APPEND: agregar sin borrar el contenido anterior
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("estudiantes.txt", true))) {
            bw.newLine();
            bw.write("Pedro Díaz - Nota: 7.5");  // se agrega al final
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
