package com.trust.final_rosas_del_aguila;

public class Estacion {

    // Nombre de la estacion
    String nombre;

    // Indica si la estacion ya fue visitada durante un recorrido (DFS o BFS)
    boolean visitada;

    // Indica si la estacion esta activa (en operacion) o aun no habilitada
    boolean activa;

    // Constructor: crea una estacion con su nombre y la marca como activa
    public Estacion(String nombre, boolean activa) {
        this.nombre = nombre;
        this.visitada = false;
        this.activa = activa;
    }

    @Override
    public String toString() {
        String estado = activa ? "ACTIVA" : "NO HABILITADA";
        return nombre + " [" + estado + "]";
    }
}