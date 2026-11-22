package SistemaDeArchivos;

import java.io.*;
import java.util.*;

public class C25_ArrayListCSV {

    static class Estudiante {
        String nombre; double nota; int edad;
        Estudiante(String n, double nota, int e){ nombre=n; this.nota=nota; edad=e; }
        String toCSV() { return nombre + "," + nota + "," + edad; }
        static Estudiante fromCSV(String linea) {
            String[] p = linea.split(",");
            return new Estudiante(p[0], Double.parseDouble(p[1]), Integer.parseInt(p[2]));
        }
        public String toString() { return nombre + " (nota:" + nota + ", edad:" + edad + ")"; }
    }

    public static void main(String[] args) throws IOException {
        List<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante("Ana", 9.5, 21));
        lista.add(new Estudiante("Carlos", 8.0, 22));
        lista.add(new Estudiante("María", 10.0, 20));

        // Guardar en CSV
        try (PrintWriter pw = new PrintWriter(new FileWriter("clase.csv"))) {
            pw.println("Nombre,Nota,Edad");
            lista.forEach(e -> pw.println(e.toCSV()));
        }
        System.out.println("Guardados " + lista.size() + " estudiantes");

        // Recuperar del CSV
        List<Estudiante> recuperados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("clase.csv"))) {
            br.readLine(); // saltar cabecera
            String linea;
            while ((linea = br.readLine()) != null)
                recuperados.add(Estudiante.fromCSV(linea));
        }
        System.out.println("Recuperados:");
        recuperados.forEach(e -> System.out.println("  " + e));
    }
}
