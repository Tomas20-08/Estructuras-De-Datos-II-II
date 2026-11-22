package SistemaDeArchivos;

import java.io.*;

public class C22_CopiarArchivo {
    public static void main(String[] args) {
        String origen = "notas.txt";
        String destino = "notas_backup.txt";
        int lineasCopiadas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(origen));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
                lineasCopiadas++;
            }
            System.out.println("Copia exitosa");
            System.out.println("Origen: " + origen);
            System.out.println("Destino: " + destino);
            System.out.println("Líneas copiadas: " + lineasCopiadas);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
