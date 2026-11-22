
package Parcial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Punto_13 {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese Nombre Del Producto");
        String nombre = scanner.nextLine().trim().replace(",", " ");

        System.out.println("Ingrese Precio Del Producto");
        String precio = scanner.nextLine().trim().replace(",", " ");

        int stock;
        try {
            System.out.println("Ingrese Stock Del Producto");
            stock = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("El Stock debe ser un valor entero");
            return;
        }

        try (BufferedWriter escribir = new BufferedWriter(new FileWriter("inventario.csv", true))) {

            escribir.write(nombre + "," + precio + "," + stock);
            escribir.newLine();

            System.out.println("Agregado Correctamente");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + e.getMessage());
        }

        scanner.close();
        
    }
    
}
