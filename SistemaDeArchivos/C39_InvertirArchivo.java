package SistemaDeArchivos;

import java.io.*;
import java.util.*;
public class C39_InvertirArchivo {
    public static void main(String[] args) throws IOException {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("entrada.txt")))
        { String l; while ((l=br.readLine())!=null) lineas.add(l); }
        Collections.reverse(lineas);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("invertido.txt")))
        { for (String l : lineas) { bw.write(l); bw.newLine(); } }
        System.out.println("Archivo invertido guardado");
    }
}
