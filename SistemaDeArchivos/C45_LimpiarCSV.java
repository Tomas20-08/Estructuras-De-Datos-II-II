package SistemaDeArchivos;

import java.io.*;
public class C45_LimpiarCSV {
    static String validar(String[] c) {
        if(c.length!=3) return "Columnas incorrectas: "+c.length;
        if(c[0].trim().isEmpty()) return "Nombre vacío";
        try{ Integer.parseInt(c[1].trim()); }
        catch(NumberFormatException e){ return "Edad inválida: "+c[1]; }
        try{ Double.parseDouble(c[2].trim()); }
        catch(NumberFormatException e){ return "Nota inválida: "+c[2]; }
        return null;
    }
    public static void main(String[] a) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("entrada.csv"));
            PrintWriter ok = new PrintWriter("datos_validos.csv");
            PrintWriter err = new PrintWriter("datos_errores.csv")) {
            String l = br.readLine(); ok.println(l); err.println(l+",ERROR");
            int vOK=0, vErr=0;
            while((l=br.readLine())!=null) {
                String error = validar(l.split(","));
                if(error==null){ ok.println(l); vOK++; }
                else { err.println(l+","+error); vErr++; }
            }
            System.out.println("Válidas: "+vOK+" | Errores: "+vErr);
        }
    }
}
