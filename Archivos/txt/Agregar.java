
package Archivos.txt;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Agregar {
    public static void main(String [] arg){
    
        try{
        
            BufferedWriter agregar = new BufferedWriter(new FileWriter("estudiantes.txt", true));
            
            agregar.newLine();
            agregar.write("Luis Sepulveda");
            
            agregar.newLine();
            agregar.write("Edwar Batidas");
            
            agregar.close();
            
            System.out.println("Agregados");
            
        }
        
        catch (IOException e){
        
            System.out.println("Error");
            
        }
    }
    
}
