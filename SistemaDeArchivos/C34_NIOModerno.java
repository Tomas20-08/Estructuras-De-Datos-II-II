package SistemaDeArchivos;

import java.nio.file.*;
import java.util.*;

public class C34_NIOModerno {
    public static void main(String[] args) throws Exception {
        Path archivo = Paths.get("moderno.txt");
        Path copia = Paths.get("moderno_copia.txt");
        Path movido = Paths.get("archivos", "moderno_final.txt");

        // ESCRIBIR
        List<String> contenido = Arrays.asList(
            "Línea 1: NIO es moderno y elegante",
            "Línea 2: Menos código, más funcionalidad",
            "Línea 3: Integrado desde Java 7"
        );
        Files.write(archivo, contenido,
            StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        System.out.println("Escrito con NIO");

        // LEER TODO
        List<String> leido = Files.readAllLines(archivo);
        System.out.println("\nContenido:");
        leido.forEach(l -> System.out.println("  " + l));

        // COPIAR
        Files.copy(archivo, copia, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("\nCopiado a: " + copia.getFileName());

        // MOVER (crear directorio primero)
        Files.createDirectories(movido.getParent());
        Files.move(archivo, movido, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Movido a: " + movido);

        System.out.println("\nTamaño: " + Files.size(movido) + " bytes");
    }
}
