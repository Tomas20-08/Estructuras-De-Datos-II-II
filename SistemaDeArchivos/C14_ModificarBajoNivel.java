package SistemaDeArchivos;

import java.io.RandomAccessFile;
import java.io.IOException;

public class C14_ModificarBajoNivel {

    public static void main(String[] args) {

        // "rw" = lectura y escritura
        try (RandomAccessFile raf = new RandomAccessFile("registro.dat", "rw")) {

            // -- Paso 1: Escribir registros de longitud fija --
            // Cada registro = 4 bytes (int ID) + 8 bytes (double nota)
            raf.writeInt(1);      // bytes 0-3:  ID=1
            raf.writeDouble(9.5); // bytes 4-11: nota=9.5
            raf.writeInt(2);      // bytes 12-15: ID=2
            raf.writeDouble(8.0); // bytes 16-23: nota=8.0
            raf.writeInt(3);      // bytes 24-27: ID=3
            raf.writeDouble(7.0); // bytes 28-35: nota=7.0

            System.out.println("Tamaño del archivo: " + raf.length() + " bytes");

            // -- Paso 2: Leer el segundo registro (posición 12) --
            int tamRegistro = 4 + 8; // 12 bytes por registro
            int indice = 1;           // queremos el registro índice 1 (el segundo)

            raf.seek((long) indice * tamRegistro);
            System.out.println("\nRegistro 2:");
            System.out.println("  ID:   " + raf.readInt());
            System.out.println("  Nota: " + raf.readDouble());

            // -- Paso 3: MODIFICAR la nota del segundo registro --
            // La nota está 4 bytes después del inicio del registro
            raf.seek((long) indice * tamRegistro + 4);
            raf.writeDouble(9.8);  // Sobreescribir la nota

            // -- Paso 4: Verificar la modificación --
            raf.seek((long) indice * tamRegistro);
            System.out.println("\nRegistro 2 modificado:");
            System.out.println("  ID:   " + raf.readInt());
            System.out.println("  Nota: " + raf.readDouble());

            // -- Paso 5: Leer TODOS los registros --
            System.out.println("\nTodos los registros:");
            raf.seek(0); // volver al inicio
            while (raf.getFilePointer() < raf.length()) {
                System.out.printf("  ID: %d | Nota: %.1f%n",
                    raf.readInt(), raf.readDouble());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
