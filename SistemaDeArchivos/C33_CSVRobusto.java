package SistemaDeArchivos;

import java.io.*;
import java.util.*;

public class C33_CSVRobusto {
    public static void main(String[] args) throws IOException {
        // CSV con datos inconsistentes
        String csvConErrores = "nombre,edad,nota\n" +
            "Ana,21,9.5\n" +
            "Carlos,VEINTIDOS,8.0\n" +   // edad inválida
            "María,20,DIEZ\n" +           // nota inválida
            "Pedro,23,7.5\n" +
            "Juan,,6.0";                   // edad vacía

        try (PrintWriter pw = new PrintWriter("datos_sucios.csv")) {
            pw.print(csvConErrores); }

        // Procesar con manejo de errores
        int ok = 0, errores = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("datos_sucios.csv"))) {
            br.readLine(); // cabecera
            String linea;
            int numFila = 1;

            while ((linea = br.readLine()) != null) {
                numFila++;
                String[] campos = linea.split(",");
                try {
                    String nombre = campos[0];
                    int edad = Integer.parseInt(campos[1].trim());
                    double nota = Double.parseDouble(campos[2].trim());
                    System.out.printf("Fila %d: %-8s edad=%d nota=%.1f%n",
                        numFila, nombre, edad, nota);
                    ok++;
                } catch (NumberFormatException e) {
                    System.out.printf("Fila %d: ERROR de formato -> %s%n",
                        numFila, e.getMessage());
                    errores++;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.printf("Fila %d: Faltan campos%n", numFila);
                    errores++;
                }
            }
        }
        System.out.printf("%nProcesadas: %d OK | %d errores%n", ok, errores);
    }
}
