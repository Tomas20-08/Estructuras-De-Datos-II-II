package Archivos.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class BuscarJOptionPane {

    public static void main(String[] args) {

        String busca = JOptionPane.showInputDialog(null, "Ingrese Nombre:", "Buscar Estudiante", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra la ventana, busca es null
        if (busca == null) {
            return;
        }

        busca = busca.trim();
        boolean encontrado = false;

        try (BufferedReader leer = new BufferedReader(new FileReader("estudiantes.csv"))) {

            String linea;
            leer.readLine(); // saltar la cabecera

            while ((linea = leer.readLine()) != null) {

                String[] datos = linea.split(",");

                // Saltar lineas vacias o incompletas
                if (datos.length < 3) {
                    continue;
                }

                String nombre = datos[0].trim();

                if (nombre.equalsIgnoreCase(busca)) {
                    JOptionPane.showMessageDialog(null,
                            "Nombre: " + datos[0] + "\n"
                            + "Carrera: " + datos[1] + "\n"
                            + "Edad: " + datos[2],
                            "Estudiante Encontrado", JOptionPane.INFORMATION_MESSAGE);

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Estudiante No Encontrado", "Resultado", JOptionPane.WARNING_MESSAGE);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}