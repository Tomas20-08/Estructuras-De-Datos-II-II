package SistemaDeArchivos;

import java.io.*;

public class C09_EscribirCSV {
    public static void main(String[] args) {

        String[][] datos = {
            {"ID", "Nombre", "Edad", "Nota"},  // encabezado
            {"1", "Ana Gómez", "21", "9.5"},
            {"2", "Carlos Ruiz", "22", "8.0"},
            {"3", "María López", "20", "10.0"},
            {"4", "Pedro Díaz", "23", "7.5"}
        };

        try (PrintWriter pw = new PrintWriter(new FileWriter("estudiantes.csv"))) {

            for (String[] fila : datos) {
                pw.println(String.join(",", fila));
            }
            System.out.println("CSV creado con " + (datos.length - 1) + " registros");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
