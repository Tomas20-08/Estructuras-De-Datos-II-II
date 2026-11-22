
package Archivos.txt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leer {
    public static void main(String[] args){
    
        try{
       
            BufferedReader leer=new BufferedReader(new FileReader("estudiantes.txt"));
            
            String linea;
            
            while ((linea=leer.readLine()) !=null){
            
                System.out.println(linea);
                
            }
            
            leer.close(); 
            
        }catch (IOException e){
        
            System.out.println("Error");
            
        }
    }
}
