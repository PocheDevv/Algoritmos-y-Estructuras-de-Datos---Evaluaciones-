package com.trust.pa3_rosas_del_aguila;

public class ListaDoble {
    
    Nodo inicio;
    Nodo fin;
    
    public ListaDoble() {
        this.inicio = null;
        this.fin = null;
    }
    
    public static void main(String[] args) {
        System.out.println("PA3 - Lista Doblemente Enlazada");
    }
    // Retorna true si la lista no contiene elementos

    public boolean listaVacia() {
        return inicio == null;
    }

    // Inserta un nodo nuevo al inicio de la lista
    public void insertarInicio(int valor) {
        Nodo nodoNuevo = new Nodo(valor);
        if (listaVacia()) {
            inicio = nodoNuevo;
            fin = nodoNuevo;
        } else {
            nodoNuevo.siguiente = inicio;
            inicio.anterior = nodoNuevo;
            inicio = nodoNuevo;
        }
    }
    
    // Inserta un nodo nuevo al final de la lista
    public void insertarFinal(int valor) {
        Nodo nodoNuevo = new Nodo(valor);
        if (listaVacia()) {
            inicio = nodoNuevo;
            fin = nodoNuevo;
        } else {
            nodoNuevo.anterior = fin;
            fin.siguiente = nodoNuevo;
            fin = nodoNuevo;
        }
    }

    // Muestra los elementos desde el inicio hasta el final
    public void mostrarAdelante() {
        if (listaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo nodoActual = inicio;
            while (nodoActual != null) {
                System.out.print(nodoActual.dato + " ");
                nodoActual = nodoActual.siguiente;
            }
            System.out.println();
        }
    }
    // Muestra los elementos desde el final hasta el inicio
    public void mostrarAtras() {
        if (listaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo nodoActual = fin;
            while (nodoActual != null) {
                System.out.print(nodoActual.dato + " ");
                nodoActual = nodoActual.anterior;
            }
            System.out.println();
        }
    }
    
    // Retorna true si el valor se encuentra en la lista
    public boolean buscar(int valor) {
        Nodo nodoActual = inicio;
        while (nodoActual != null) {
            if (nodoActual.dato == valor) {
                return true;
            }
            nodoActual = nodoActual.siguiente;
        }
        return false;
    }
    
    // Elimina la primera ocurrencia del valor. Retorna true si se elimino
    public boolean eliminarValor(int valor) {
        if (listaVacia()) {
            System.out.println("La lista esta vacia");
            return false;
        }
        Nodo nodoActual = inicio;
        while (nodoActual != null) {
            if (nodoActual.dato == valor) {
                // Si es el unico nodo
                if (nodoActual == inicio && nodoActual == fin) {
                    inicio = null;
                    fin = null;
                    // Si es el nodo inicio
                } else if (nodoActual == inicio) {
                    inicio = inicio.siguiente;
                    inicio.anterior = null;
                    // Si es el nodo fin
                } else if (nodoActual == fin) {
                    fin = fin.anterior;
                    fin.siguiente = null;
                    // Si es un nodo del medio
                } else {
                    nodoActual.anterior.siguiente = nodoActual.siguiente;
                    nodoActual.siguiente.anterior = nodoActual.anterior;
                }
                return true;
            }
            nodoActual = nodoActual.siguiente;
        }
        return false;
    }
    
    // Elimina y devuelve el primer elemento
    public int eliminarInicio() {
        if (listaVacia()) {
            System.out.println("La lista esta vacia");
            return -1;
        }
        int valor = inicio.dato;
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        return valor;
    }

    // Elimina y devuelve el ultimo elemento
    public int eliminarFinal() {
        if (listaVacia()) {
            System.out.println("La lista esta vacia");
            return -1;
        }
        int valor = fin.dato;
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        return valor;
    }

    // Retorna la cantidad de elementos en la lista
    public int numeroElementos() {
        int contador = 0;
        Nodo nodoActual = inicio;
        while (nodoActual != null) {
            contador++;
            nodoActual = nodoActual.siguiente;
        }
        return contador;
    }
    
}