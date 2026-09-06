package com.mycompany.listadoble;

public class Nodo {
    
    int codigo;
    String nombre;
    Nodo nodoAnterior = null;
    Nodo nodoSiguiente = null;
    
    public Nodo(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public String toString() {
        return "Codigo: " + codigo + " - Nombre: " + nombre;
    }
    
}
