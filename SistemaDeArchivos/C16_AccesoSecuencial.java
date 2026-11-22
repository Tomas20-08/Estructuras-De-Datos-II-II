package SistemaDeArchivos;

import java.io.*;
import java.util.Scanner;

public class C16_AccesoSecuencial {
    public static void main(String[] args) throws IOException {

        // Escribir secuencialmente
        try (PrintWriter pw = new PrintWriter(new FileWriter("numeros.txt"))) {
            for (int i = 1; i <= 10; i++) {
                pw.println("Número " + i + " -> valor " + (i * i));
            }
        }

        // Leer secuencialmente hasta encontrar un valor
        try (Scanner sc = new Scanner(new File("numeros.txt"))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                System.out.println(linea);
                if (linea.contains("Número 5")) {
                    System.out.println("^^^ ¡Encontrado el número 5! ^^^");
                    break; // podemos parar la lectura cuando queramos
                }
            }
        }
    }
}
