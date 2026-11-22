package SistemaDeArchivos;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class C01_EjemploDirectorios {
    public static void main(String[] args) throws IOException {

        // 1. Crear directorio
        File dir = new File("miCarpeta");
        if (!dir.exists()) dir.mkdir();      // mkdir() = un nivel
        dir.mkdirs();                          // mkdirs() = multinivel

        // 2. Listar contenido
        File[] archivos = dir.listFiles();
        for (File f : archivos) {
            System.out.println(f.getName() + (f.isDirectory() ? " [DIR]" : " [FILE]"));
        }

        // 3. Información del directorio
        System.out.println("Ruta absoluta: " + dir.getAbsolutePath());
        System.out.println("¿Existe?: " + dir.exists());
        System.out.println("¿Es directorio?: " + dir.isDirectory());
        System.out.println("Padre: " + dir.getParent());

        // 4. Con NIO (moderno, recomendado)
        Path ruta = Paths.get("src", "main", "recursos");
        Files.createDirectories(ruta);         // Crea todos los niveles

        // 5. Directorio actual del proyecto
        System.out.println(System.getProperty("user.dir"));
    }
}
