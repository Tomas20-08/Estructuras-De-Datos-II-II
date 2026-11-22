package SistemaDeArchivos;

import java.io.*; import java.util.*;
public class C44_FrecuenciaPalabras {
    public static void main(String[] a) throws IOException {
        Map<String,Integer> freq = new TreeMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String l;
            while((l=br.readLine())!=null)
                for(String w : l.split("\\s+")) {
                    String clean = w.replaceAll("[^a-záéíóúA-Z]","").toLowerCase();
                    if(!clean.isEmpty()) freq.merge(clean,1,Integer::sum);
                }
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((x,y)->y.getValue()-x.getValue());
        try(PrintWriter pw = new PrintWriter("frecuencias.txt")) {
            list.forEach(e->pw.printf("%-20s %d%n",e.getKey(),e.getValue()));
        }
        System.out.println("Palabras únicas: " + list.size());
        list.stream().limit(5).forEach(e->System.out.println(e.getKey()+": "+e.getValue()));
    }
}
