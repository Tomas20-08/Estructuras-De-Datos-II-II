package SistemaDeArchivos;

import java.io.*;

public class C24_RenombrarEliminar {
    public static void main(String[] args) throws IOException {
        // Crear archivo original
        File original = new File("temp_original.txt");
        original.createNewFile();
        System.out.println("Creado: " + original.getName());

        // Renombrar
        File renombrado = new File("temp_renombrado.txt");
        if (original.renameTo(renombrado)) {
            System.out.println("Renombrado a: " + renombrado.getName());
        }

        // Verificar
        System.out.println("¿Original existe?: " + original.exists());   // false
        System.out.println("¿Renombrado existe?: " + renombrado.exists()); // true

        // Eliminar
        if (renombrado.delete()) {
            System.out.println("Archivo eliminado");
        }
        System.out.println("¿Existe ahora?: " + renombrado.exists()); // false
    }
}
