package SistemaDeArchivos;

import java.io.*;

public class C11_ArchivosBinarios {
    public static void main(String[] args) throws IOException {

        // ESCRIBIR datos binarios
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("datos.bin"))) {

            dos.writeInt(42);           // 4 bytes
            dos.writeDouble(3.14);     // 8 bytes
            dos.writeBoolean(true);    // 1 byte
            dos.writeUTF("Hola");      // 2 + n bytes
        }

        // LEER datos binarios (mismo orden de escritura)
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream("datos.bin"))) {

            System.out.println("Int: " + dis.readInt());
            System.out.println("Double: " + dis.readDouble());
            System.out.println("Boolean: " + dis.readBoolean());
            System.out.println("String: " + dis.readUTF());
        }
    }
}
