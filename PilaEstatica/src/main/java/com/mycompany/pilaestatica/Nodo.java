package com.mycompany.pilaestatica;

public class Nodo {
    String nombre;
    Nodo siguiente;
    
    public Nodo(String nombre, Nodo nodo) {
        this.nombre = nombre;
        this.siguiente = nodo;
    }
}
