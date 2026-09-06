package com.mycompany.pilaestatica;

public class PilaDinamica {
    
    // atributos
    Nodo tope;
    
    // constructor
    public PilaDinamica() {
        tope = null;
    }
    
    public boolean pilaVacia() {
        if (tope == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void apilar(String nombre) {
        Nodo nuevo = new Nodo(nombre, null);
        nuevo.siguiente = tope;
        tope = nuevo;
        System.out.println("APILADO: " + nombre);
    }
    
    public void desapilar() {
        if (pilaVacia()){
            System.out.println("La pila esta vacia");
            return;
        }
        Nodo temporal;
        temporal = tope;
        System.out.println("DESAPILADO: " + tope.nombre);
        tope = tope.siguiente;
    }
    
    public void mostrarPila() {
        Nodo temporal;
        if (pilaVacia()) {
            System.out.println("La pila esta vacia");
        } else {
            System.out.println("\nContenido de la pila");
            for (temporal = tope; temporal != null; temporal = temporal.siguiente) {
                System.out.println(temporal.nombre);
            }
        }
    }
    
    
    public static void main(String[] args) {
        PilaDinamica pila = new PilaDinamica();
        
        pila.apilar("Juan");
        pila.apilar("Rosa");
        pila.apilar("Antonio");
        pila.mostrarPila();
        System.out.println();
        
        pila.desapilar();
        pila.mostrarPila();
        System.out.println();
        
    }
}
