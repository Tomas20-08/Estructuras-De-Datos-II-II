package SistemaDeArchivos;

import java.io.*; import java.util.*;
public class C46_IndiceInvertido {
    public static void main(String[] a) throws IOException {
        Map<String,Set<String>> indice = new TreeMap<>();
        File dir = new File(".");
        for(File f : dir.listFiles((d,n)->n.endsWith(".txt"))) {
            try(BufferedReader br = new BufferedReader(new FileReader(f))) {
                String l;
                while((l=br.readLine())!=null)
                    for(String w : l.split("\\s+")) {
                        String clean = w.replaceAll("[^a-z]","").toLowerCase();
                        if(clean.length()>3)
                            indice.computeIfAbsent(clean,k->new TreeSet<>())
                                  .add(f.getName());
                    }
            }
        }
        try(PrintWriter pw = new PrintWriter("indice.txt")) {
            indice.forEach((w,files)->pw.println(w+" -> "+files));
        }
        System.out.println("Índice: "+indice.size()+" palabras únicas");
    }
}
