
package Archivos.txt;
import java.io.File;
import java.io.IOException;

public class Crear {

    public static void main(String[] args) {
        
        File archivo=new File("estudiantes.txt");
        
        try{
        
            if(archivo.createNewFile()){
            
                System.out.println("Archivo creado");
                System.out.println("Ruta" +archivo.getAbsolutePath());
            }
            
            else{
            
                System.out.println("El archivo ya existe");
            }
            
        }
        
        catch(IOException e){
        
            System.out.println("Ocurrio un error"+e.getMessage());
        }
    }    
}
