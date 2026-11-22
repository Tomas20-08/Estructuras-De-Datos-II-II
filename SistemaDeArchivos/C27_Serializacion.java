package SistemaDeArchivos;

import java.io.*;

public class C27_Serializacion {

    static class Producto implements Serializable {
        private static final long serialVersionUID = 1L;
        String nombre; double precio; int stock;
        Producto(String n, double p, int s){ nombre=n; precio=p; stock=s; }
        public String toString(){
            return nombre + " | $" + precio + " | stock:" + stock;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Producto p1 = new Producto("Laptop", 1200.00, 15);

        // SERIALIZAR (guardar objeto en archivo)
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("producto.ser"))) {
            oos.writeObject(p1);
            System.out.println("Objeto guardado: " + p1);
        }

        // DESERIALIZAR (recuperar objeto del archivo)
        Producto recuperado;
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("producto.ser"))) {
            recuperado = (Producto) ois.readObject();
        }
        System.out.println("Objeto recuperado: " + recuperado);
        System.out.println("¿Mismo nombre?: " + recuperado.nombre.equals(p1.nombre));
    }
}
