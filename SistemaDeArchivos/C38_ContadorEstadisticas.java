package SistemaDeArchivos;

import java.io.*;
public class C38_ContadorEstadisticas {
    public static void main(String[] args) throws IOException {
        String ruta = "mi_archivo.txt";
        int lineas=0, palabras=0, chars=0;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas++;
                chars += linea.length();
                if (!linea.trim().isEmpty())
                    palabras += linea.trim().split("\\s+").length;
            }
        }
        System.out.println("Líneas: " + lineas);
        System.out.println("Palabras: " + palabras);
        System.out.println("Chars: " + chars);
        System.out.println("Bytes: " + new File(ruta).length());
    }
}
