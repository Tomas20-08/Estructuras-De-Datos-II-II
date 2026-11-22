package SistemaDeArchivos;

import java.io.*;

public class C31_RegistroFijo {
    static final int TAM = 4 + 40 + 8; // int + 20chars(2bytes) + double = 52 bytes

    static void escribirRegistro(RandomAccessFile raf, int pos,
            int id, String nombre, double nota) throws IOException {
        raf.seek((long) pos * TAM);
        raf.writeInt(id);
        // Escribir nombre en exactamente 20 chars
        StringBuilder sb = new StringBuilder(nombre);
        while (sb.length() < 20) sb.append(' ');
        raf.writeChars(sb.substring(0, 20));  // 20 chars × 2 bytes = 40 bytes
        raf.writeDouble(nota);
    }

    static void leerRegistro(RandomAccessFile raf, int pos) throws IOException {
        raf.seek((long) pos * TAM);
        int id = raf.readInt();
        StringBuilder nombre = new StringBuilder();
        for (int i = 0; i < 20; i++) nombre.append(raf.readChar());
        double nota = raf.readDouble();
        System.out.printf("  [%d] %-20s -> %.1f%n", id, nombre.toString().trim(), nota);
    }

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile("registros.dat", "rw")) {
            escribirRegistro(raf, 0, 1, "Ana Gómez", 9.5);
            escribirRegistro(raf, 1, 2, "Carlos Ruiz", 8.0);
            escribirRegistro(raf, 2, 3, "María López", 10.0);

            System.out.println("Todos los registros:");
            for (int i = 0; i < 3; i++) leerRegistro(raf, i);

            // Modificar directamente el registro 1
            escribirRegistro(raf, 1, 2, "Carlos Ruiz", 9.9);
            System.out.println("\nRegistro 1 actualizado:");
            leerRegistro(raf, 1);
        }
    }
}
