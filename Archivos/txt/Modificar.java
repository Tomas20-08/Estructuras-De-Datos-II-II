package Archivos.txt;

import java.io.*;
import java.util.ArrayList;

public class Modificar {
    public static void main(String[] args) {

        String archivo = "estudiantes.txt";
        int modificar = 2;              // número de línea a modificar (empieza en 1)
        String nuevo = "Yenifer Romero";

        try {
            ArrayList<String> lineas = new ArrayList<>();

            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = leer.readLine()) != null) {
                lineas.add(linea);
            }
            leer.close();

            if (modificar > 0 && modificar <= lineas.size()) {

                lineas.set(modificar - 1, nuevo);

                BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));

                for (String texto : lineas) {
                    escribir.write(texto);
                    escribir.newLine();
                }
                escribir.close();

                System.out.println("Archivo Modificado");

            } else {
                System.out.println("El Archivo No Se Pudo Modificar");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}