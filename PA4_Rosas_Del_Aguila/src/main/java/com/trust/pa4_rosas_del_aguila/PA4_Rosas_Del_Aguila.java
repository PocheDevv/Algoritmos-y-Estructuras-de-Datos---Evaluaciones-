package com.trust.pa4_rosas_del_aguila;

import java.util.Scanner;

public class PA4_Rosas_Del_Aguila {
    
    // Sistema de gestion de colas para una institucion del sector privado.
    // Simula la atencion de clientes mediante tickets numerados,
    // distribuidos entre V ventanillas en orden rotativo (FIFO).

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ── Configuración inicial del sistema ──────────────────────
        System.out.println("=== SISTEMA DE GESTION DE COLAS ===");
        System.out.println("Configuracion inicial del sistema:");

        // Validar número de trabajadores (T)
        int T = 0;
        do {
            System.out.print("Ingrese el numero de trabajadores (T > 0): ");
            if (sc.hasNextInt()) {
                T = sc.nextInt();
                if (T <= 0) System.out.println("Error: T debe ser mayor a 0.");
            } else {
                System.out.println("Error: ingrese un numero entero.");
                sc.next();
            }
        } while (T <= 0);

        // Validar aforo del local (A)
        int A = 0;
        do {
            System.out.print("Ingrese el aforo del local (A > 0): ");
            if (sc.hasNextInt()) {
                A = sc.nextInt();
                if (A <= 0) System.out.println("Error: A debe ser mayor a 0.");
            } else {
                System.out.println("Error: ingrese un numero entero.");
                sc.next();
            }
        } while (A <= 0);

        // Validar número de ventanillas (V <= T)
        int V = 0;
        do {
            System.out.print("Ingrese el numero de ventanillas (1 <= V <= " + T + "): ");
            if (sc.hasNextInt()) {
                V = sc.nextInt();
                if (V <= 0 || V > T) {
                    System.out.println("Error: V debe ser mayor a 0 y no mayor a T (" + T + ").");
                }
            } else {
                System.out.println("Error: ingrese un numero entero.");
                sc.next();
            }
        } while (V <= 0 || V > T);

        System.out.println("\nSistema configurado: T=" + T + " trabajadores, aforo=" + A + ", V=" + V + " ventanillas.");

        // Cola de atención
        Cola cola = new Cola();

        // Ventanilla actual (rotación del 1 a V)
        int ventanillaActual = 1;

        // ── Menú principal ─────────────────────────────────────────
        int opcion = 0;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Registrar cliente (colar)");
            System.out.println("2. Atender siguiente cliente (desencolar)");
            System.out.println("3. Ver clientes en espera (mostrar cola)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion (1-4): ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        // Verificar si hay espacio en el local (aforo)
                        if (cola.cantidadEnCola() >= A) {
                            System.out.println("El local esta lleno (aforo maximo: " + A + "). El cliente debe esperar afuera.");
                        } else {
                            int ticket = cola.colar();
                            System.out.println("Cliente registrado. Ticket asignado: #" + ticket);
                            System.out.println("Clientes en cola: " + cola.cantidadEnCola());
                        }
                        break;
                    case 2:
                        // Atender al siguiente cliente
                        int ticket = cola.desencolar();
                        if (ticket != -1) {
                            System.out.println("Ticket #" + ticket + " -> Ventanilla " + ventanillaActual);
                            // Rotar ventanilla
                            ventanillaActual++;
                            if (ventanillaActual > V) {
                                ventanillaActual = 1;
                            }
                            System.out.println("Clientes restantes en cola: " + cola.cantidadEnCola());
                        }
                        break;
                    case 3:
                        // Mostrar todos los tickets en espera
                        cola.mostrarCola();
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion invalida. Seleccione entre 1 y 4.");
                }
            } else {
                System.out.println("Error: ingrese un numero entero.");
                sc.next();
            }
        } while (opcion != 4);

        sc.close();
    }
}