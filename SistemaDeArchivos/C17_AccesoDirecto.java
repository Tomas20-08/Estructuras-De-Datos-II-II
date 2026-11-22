package SistemaDeArchivos;

import java.io.RandomAccessFile;
import java.nio.*;
import java.nio.channels.FileChannel;

public class C17_AccesoDirecto {

    static final int TAM_REG = 12; // 4 (int) + 8 (double) bytes

    public static void main(String[] args) throws Exception {

        try (RandomAccessFile raf = new RandomAccessFile("datos.dat", "rw");
             FileChannel canal = raf.getChannel()) {

            // Escribir 5 registros
            ByteBuffer buf = ByteBuffer.allocate(TAM_REG);
            double[] notas = {8.5, 9.0, 7.5, 10.0, 6.5};

            for (int i = 0; i < notas.length; i++) {
                buf.clear();
                buf.putInt(i + 1);     // ID
                buf.putDouble(notas[i]); // Nota
                buf.flip();
                canal.write(buf, (long) i * TAM_REG); // escribe en posición exacta
            }

            // Acceso DIRECTO al tercer registro (índice 2)
            buf.clear();
            canal.read(buf, (long) 2 * TAM_REG); // saltar directo a posición 24
            buf.flip();

            System.out.println("Registro 3 (acceso directo):");
            System.out.println("  ID:   " + buf.getInt());
            System.out.println("  Nota: " + buf.getDouble());
        }
    }
}
