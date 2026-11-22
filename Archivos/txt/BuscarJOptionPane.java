package Archivos.txt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class BuscarJOptionPane {

    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog(null, "Ingrese El Nombre:", "Buscar Estudiante", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario presiona Cancelar o cierra la ventana, nombre es null
        if (nombre == null) {
            return;
        }

        nombre = nombre.trim();
        boolean encontrado = false;

        try (BufferedReader leer = new BufferedReader(new FileReader("estudiantes.txt"))) {

            String linea;

            while ((linea = leer.readLine()) != null) {
                if (linea.trim().equalsIgnoreCase(nombre)) {
                    JOptionPane.showMessageDialog(null, "Estudiante Encontrado!!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
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