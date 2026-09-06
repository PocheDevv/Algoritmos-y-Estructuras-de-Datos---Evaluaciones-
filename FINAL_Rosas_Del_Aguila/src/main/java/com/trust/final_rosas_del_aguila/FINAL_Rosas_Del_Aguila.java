package com.trust.final_rosas_del_aguila;

import java.util.Scanner;

public class FINAL_Rosas_Del_Aguila {

    // Sistema de gestion de estaciones para la empresa TrenRapido de la ciudad de Sanliqui.
    // Permite registrar estaciones y conexiones, visualizar la red mediante una matriz
    // de adyacencia, y ejecutar recorridos DFS y BFS desde cualquier estacion.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GrafoTren grafo = new GrafoTren();

        // ── Registro inicial de estaciones y conexiones de TrenRapido ──
        System.out.println("===== SISTEMA DE GESTION DE ESTACIONES - TRENRAPIDO SANLIQUI =====");
        System.out.println("\nCargando estaciones y conexiones iniciales...");

        // Estaciones actuales en operacion
        grafo.agregarEstacion("Central", true);
        grafo.agregarEstacion("Norte", true);
        grafo.agregarEstacion("Sur", true);
        grafo.agregarEstacion("Este", true);
        grafo.agregarEstacion("Aeropuerto", true);

        // Conexiones actuales (bidireccionales)
        grafo.agregarConexion("Central", "Norte");
        grafo.agregarConexion("Central", "Sur");
        grafo.agregarConexion("Central", "Este");
        grafo.agregarConexion("Aeropuerto", "Norte");
        grafo.agregarConexion("Aeropuerto", "Este");

        System.out.println("\nSistema listo. La estacion Oeste aun no esta en operacion.");

        // Bandera para controlar si la estacion Oeste ya fue habilitada
        boolean oesteHabilitada = false;

        // ── Menu principal ─────────────────────────────────────────────
        int opcion = 0;
        do {
            System.out.println("\n================ MENU ================");
            System.out.println("1. Mostrar estaciones registradas");
            System.out.println("2. Registrar nueva estacion");
            System.out.println("3. Registrar nueva conexion");
            System.out.println("4. Mostrar matriz de adyacencia");
            System.out.println("5. Mostrar conexiones de una estacion");
            System.out.println("6. Recorrido en profundidad - DFS");
            System.out.println("7. Recorrido por anchura - BFS");
            System.out.println("8. Simular apertura estacion Oeste (2 anos despues)");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion (1-9): ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        // Mostrar todas las estaciones registradas con su estado
                        grafo.mostrarEstaciones();
                        break;

                    case 2:
                        // Registrar una nueva estacion desde el menu
                        System.out.print("Ingrese el nombre de la nueva estacion: ");
                        String nuevaEstacion = sc.nextLine().trim();
                        grafo.agregarEstacion(nuevaEstacion, true);
                        break;

                    case 3:
                        System.out.println("Primera estacion:");
                        String est1 = grafo.seleccionarEstacionPorNumero(sc);
                        if (est1 == null) {
                            break;
                        }
                        System.out.println("Segunda estacion:");
                        String est2 = grafo.seleccionarEstacionPorNumero(sc);
                        if (est2 == null) {
                            break;
                        }
                        grafo.agregarConexion(est1, est2);
                        break;

                    case 4:
                        // Mostrar la matriz de adyacencia completa
                        grafo.mostrarMatrizAdyacencia();
                        break;

                    case 5:
                        // Mostrar todas las conexiones directas de una estacion seleccionada
                        String estConexion = grafo.seleccionarEstacionPorNumero(sc);
                        if (estConexion == null) {
                            break;
                        }
                        grafo.mostrarConexionesEstacion(estConexion);
                        break;

                    case 6:
                        // Recorrido en profundidad (DFS): explora cada rama completamente
                        // antes de retroceder hacia otros caminos (backtracking)
                        String estDfs = grafo.seleccionarEstacionPorNumero(sc);
                        if (estDfs == null) {
                            break;
                        }
                        grafo.recorridoProfundidad(estDfs);
                        break;

                    case 7:
                        // Recorrido por anchura (BFS): explora primero todas las estaciones
                        // directamente conectadas antes de pasar al siguiente nivel
                        String estBfs = grafo.seleccionarEstacionPorNumero(sc);
                        if (estBfs == null) {
                            break;
                        }
                        grafo.recorridoAnchura(estBfs);
                        break;
                    case 8:
                        // Simular que han pasado 2 anos y la estacion Oeste entra en operacion
                        if (oesteHabilitada) {
                            System.out.println("La estacion Oeste ya esta en operacion.");
                        } else {
                            System.out.println("\n>>> Han transcurrido 2 anos: la estacion Oeste entra en operacion <<<");
                            grafo.agregarEstacion("Oeste", true);
                            grafo.agregarConexion("Aeropuerto", "Oeste");
                            grafo.agregarConexion("Sur", "Oeste");
                            oesteHabilitada = true;
                            System.out.println("La estacion Oeste y sus conexiones han sido registradas.");
                            grafo.mostrarMatrizAdyacencia();
                        }
                        break;

                    case 9:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion invalida. Seleccione entre 1 y 9.");
                }
            } else {
                System.out.println("Error: ingrese un numero entero.");
                sc.next();
            }

        } while (opcion != 9);

        sc.close();
    }
}