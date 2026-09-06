package com.trust.final_rosas_del_aguila;

import java.util.Scanner;

public class GrafoTren {

    // Capacidad maxima de estaciones que puede tener el grafo
    static final int MAX_ESTACIONES = 10;

    // Arreglo de estaciones registradas en el sistema
    Estacion[] estaciones;

    // Matriz de adyacencia: 1 si hay conexion entre i y j, 0 si no hay
    int[][] matrizAdyacencia;

    // Cantidad actual de estaciones registradas
    int cantidadEstaciones;

    // Constructor: inicializa el grafo vacio con capacidad para MAX_ESTACIONES estaciones.
    // La matriz de adyacencia se llena con 0 (sin conexion) por defecto.
    public GrafoTren() {
        this.estaciones = new Estacion[MAX_ESTACIONES];
        this.matrizAdyacencia = new int[MAX_ESTACIONES][MAX_ESTACIONES];
        this.cantidadEstaciones = 0;
    }

    // Busca el indice de una estacion por su nombre.
    // Retorna -1 si no existe.
    public int buscarIndice(String nombre) {
        for (int i = 0; i < cantidadEstaciones; i++) {
            if (estaciones[i].nombre.equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    // Registra una nueva estacion en el sistema con validaciones
    public void agregarEstacion(String nombre, boolean activa) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: el nombre de la estacion no puede estar vacio.");
            return;
        }
        if (buscarIndice(nombre) != -1) {
            System.out.println("La estacion '" + nombre + "' ya esta registrada.");
            return;
        }
        if (cantidadEstaciones >= MAX_ESTACIONES) {
            System.out.println("Error: se alcanzo el limite maximo de estaciones (" + MAX_ESTACIONES + ").");
            return;
        }
        estaciones[cantidadEstaciones] = new Estacion(nombre, activa);
        cantidadEstaciones++;
        System.out.println("Estacion '" + nombre + "' registrada correctamente.");
    }

    // Registra una conexion bidireccional entre dos estaciones existentes
    public void agregarConexion(String nombre1, String nombre2) {
        int idx1 = buscarIndice(nombre1);
        int idx2 = buscarIndice(nombre2);
        if (idx1 == -1) {
            System.out.println("Error: la estacion '" + nombre1 + "' no existe.");
            return;
        }
        if (idx2 == -1) {
            System.out.println("Error: la estacion '" + nombre2 + "' no existe.");
            return;
        }
        if (idx1 == idx2) {
            System.out.println("Error: una estacion no puede conectarse con si misma.");
            return;
        }
        if (matrizAdyacencia[idx1][idx2] == 1) {
            System.out.println("La conexion entre '" + nombre1 + "' y '" + nombre2 + "' ya existe.");
            return;
        }
        // Conexion bidireccional: se registra en ambos sentidos
        matrizAdyacencia[idx1][idx2] = 1;
        matrizAdyacencia[idx2][idx1] = 1;
        System.out.println("Conexion registrada: " + nombre1 + " <-> " + nombre2);
    }

    // Muestra todas las estaciones registradas con su estado
    public void mostrarEstaciones() {
        System.out.println("\n===== ESTACIONES REGISTRADAS =====");
        if (cantidadEstaciones == 0) {
            System.out.println("No hay estaciones registradas.");
            return;
        }
        for (int i = 0; i < cantidadEstaciones; i++) {
            System.out.println("  " + (i + 1) + ". " + estaciones[i].toString());
        }
    }

    // Muestra la matriz de adyacencia con los nombres de las estaciones
    public void mostrarMatrizAdyacencia() {
        System.out.println("\n===== MATRIZ DE ADYACENCIA =====");
        if (cantidadEstaciones == 0) {
            System.out.println("No hay estaciones registradas.");
            return;
        }
        // Cabecera de columnas
        System.out.print("\t\t");
        for (int i = 0; i < cantidadEstaciones; i++) {
            System.out.print(estaciones[i].nombre + "\t");
        }
        System.out.println();
        // Filas de la matriz
        for (int i = 0; i < cantidadEstaciones; i++) {
            System.out.print(estaciones[i].nombre + "\t\t");
            for (int j = 0; j < cantidadEstaciones; j++) {
                System.out.print(matrizAdyacencia[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Muestra las conexiones directas de una estacion especifica
    public void mostrarConexionesEstacion(String nombre) {
        int idx = buscarIndice(nombre);
        if (idx == -1) {
            System.out.println("Error: la estacion '" + nombre + "' no existe.");
            return;
        }
        System.out.println("\n===== CONEXIONES DE " + nombre.toUpperCase() + " =====");
        boolean tieneConexiones = false;
        for (int j = 0; j < cantidadEstaciones; j++) {
            if (matrizAdyacencia[idx][j] == 1) {
                System.out.println("  " + nombre + " <-> " + estaciones[j].nombre);
                tieneConexiones = true;
            }
        }
        if (!tieneConexiones) {
            System.out.println("  La estacion " + nombre + " no tiene conexiones registradas.");
        }
    }

    // Reinicia el estado 'visitada' de todas las estaciones
    // antes de iniciar un nuevo recorrido
    public void reiniciarVisitadas() {
        for (int i = 0; i < cantidadEstaciones; i++) {
            estaciones[i].visitada = false;
        }
    }

    // Recorrido en profundidad (DFS) desde la estacion indicada.
    // Explora tan lejos como sea posible antes de retroceder (backtracking).
    public void recorridoProfundidad(String nombreInicio) {
        int indiceInicio = buscarIndice(nombreInicio);
        if (indiceInicio == -1) {
            System.out.println("Error: la estacion '" + nombreInicio + "' no existe.");
            return;
        }
        reiniciarVisitadas();
        System.out.println("\n===== RECORRIDO EN PROFUNDIDAD - DFS DESDE " + nombreInicio.toUpperCase() + " =====");
        dfsRecursivo(indiceInicio, 0);
        System.out.println();
    }

    // Metodo recursivo auxiliar del DFS.
    // El parametro nivel indica la profundidad actual del recorrido.
    private void dfsRecursivo(int indiceActual, int nivel) {
        estaciones[indiceActual].visitada = true;
        // Muestra la estacion con indentacion segun su nivel de profundidad
        String indentacion = "  ".repeat(nivel);
        System.out.println(indentacion + "-> " + estaciones[indiceActual].nombre + " (nivel " + nivel + ")");
        // Explorar todos los vecinos no visitados
        for (int j = 0; j < cantidadEstaciones; j++) {
            if (matrizAdyacencia[indiceActual][j] == 1 && !estaciones[j].visitada) {
                dfsRecursivo(j, nivel + 1);
            }
        }
    }

    // Recorrido por anchura (BFS) desde la estacion indicada.
    // Explora todos los vecinos directos antes de pasar al siguiente nivel.
    // Implementado con cola propia (arreglo) sin usar Queue de Java.
    public void recorridoAnchura(String nombreInicio) {
        int indiceInicio = buscarIndice(nombreInicio);
        if (indiceInicio == -1) {
            System.out.println("Error: la estacion '" + nombreInicio + "' no existe.");
            return;
        }
        reiniciarVisitadas();
        System.out.println("\n===== RECORRIDO POR ANCHURA - BFS DESDE " + nombreInicio.toUpperCase() + " =====");

        // Cola implementada con arreglo propio (sin usar Queue de Java)
        int[] cola = new int[MAX_ESTACIONES];
        int frente = 0;
        int fin = 0;

        // Encolar la estacion de inicio
        cola[fin] = indiceInicio;
        fin++;
        estaciones[indiceInicio].visitada = true;

        int nivelActual = 0;
        int nodosEnNivelActual = 1;
        int nodosEnSiguienteNivel = 0;

        while (frente < fin) {
            int indiceActual = cola[frente];
            frente++;
            nodosEnNivelActual--;

            String indentacion = "  ".repeat(nivelActual);
            System.out.println(indentacion + "-> " + estaciones[indiceActual].nombre + " (nivel " + nivelActual + ")");

            // Encolar todos los vecinos no visitados
            for (int j = 0; j < cantidadEstaciones; j++) {
                if (matrizAdyacencia[indiceActual][j] == 1 && !estaciones[j].visitada) {
                    estaciones[j].visitada = true;
                    cola[fin] = j;
                    fin++;
                    nodosEnSiguienteNivel++;
                }
            }
            // Actualizar nivel cuando se terminan los nodos del nivel actual
            if (nodosEnNivelActual == 0) {
                nivelActual++;
                nodosEnNivelActual = nodosEnSiguienteNivel;
                nodosEnSiguienteNivel = 0;
            }
        }
        System.out.println();
    }

    // Permite al usuario seleccionar una estacion por numero.
    // Retorna el nombre de la estacion seleccionada, o null si el numero es invalido.
    public String seleccionarEstacionPorNumero(Scanner sc) {
        mostrarEstaciones();
        System.out.print("Seleccione el numero de la estacion: ");
        if (sc.hasNextInt()) {
            int numero = sc.nextInt();
            sc.nextLine();
            if (numero >= 1 && numero <= cantidadEstaciones) {
                return estaciones[numero - 1].nombre;
            } else {
                System.out.println("Error: numero invalido.");
                return null;
            }
        } else {
            System.out.println("Error: ingrese un numero entero.");
            sc.next();
            return null;
        }
    }
}
