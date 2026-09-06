package com.trust.pa4_rosas_del_aguila;

public class Nodo {
    
    // Numero de ticket del cliente
    int ticket;
    // Referencia al siguiente nodo en la cola
    Nodo siguiente;
    
    // Constructor: recibe el numero de ticket
    public Nodo(int ticket) {
        this.ticket = ticket;
        this.siguiente = null;
    }
}