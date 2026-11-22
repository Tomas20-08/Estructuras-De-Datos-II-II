package SistemaDeArchivos;

import java.io.*;
import java.util.*;

public class C37_AgendaInteractiva {
    static final String ARCHIVO = "agenda.txt";
    static Scanner sc = new Scanner(System.in);

    static void agregar(String nombre, String tel) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO, true))) {
            pw.println(nombre + "|" + tel);
        }
        System.out.println("Contacto guardado: " + nombre);
    }

    static void listar() throws IOException {
        File f = new File(ARCHIVO);
        if (!f.exists() || f.length() == 0) { System.out.println("  (vacío)"); return; }
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea; int i = 1;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split("\\|");
                System.out.printf("  %d. %-20s %s%n", i++, p[0], p[1]);
            }
        }
    }

    static void menu() {
        System.out.println("\n+======================+");
        System.out.println("|    MI AGENDA       |");
        System.out.println("+======================+");
        System.out.println("| 1. Ver contactos      |");
        System.out.println("| 2. Agregar contacto   |");
        System.out.println("| 0. Salir              |");
        System.out.println("+======================+");
        System.out.print("Opción: ");
    }

    public static void main(String[] args) throws IOException {
        // Datos de prueba
        agregar("Ana Gómez", "300-123-4567");
        agregar("Carlos Ruiz", "315-987-6543");

        int op;
        do {
            menu();
            op = sc.nextInt(); sc.nextLine();
            switch (op) {
                case 1: System.out.println("\nContactos:"); listar(); break;
                case 2:
                    System.out.print("Nombre: "); String n = sc.nextLine();
                    System.out.print("Teléfono: "); String t = sc.nextLine();
                    agregar(n, t); break;
                case 0: System.out.println("\n¡Hasta luego!"); break;
                default: System.out.println("Opción inválida");
            }
        } while (op != 0);
    }
}
