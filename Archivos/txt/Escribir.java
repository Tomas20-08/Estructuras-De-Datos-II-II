
package Archivos.txt;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escribir {
    public static void main(String [] args){
    
        try{
        
            BufferedWriter digitar=new BufferedWriter(new FileWriter("estudiantes.txt"));
            
            digitar.write("Eliana Paez");
            digitar.newLine();
            
            digitar.write("Victoria Lobo");
            digitar.newLine();
            
            digitar.write("Julian Rodriguez");
            digitar.close();
            
            System.out.println("Guardado");
            
        }
        
        catch (IOException e){
        
            System.out.println("Error");
        }
    }
}
