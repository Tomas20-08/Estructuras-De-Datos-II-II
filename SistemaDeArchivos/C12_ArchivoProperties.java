package SistemaDeArchivos;

import java.io.*;
import java.util.Properties;

public class C12_ArchivoProperties {
    public static void main(String[] args) throws IOException {

        // ESCRIBIR
        Properties props = new Properties();
        props.setProperty("db.host", "localhost");
        props.setProperty("db.port", "3306");
        props.setProperty("db.name", "escuela");
        props.setProperty("app.version", "1.0.0");

        try (FileOutputStream fos = new FileOutputStream("config.properties")) {
            props.store(fos, "Configuración de la aplicación");
        }

        // LEER
        Properties leidas = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            leidas.load(fis);
        }
        System.out.println("Host: " + leidas.getProperty("db.host"));
        System.out.println("Puerto: " + leidas.getProperty("db.port"));
    }
}
