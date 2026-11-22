
package Parcial;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Punto_12 {

    public static void main(String[] args) {
        
                File archivo = new File("inventario.csv");

        if (archivo.exists()) {
            System.out.println("El Archivo Ya Existe");
            return;
        }

        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo))) {

            escribir.write("nombre,precio,stock");
            escribir.newLine();

            escribir.write("Gansito,1500,6");
            escribir.newLine();

            escribir.write("Papaya,4000,3");
            escribir.newLine();

            escribir.write("Coliflor,2000,10");
            escribir.newLine();

            escribir.write("Chocoramo,2600,50");
            escribir.newLine();
            
            escribir.write("Miel,35000,5");
            escribir.newLine();

            escribir.write("Gelatina,5500,4");
            escribir.newLine();

            escribir.write("Manzana,2000,7");
            escribir.newLine();

            escribir.write("Banano,6000,4");
            escribir.newLine();
            escribir.close();

            System.out.println("Archivo Creado");

        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }

    }
    
}
