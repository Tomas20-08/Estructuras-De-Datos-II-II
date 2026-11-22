package SistemaDeArchivos;

import java.io.*;
import java.util.Properties;

public class C29_ArchivoProperties {
    public static void main(String[] args) throws IOException {

        // CREAR configuración
        Properties conf = new Properties();
        conf.setProperty("app.nombre", "SistemaEscolar");
        conf.setProperty("app.version", "2.0");
        conf.setProperty("bd.host", "localhost");
        conf.setProperty("bd.puerto", "3306");
        conf.setProperty("bd.usuario", "admin");

        try (FileOutputStream fos = new FileOutputStream("app.properties")) {
            conf.store(fos, "Configuración del sistema escolar");
        }
        System.out.println("Configuración guardada\n");

        // LEER configuración
        Properties leida = new Properties();
        try (FileInputStream fis = new FileInputStream("app.properties")) {
            leida.load(fis);
        }

        System.out.println("=== CONFIGURACIÓN CARGADA ===");
        System.out.println("App: " + leida.getProperty("app.nombre") +
                           " v" + leida.getProperty("app.version"));
        System.out.println("BD: " + leida.getProperty("bd.host") +
                           ":" + leida.getProperty("bd.puerto"));

        // MODIFICAR una propiedad
        leida.setProperty("app.version", "2.1");
        try (FileOutputStream fos = new FileOutputStream("app.properties")) {
            leida.store(fos, "Actualizado");
        }
        System.out.println("\nVersión actualizada a: " + leida.getProperty("app.version"));
    }
}
