package SistemaDeArchivos;

import java.io.*;

public class C20_LeerLineas {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("notas.txt"))) {
            String linea;
            int num = 1;
            System.out.println("Contenido del archivo:");
            System.out.println("--------------------------");
            while ((linea = br.readLine()) != null) {
                System.out.printf("%2d | %s%n", num++, linea);
            }
            System.out.println("--------------------------");
            System.out.println("Total: " + (num-1) + " líneas");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
