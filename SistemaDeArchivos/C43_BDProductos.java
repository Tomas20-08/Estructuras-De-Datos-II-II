package SistemaDeArchivos;

import java.io.*;
public class C43_BDProductos {
    static final int TAM = 4 + 40 + 8;
    static void insertar(RandomAccessFile r, int id, String nom, double precio)
            throws IOException {
        r.seek((long)id*TAM);
        r.writeInt(id);
        StringBuilder sb = new StringBuilder(nom);
        while(sb.length()<20) sb.append(' ');
        r.writeChars(sb.substring(0,20));
        r.writeDouble(precio);
    }
    static void consultar(RandomAccessFile r, int id) throws IOException {
        r.seek((long)id*TAM);
        int rid = r.readInt();
        StringBuilder nom = new StringBuilder();
        for(int i=0;i<20;i++) nom.append(r.readChar());
        System.out.printf("[%d] %-20s $%.2f%n", rid, nom.toString().trim(), r.readDouble());
    }
    public static void main(String[] a) throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile("productos.dat","rw")) {
            insertar(raf, 0, "Laptop", 1200.0);
            insertar(raf, 1, "Mouse", 25.0);
            insertar(raf, 2, "Teclado", 45.0);
            consultar(raf, 0); consultar(raf, 1); consultar(raf, 2);
        }
    }
}
