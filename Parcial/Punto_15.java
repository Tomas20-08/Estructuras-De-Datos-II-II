/*
Con el archivo .txt anterior:

     Buscar en el archivo una palabra clave que el usuario desee buscar.
*/

package Parcial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.
        JOptionPane;

public class Punto_15 {

    public static void main(String[] args) {
        
                String nombre = JOptionPane.showInputDialog(null, "Ingrese El Nombre Del Autor:", "Buscar Autor", JOptionPane.QUESTION_MESSAGE);

        if (nombre == null) {
            return;
        }

        nombre = nombre.trim();
        boolean encontrado = false;

        try (BufferedReader leer = new BufferedReader(new FileReader("AUTHORS.txt"))) {

            String linea;

            while ((linea = leer.readLine()) != null) {
                if (linea.trim().equalsIgnoreCase(nombre)) {
                    JOptionPane.showMessageDialog(null, "Autor Encontrado", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Autor No Encontrado", "Resultado", JOptionPane.WARNING_MESSAGE);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
}
