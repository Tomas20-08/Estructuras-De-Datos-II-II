package SistemaDeArchivos;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C30_ListarDirectorio {
    public static void main(String[] args) {
        File directorio = new File(".");  // directorio actual del proyecto

        // Filtro para archivos .txt
        FilenameFilter filtroTXT = (dir, nombre) -> nombre.endsWith(".txt");

        File[] archivos = directorio.listFiles(filtroTXT);

        System.out.println("Archivos .txt en: " + directorio.getAbsolutePath());
        System.out.println("===========================================");

        if (archivos == null || archivos.length == 0) {
            System.out.println("  (sin archivos .txt)");
        } else {
            for (File f : archivos) {
                String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm").
                               format(new Date(f.lastModified()));
                System.out.printf("  %-25s %8d bytes  %s%n",
                    f.getName(), f.length(), fecha);
            }
            System.out.println("===========================================");
            System.out.println("  Total: " + archivos.length + " archivos");
        }
    }
}
