package SistemaDeArchivos;

import java.io.*;
import java.util.*;

public class C10_LeerCSV {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(
                new FileReader("estudiantes.csv"))) {

            String linea;
            boolean esPrimeraLinea = true;
            double sumaNotas = 0;
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");

                if (esPrimeraLinea) {      // saltar encabezado
                    esPrimeraLinea = false;
                    continue;
                }
                System.out.printf("Estudiante: %-15s | Nota: %s%n",
                    campos[1], campos[3]);

                sumaNotas += Double.parseDouble(campos[3]);
                contador++;
            }
            System.out.printf("%nPromedio general: %.2f%n", sumaNotas / contador);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
