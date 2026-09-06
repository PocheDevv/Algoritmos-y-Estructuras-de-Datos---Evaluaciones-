package com.trust.pa3_rosas_del_aguila;

public class PA3_Rosas_Del_Aguila {

    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        // R1: Insertar al inicio los valores 20 y 10 (en este orden)
        System.out.println("R1: Insertar al inicio los valores 20 y 10");
        lista.insertarInicio(20);
        lista.insertarInicio(10);
        
        // R2: Insertar al final los valores 30 y 40 (en este orden)
        System.out.println("R2: Insertar al final los valores 30 y 40");
        lista.insertarFinal(30);
        lista.insertarFinal(40);
        
        // R3: Mostrar la lista hacia adelante
        System.out.println("R3: Mostrar la lista hacia adelante");
        lista.mostrarAdelante();
        
        // R4: Mostrar la lista hacia atrás
        System.out.println("R4: Mostrar la lista hacia atras");
        lista.mostrarAtras();
        
        // R5: Buscar los valores 30 y 99
        System.out.println("R5: Buscar los valores 30 y 99");
        if (lista.buscar(30)) {
            System.out.println("El valor 30 si se encuentra en la lista");
        } else {
            System.out.println("El valor 30 no se encuentra en la lista");
        }
        if (lista.buscar(99)) {
            System.out.println("El valor 99 si se encuentra en la lista");
        } else {
            System.out.println("El valor 99 no se encuentra en la lista");
        }
        
        // R6: Eliminar el valor 20 y mostrar la lista
        System.out.println("R6: Eliminar el valor 20");
        if (lista.eliminarValor(20)) {
            System.out.println("Valor 20 eliminado correctamente");
        } else {
            System.out.println("El valor 20 no se encontro");
        }
        lista.mostrarAdelante();
    
        // R7: Eliminar el inicio y el final, mostrar lista y tamaño
        System.out.println("R7: Eliminar el inicio y el final de la lista");
        System.out.println("Elemento eliminado del inicio: " + lista.eliminarInicio());
        System.out.println("Elemento eliminado del final: " + lista.eliminarFinal());
        lista.mostrarAdelante();
        System.out.println("Numero de elementos: " + lista.numeroElementos());
        
        // R8: Casos limite
        System.out.println("R8: Casos limite");

        // Eliminar el unico elemento que queda
        lista.eliminarInicio();

        // Intentar eliminar en lista vacia
        System.out.println("Intentando eliminar inicio en lista vacia:");
        lista.eliminarInicio();

        System.out.println("Intentando eliminar final en lista vacia:");
        lista.eliminarFinal();

        // Intentar eliminar un valor que no existe
        System.out.println("Intentando eliminar el valor 99 (no existe):");
        if (lista.eliminarValor(99)) {
            System.out.println("Valor 99 eliminado");
        } else {
            System.out.println("El valor 99 no se encontro en la lista");
        }
    }
}
