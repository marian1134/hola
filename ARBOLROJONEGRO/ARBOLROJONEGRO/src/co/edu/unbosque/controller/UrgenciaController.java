package co.edu.unbosque.controller;

import java.util.List;

import co.edu.unbosque.model.ArbolRojoNegro;
import co.edu.unbosque.model.NodoRN;
import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.view.UrgenciaView;

public class UrgenciaController {
private ArbolRojoNegro modelo;
private UrgenciaView vista;
private int contadorIds = 1;

public UrgenciaController(ArbolRojoNegro m, UrgenciaView v) {
    this.modelo = m;
    this.vista = v;
}

public void run() {
    int op;
    do {
        op = vista.mostrarMenu();
        switch (op) {
            case 1:
                Paciente p = new Paciente(contadorIds++, vista.leerNombre(), vista.leerPrioridad());
                modelo.insertar(p);
                vista.mostrarMensaje("Insertado: " + p);
                break;
            case 2:
                List<NodoRN> list = modelo.obtenerEnOrdenConColor();
                vista.mostrarPacientes(list);
                break;
            case 3:
                vista.mostrarUrgente(modelo.buscarMayorPrioridad());
                break;
            case 4:
                vista.mostrarMensaje("Adiós.");
                break;
            default:
                vista.mostrarMensaje("Opción inválida.");
        }
    } while (op != 4);
}
}