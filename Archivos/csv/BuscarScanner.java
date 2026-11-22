package Archivos.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BuscarScanner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese Nombre: ");
        String busca = scanner.nextLine().trim();
        boolean encontrado = false;

        try (BufferedReader leer = new BufferedReader(new FileReader("estudiantes.csv"))) {

            String linea;
            leer.readLine(); // saltar la cabecera

            while ((linea = leer.readLine()) != null) {

                String[] datos = linea.split(",");

                // Saltar lineas vacias o incompletas
                if (datos.length < 3) {
                    continue;
                }

                String nombre = datos[0].trim();

                if (nombre.equalsIgnoreCase(busca)) {
                    System.out.println("Nombre: " + datos[0]);
                    System.out.println("Carrera: " + datos[1]);
                    System.out.println("Edad: " + datos[2]);

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Estudiante No Encontrado");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}