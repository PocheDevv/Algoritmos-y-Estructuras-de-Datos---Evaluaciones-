package com.mycompany.pilaestatica;

public class PilaEstatica {
    
    // arreglo que soporta la pila
    String[] pila;
    int tope;
    
    // constructor
    public PilaEstatica(int tamaño) {
        pila = new String[tamaño];
        tope = -1;
    }
    
    // comprobacion de pila vacia
    public boolean pilaVacia() {
        return tope == -1;
    }
    
    // comprobacion de pila llena
    public boolean pilaLlena() {
        return tope == pila.length - 1;
    }
    
    // agregar elemento
    public void apilar(String valor) {
        if (pilaLlena()) {
            System.out.println("La pila esta llena");
            return;
        }
        tope = tope + 1;
        pila[tope] = valor;
    }
    
    // remover elemento
    public String desapilar() {
        if (pilaVacia()) {
            System.out.println("La pila esta vacia");
            return "";
        }
        String valor = pila[tope];
        tope = tope - 1;
        return valor;
    }
    
    // ver elemento tope
    public String verTope() {
        if (pilaVacia()) {
            System.out.println("La pila esta vacia");
            return "";
        }
        return pila[tope];
    }
    
    // mostrar pila
    public void mostrarPila() {
        if (pilaVacia()) {
            System.out.println("La pila esta vacia");
            return;
        }
        System.out.println("\nContenido de la pila");
        for (int i = tope; i >= 0; i--) {
            System.out.println(pila[i]);
        }
    }

    public static void main(String[] args) {
        PilaEstatica miPila = new PilaEstatica(7);
        
        miPila.apilar("Antonio");
        miPila.apilar("Cristina");
        miPila.apilar("Mario");
        miPila.mostrarPila();
        System.out.println("Tope: " + miPila.verTope());
        
        miPila.desapilar();
        miPila.mostrarPila();
        System.out.println("Tope: " + miPila.verTope());
    }
}
