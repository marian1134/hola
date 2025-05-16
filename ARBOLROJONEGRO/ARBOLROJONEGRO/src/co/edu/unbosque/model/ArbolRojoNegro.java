package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

public class ArbolRojoNegro {

	private NodoRN raiz;

	private void rotarIzquierda(NodoRN x) {
	    NodoRN y = x.derecho;
	    x.derecho = y.izquierdo;
	    if (y.izquierdo != null) y.izquierdo.padre = x;
	    y.padre = x.padre;
	    if (x.padre == null) raiz = y;
	    else if (x == x.padre.izquierdo) x.padre.izquierdo = y;
	    else x.padre.derecho = y;
	    y.izquierdo = x;
	    x.padre = y;
	}

	private void rotarDerecha(NodoRN x) {
	    NodoRN y = x.izquierdo;
	    x.izquierdo = y.derecho;
	    if (y.derecho != null) y.derecho.padre = x;
	    y.padre = x.padre;
	    if (x.padre == null) raiz = y;
	    else if (x == x.padre.derecho) x.padre.derecho = y;
	    else x.padre.izquierdo = y;
	    y.derecho = x;
	    x.padre = y;
	}

	public void insertar(Paciente p) {
	    NodoRN z = new NodoRN(p);
	    NodoRN y = null;
	    NodoRN x = raiz;
	    while (x != null) {
	        y = x;
	        if (p.getPrioridad() > x.dato.getPrioridad()) {
	            x = x.izquierdo;
	        } else {
	            x = x.derecho;
	        }
	    }
	    z.padre = y;
	    if (y == null) {
	        raiz = z;
	    } else if (p.getPrioridad() > y.dato.getPrioridad()) {
	        y.izquierdo = z;
	    } else {
	        y.derecho = z;
	    }
	    balancearInsercion(z);
	}

	private void balancearInsercion(NodoRN z) {
	    while (z.padre != null && z.padre.color == NodoRN.ROJO) {
	        NodoRN abu = z.padre.padre;
	        if (abu == null) break;
	        if (z.padre == abu.izquierdo) {
	            NodoRN tio = abu.derecho;
	            if (tio != null && tio.color == NodoRN.ROJO) {
	                z.padre.color = NodoRN.NEGRO;
	                tio.color = NodoRN.NEGRO;
	                abu.color = NodoRN.ROJO;
	                z = abu;
	            } else {
	                if (z == z.padre.derecho) {
	                    z = z.padre;
	                    rotarIzquierda(z);
	                }
	                z.padre.color = NodoRN.NEGRO;
	                abu.color = NodoRN.ROJO;
	                rotarDerecha(abu);
	            }
	        } else {
	            NodoRN tio = abu.izquierdo;
	            if (tio != null && tio.color == NodoRN.ROJO) {
	                z.padre.color = NodoRN.NEGRO;
	                tio.color = NodoRN.NEGRO;
	                abu.color = NodoRN.ROJO;
	                z = abu;
	            } else {
	                if (z == z.padre.izquierdo) {
	                    z = z.padre;
	                    rotarDerecha(z);
	                }
	                z.padre.color = NodoRN.NEGRO;
	                abu.color = NodoRN.ROJO;
	                rotarIzquierda(abu);
	            }
	        }
	    }
	    raiz.color = NodoRN.NEGRO;
	}

	public List<NodoRN> obtenerEnOrdenConColor() {
	    List<NodoRN> lista = new ArrayList<>();
	    inOrdenColor(raiz, lista);
	    return lista;
	}

	private void inOrdenColor(NodoRN n, List<NodoRN> l) {
	    if (n != null) {
	        inOrdenColor(n.izquierdo, l);
	        l.add(n);
	        inOrdenColor(n.derecho, l);
	    }
	}

	public Paciente buscarMayorPrioridad() {
	    NodoRN actual = raiz;
	    while (actual != null && actual.izquierdo != null) {
	        actual = actual.izquierdo;
	    }
	    return actual != null ? actual.dato : null;
	}

	public NodoRN getRaiz() { return raiz; }
}