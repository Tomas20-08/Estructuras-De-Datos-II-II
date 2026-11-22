package Archivos.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Agregar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine().trim().replace(",", " ");

        System.out.println("Ingrese la carrera: ");
        String carrera = scanner.nextLine().trim().replace(",", " ");

        int edad;
        try {
            System.out.println("Ingrese la edad: ");
            edad = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("La edad debe ser un numero entero.");
            return;
        }

        try (BufferedWriter escribir = new BufferedWriter(new FileWriter("estudiantes.csv", true))) {

            escribir.write(nombre + "," + carrera + "," + edad);
            escribir.newLine();

            System.out.println("Estudiante Agregado Correctamente");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}