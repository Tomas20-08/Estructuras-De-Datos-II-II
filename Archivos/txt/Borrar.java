
package Archivos.txt;
import java.io.File;

public class Borrar {
    public static void main (String[] args){
    
        File archivo = new File("estudiantes.txt");
        
        if(archivo.exists()){
        
            if(archivo.delete()){
            
                System.out.println("Archivo eliminado");
                
            }else{
            
                System.out.println("El no se pudo eliminar");
            }
            
        }
        
        else{
        
            System.out.println("El no existe");
        }
    }
}
