package Archivos.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Crear {

    public static void main(String[] args) {

        File archivo = new File("estudiantes.csv");

        if (archivo.exists()) {
            System.out.println("El Archivo Ya Existe");
            return;
        }

        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo))) {

            escribir.write("Nombre,Carrera,Edad");
            escribir.newLine();

            escribir.write("Eliana,Ingenieria Multimedia,16");
            escribir.newLine();

            escribir.write("Julian,Ingenieria Software,18");
            escribir.newLine();

            escribir.write("Dilan,Abogado,20");
            escribir.newLine();

            escribir.write("Kevin,Odontologo,21");
            escribir.newLine();
            escribir.close();

            System.out.println("Archivo Creado");

        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}