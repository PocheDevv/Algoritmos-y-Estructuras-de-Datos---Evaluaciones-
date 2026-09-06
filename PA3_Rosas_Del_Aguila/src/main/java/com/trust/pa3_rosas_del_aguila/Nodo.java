package com.trust.pa3_rosas_del_aguila;

public class Nodo {
    
    int dato;
    Nodo anterior;
    Nodo siguiente;
    
    public Nodo(int dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
}