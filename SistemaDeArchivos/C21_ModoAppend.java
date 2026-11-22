package SistemaDeArchivos;

import java.io.*;

public class C21_ModoAppend {
    public static void main(String[] args) {
        // Crear archivo inicial
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt"))) {
            bw.write("[2024-01-01] Sistema iniciado");
        } catch (IOException e) { e.printStackTrace(); }

        // Agregar más entradas al final
        String[] nuevasEntradas = {
            "[2024-01-02] Usuario Ana ingresó",
            "[2024-01-02] Se procesaron 150 registros",
            "[2024-01-03] Sistema cerrado"
        };

        for (String entrada : nuevasEntradas) {
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter("log.txt", true))) { // true = append
                bw.newLine();
                bw.write(entrada);
                System.out.println("Agregado: " + entrada);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
