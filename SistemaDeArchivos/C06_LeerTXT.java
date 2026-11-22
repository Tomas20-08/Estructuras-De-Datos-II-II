package SistemaDeArchivos;

import java.io.*;

public class C06_LeerTXT {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(
                new FileReader("estudiantes.txt"))) {

            String linea;
            int numLinea = 1;

            while ((linea = br.readLine()) != null) {
                System.out.println("Línea " + numLinea++ + ": " + linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }
    }
}
