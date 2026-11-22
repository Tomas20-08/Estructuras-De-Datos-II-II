package Archivos.txt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BuscarScanner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese El Nombre: ");

        String nombre = scanner.nextLine().trim();
        boolean encontrado = false;

        try (BufferedReader leer = new BufferedReader(new FileReader("estudiantes.txt"))) {

            String linea;

            while ((linea = leer.readLine()) != null) {
                if (linea.trim().equalsIgnoreCase(nombre)) {
                    System.out.println("Estudiante Encontrado!!");
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