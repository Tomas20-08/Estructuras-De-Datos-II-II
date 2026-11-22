package SistemaDeArchivos;

import java.io.*;
import java.util.*;
public class C40_AgendaCSV {
    static final String CSV = "contactos.csv";
    static class Contacto {
        String nombre, tel, email;
        Contacto(String n, String t, String e){ nombre=n; tel=t; email=e; }
        String toCSV(){ return nombre+","+tel+","+email; }
    }
    static void guardar(Contacto c) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV, true)))
        { pw.println(c.toCSV()); }
    }
    static void listar() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV))) {
            String l; while ((l=br.readLine())!=null) {
                String[] p=l.split(",");
                System.out.printf("%-15s %-15s %s%n", p[0], p[1], p[2]);
            }
        }
    }
    public static void main(String[] a) throws IOException {
        guardar(new Contacto("Ana","300-111","ana@mail.com"));
        guardar(new Contacto("Pedro","315-222","pedro@mail.com"));
        listar();
    }
}
