package com.trust.pa4_rosas_del_aguila;

public class Cola {

    // Referencias al frente y final de la cola
    Nodo frente;
    Nodo final_;

    // Contador de tickets generados
    int contadorTickets;

    // Constructor
    public Cola() {
        this.frente = null;
        this.final_ = null;
        this.contadorTickets = 0;
    }

    // Verifica si la cola esta vacia.
    // Retorna true si no hay ningun cliente en espera.
    public boolean colaVacia() {
        return frente == null;
    }

    // Colar: registra un nuevo cliente en la cola FIFO.
    // Incrementa el contador de tickets y crea un nuevo nodo al final de la cola.
    // Retorna el numero de ticket asignado al cliente.
    public int colar() {
        contadorTickets++;
        Nodo nodoNuevo = new Nodo(contadorTickets);
        if (colaVacia()) {
            frente = nodoNuevo;
            final_ = nodoNuevo;
        } else {
            final_.siguiente = nodoNuevo;
            final_ = nodoNuevo;
        }
        return contadorTickets;
    }

    // Desencolar: retira al primer cliente de la cola (el que lleva mas tiempo esperando).
    // Principio FIFO: el primero en entrar es el primero en ser atendido.
    // Retorna el numero de ticket atendido, o -1 si la cola esta vacia.
    public int desencolar() {
        if (colaVacia()) {
            System.out.println("No hay clientes en la cola.");
            return -1;
        }
        int ticket = frente.ticket;
        frente = frente.siguiente;
        if (frente == null) {
            final_ = null;
        }
        return ticket;
    }

    // Muestra en consola todos los tickets que estan en espera,
    // en orden de llegada (de frente a final de la cola).
    public void mostrarCola() {
        if (colaVacia()) {
            System.out.println("No hay clientes en la cola.");
            return;
        }
        System.out.println("Clientes en espera:");
        Nodo nodoActual = frente;
        while (nodoActual != null) {
            System.out.println("  Ticket #" + nodoActual.ticket);
            nodoActual = nodoActual.siguiente;
        }
    }

    // Recorre toda la cola contando los nodos.
    // Retorna la cantidad de clientes actualmente en espera.
    public int cantidadEnCola() {
        int contador = 0;
        Nodo nodoActual = frente;
        while (nodoActual != null) {
            contador++;
            nodoActual = nodoActual.siguiente;
        }
        return contador;
    }
}
