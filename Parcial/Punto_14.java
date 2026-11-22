/*
Crea un programa que lea cualquier archivo .txt y muestre estadísticas completas: Número total de líneas, palabras, caracteres (sin contar saltos de línea) y el tamaño en bytes del archivo.

Pista: Usa BufferedReader para leer línea por línea. Para palabras usa split("\\s+"). El tamaño en bytes lo obtienes con new File(ruta).length().

BufferedReader
splits("//s+")
File(ruta).length()
*/

package Parcial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Punto_14 {
    
    

    public static void main(String[] args) {
        
        try (BufferedReader br = new BufferedReader(new FileReader("AUTHORS.txt"))) {
            
            File archivo = new File("/home/tdlm/Projects/Software/Programming/NetBeans Projects/4. Cuarto Semestre/Estructuras de Datos II/IV. Estructuras De Datos II Corte 2/AUTHORS.txt");

            long tamanoEnBytes = archivo.length();
            
            System.out.println("El tamaño en bytes: " + tamanoEnBytes);
            
        String linea;
        int lineas = 0; 
        int palabras = 0;
        int caracteres = 0;
        
        while ((linea = br.readLine()) != null) {
            lineas++;
                    caracteres += linea.length();
                    
                    if(!linea.trim().isEmpty()){
                        String[] palabra = linea.trim().split("\\s+");
                    palabras += palabra.length;
                    
            }           
        }
            
            System.out.println("Lineas: " + lineas);
            System.out.println("Palabras: " + palabras);
            System.out.println("Caracteres: " + caracteres);
            
        } catch (IOException e) { 
            e.printStackTrace();  
        
        }
            
        }
    }
    



