package SistemaDeArchivos;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * SISTEMA CRUD COMPLETO DE ARCHIVOS EN JAVA
 * Demuestra todas las operaciones sobre ficheros
 */
public class C13_SistemaCRUD {

    static final String ARCHIVO = "estudiantes.csv";

    // === CREATE: Crear archivo con datos iniciales ===
    public static void crearArchivo() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO))) {
            pw.println("ID,Nombre,Nota");
            pw.println("1,Ana Gómez,9.5");
            pw.println("2,Carlos Ruiz,8.0");
            pw.println("3,María López,10.0");
        }
        System.out.println("CREATE: Archivo creado");
    }

    // === READ: Leer todos los registros ===
    public static void leerTodos() throws IOException {
        System.out.println("\nREAD - Lista de estudiantes:");
        System.out.println("-----------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            boolean primero = true;
            while ((linea = br.readLine()) != null) {
                if (primero) { primero = false; continue; } // saltar cabecera
                String[] f = linea.split(",");
                System.out.printf("  [%s] %-15s -> %s%n", f[0], f[1], f[2]);
            }
        }
    }

    // === UPDATE: Agregar un nuevo registro (append) ===
    public static void agregarEstudiante(String id, String nombre, double nota)
            throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO, true))) {
            pw.println(id + "," + nombre + "," + nota);
        }
        System.out.println("\nUPDATE: Agregado -> " + nombre);
    }

    // === DELETE: Eliminar un estudiante por ID ===
    public static void eliminarEstudiante(String idEliminar) throws IOException {
        Path orig = Paths.get(ARCHIVO);
        Path temp = Paths.get(ARCHIVO + ".tmp");

        try (BufferedReader br = Files.newBufferedReader(orig);
             PrintWriter pw = new PrintWriter(Files.newBufferedWriter(temp))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.startsWith(idEliminar + ",")) {
                    pw.println(linea);      // copiar todo excepto el eliminado
                }
            }
        }
        Files.move(temp, orig, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("\nDELETE: Eliminado ID -> " + idEliminar);
    }

    // === SEARCH: Buscar por nombre ===
    public static void buscar(String nombre) throws IOException {
        System.out.println("\nSEARCH: Buscando -> \"" + nombre + "\"");
        boolean encontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains(nombre.toLowerCase())) {
                    System.out.println("  Encontrado: " + linea);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) System.out.println("  No encontrado.");
    }

    // === MAIN: Ejecutar todo ===
    public static void main(String[] args) throws IOException {
        crearArchivo();
        leerTodos();
        agregarEstudiante("4", "Pedro Díaz", 7.5);
        leerTodos();
        buscar("María");
        eliminarEstudiante("2");
        leerTodos();
    }
}
