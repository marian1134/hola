package co.edu.unbosque.model;

public class NodoRN {
	public static final boolean ROJO = true;
	public static final boolean NEGRO = false;

	Paciente dato;
	NodoRN izquierdo, derecho, padre;
	boolean color;

	public NodoRN(Paciente dato) {
	    this.dato = dato;
	    this.color = ROJO;
	}

	public Paciente getDato() {
		return dato;
	}

	public void setDato(Paciente dato) {
		this.dato = dato;
	}

	public NodoRN getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(NodoRN izquierdo) {
		this.izquierdo = izquierdo;
	}

	public NodoRN getDerecho() {
		return derecho;
	}

	public void setDerecho(NodoRN derecho) {
		this.derecho = derecho;
	}

	public NodoRN getPadre() {
		return padre;
	}

	public void setPadre(NodoRN padre) {
		this.padre = padre;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public static boolean isRojo() {
		return ROJO;
	}

   
}

