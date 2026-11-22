package SistemaDeArchivos;

import java.io.*; import java.nio.file.*;
import java.time.*; import java.time.format.*;
public class C41_BackupTimestamp {
    public static void main(String[] args) throws Exception {
        String origen = "datos.txt";
        new File(origen).createNewFile(); // asegurar que existe
        String ts = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String nombreBase = origen.replace(".txt","");
        String destino = nombreBase + "_" + ts + ".bak";
        Files.copy(Paths.get(origen), Paths.get(destino),
            StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Backup: " + destino);
    }
}
