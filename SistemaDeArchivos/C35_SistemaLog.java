package SistemaDeArchivos;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C35_SistemaLog {

    static final String LOG_FILE = "sistema.log";
    static final DateTimeFormatter FMT =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static void log(String nivel, String mensaje) {
        String entrada = String.format("[%s] [%s] %s",
            LocalDateTime.now().format(FMT), nivel, mensaje);

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(LOG_FILE, true))) {
            bw.write(entrada);
            bw.newLine();
            System.out.println(entrada);
        } catch (IOException e) {
            System.err.println("Error escribiendo log: " + e.getMessage());
        }
    }

    static void info(String msg)  { log("INFO ", msg); }
    static void warn(String msg)  { log("WARN ", msg); }
    static void error(String msg) { log("ERROR", msg); }

    public static void main(String[] args) throws Exception {
        info("Aplicación iniciada");
        info("Conectando a base de datos...");
        warn("Tiempo de respuesta alto: 2500ms");
        info("Cargados 250 registros");
        error("Falla en módulo de reportes: NullPointerException");
        info("Sistema funcionando con degradación");

        System.out.println("\nLog guardado en: " + LOG_FILE);
        System.out.println("Tamaño: " + new File(LOG_FILE).length() + " bytes");
    }
}
