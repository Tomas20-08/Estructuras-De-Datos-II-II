package SistemaDeArchivos;

import java.io.*; import java.util.*;
public class C47_SistemaNotas {
    static class Est { String nom; double nota;
        Est(String n,double nota){nom=n;this.nota=nota;}
        String csv(){return nom+","+nota;}
        public String toString(){return nom+" ("+nota+")";} }
    static List<Est> cargar(String f) {
        List<Est> l = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(f))) {
            br.readLine();
            String ln; while((ln=br.readLine())!=null) {
                String[] p=ln.split(",");
                l.add(new Est(p[0],Double.parseDouble(p[1]))); }
        } catch(FileNotFoundException e){ System.out.println("Nuevo archivo"); }
        catch(IOException e){ e.printStackTrace(); }
        return l;
    }
    static void guardar(List<Est> lista, String f) throws IOException {
        try(PrintWriter pw = new PrintWriter(new FileWriter(f))) {
            pw.println("Nombre,Nota");
            lista.forEach(e->pw.println(e.csv())); }
    }
    public static void main(String[] a) throws IOException {
        String csv = "clase.csv";
        List<Est> lista = cargar(csv);
        lista.add(new Est("Ana",9.5)); lista.add(new Est("Carlos",8.0));
        lista.get(0).nota = 10.0; // editar
        lista.remove(1); // eliminar
        guardar(lista, csv);
        System.out.println("Final:"); cargar(csv).forEach(System.out::println);
    }
}
