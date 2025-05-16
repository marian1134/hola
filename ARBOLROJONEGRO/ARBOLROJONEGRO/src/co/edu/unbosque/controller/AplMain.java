package co.edu.unbosque.controller;

import co.edu.unbosque.model.ArbolRojoNegro;
import co.edu.unbosque.view.UrgenciaView;

public class AplMain {
public static void main(String[] args) {
ArbolRojoNegro modelo = new ArbolRojoNegro();
UrgenciaView vista = new UrgenciaView();
UrgenciaController ctrl = new UrgenciaController(modelo, vista);
ctrl.run();
}
}


