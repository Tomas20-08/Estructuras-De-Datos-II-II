package Archivos.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Modificar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese Nombre: ");
        String busca = scanner.nextLine();
        System.out.println("Ingrese la nueva Edad: ");
        int nedad = scanner.nextInt();
        boolean encontrar = false;

        try {

            BufferedReader leer = new BufferedReader(new FileReader("estudiantes.csv"));
            String linea;

            String nuevo = "";

            String encabezado = leer.readLine();
            nuevo = encabezado + "\n";

            while ((linea = leer.readLine()) != null) {

                String[] datos = linea.split(",");
                String nombre = datos[0];

                if (nombre.equalsIgnoreCase(busca)) {
                    datos[2] = String.valueOf(nedad);
                    encontrar = true;
                }

                nuevo = nuevo + datos[0] + "," + datos[1] + "," + datos[2] + "\n";
            }

            leer.close();

            if (encontrar) {

                BufferedWriter escribir = new BufferedWriter(new FileWriter("estudiantes.csv"));
                escribir.write(nuevo);
                escribir.close();

                System.out.println("Estudiante Modificado");
            } else {

                System.out.println("Estudiante No Pudo Ser Modificado");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}