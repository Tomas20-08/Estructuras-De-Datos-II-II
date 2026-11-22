package SistemaDeArchivos;

import java.io.*;

public class C32_CopiaBindaria {
    public static long copiarBinario(String origen, String destino) throws IOException {
        long bytesCopidos = 0;
        byte[] buffer = new byte[1024]; // buffer de 1KB
        int bytesLeidos;

        try (FileInputStream fis = new FileInputStream(origen);
             FileOutputStream fos = new FileOutputStream(destino)) {

            while ((bytesLeidos = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesLeidos);
                bytesCopidos += bytesLeidos;
            }
        }
        return bytesCopidos;
    }

    public static void main(String[] args) throws IOException {
        // Crear archivo binario de prueba
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("binario.dat"))) {
            for (int i = 0; i < 100; i++) {
                dos.writeInt(i);
                dos.writeDouble(i * 1.5);
            }
        }

        long copied = copiarBinario("binario.dat", "binario_copia.dat");

        File orig = new File("binario.dat");
        File copia = new File("binario_copia.dat");

        System.out.printf("Original:  %d bytes%n", orig.length());
        System.out.printf("Copia:     %d bytes%n", copia.length());
        System.out.printf("Copiados:  %d bytes%n", copied);
        System.out.println("¿Son iguales?: " + (orig.length() == copia.length()));
    }
}
