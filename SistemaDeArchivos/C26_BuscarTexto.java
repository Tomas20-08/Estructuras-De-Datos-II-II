package SistemaDeArchivos;

import java.io.*;
import java.util.*;

public class C26_BuscarTexto {

    public static List<String> buscarEnArchivo(String archivo, String buscar)
            throws IOException {
        List<String> resultados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numLinea = 0;
            while ((linea = br.readLine()) != null) {
                numLinea++;
                if (linea.toLowerCase().contains(buscar.toLowerCase())) {
                    resultados.add("Línea " + numLinea + ": " + linea);
                }
            }
        }
        return resultados;
    }

    public static void main(String[] args) throws IOException {
        // Crear archivo de prueba
        try (PrintWriter pw = new PrintWriter("inventario.txt")) {
            pw.println("Manzanas - 50 unidades - $0.50");
            pw.println("Bananos - 30 unidades - $0.25");
            pw.println("Manzanas verdes - 20 unidades - $0.60");
            pw.println("Peras - 40 unidades - $0.80");
            pw.println("Manzanas rojas - 15 unidades - $0.70");
        }

        System.out.println("Buscando 'Manzanas':");
        List<String> res = buscarEnArchivo("inventario.txt", "Manzanas");
        if (res.isEmpty()) System.out.println("  No encontrado");
        else res.forEach(r -> System.out.println("  " + r));
        System.out.println("Total: " + res.size() + " coincidencias");
    }
}
