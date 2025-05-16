package co.edu.unbosque.view;

import java.util.List;
import java.util.Scanner;

import co.edu.unbosque.model.NodoRN;
import co.edu.unbosque.model.Paciente;

public class UrgenciaView {
private Scanner sc = new Scanner(System.in);

public int mostrarMenu() {
    System.out.println("\nGestión de Urgencias");
    System.out.println("1. Insertar paciente");
    System.out.println("2. Mostrar pacientes ");
    System.out.println("3. Mostrar paciente más urgente");
    System.out.println("4. Salir");
    System.out.print("Elige una opción: ");
    return sc.nextInt();
}

public String leerNombre() {
    System.out.print("Nombre: "); sc.nextLine();
    return sc.nextLine();
}

public int leerPrioridad() {
    int pr;
    do {
        System.out.print("Prioridad (1-100): ");
        pr = Integer.parseInt(sc.nextLine());
        if (pr < 1 || pr > 100) System.out.println(" Prioridad incorrecta.");
    } while (pr < 1 || pr > 100);
    return pr;
}

public void mostrarPacientes(List<NodoRN> lista) {
    System.out.println("Pacientes en orden por prioridad :");
    for (NodoRN n : lista) {
        Paciente p = n.getDato();
        String color = n.isColor() ? "ROJO" : "NEGRO";
        System.out.printf("ID:%d, Nombre:%s, Prioridad:%d, %s\n",
            p.getId(), p.getNombre(), p.getPrioridad(), color);
    }
}

public void mostrarUrgente(Paciente p) {
    if (p != null)
        System.out.println("Más urgente -> " + p);
    else
        System.out.println("Árbol vacío.");
}

public void mostrarMensaje(String m) {
    System.out.println(m);
}
}




