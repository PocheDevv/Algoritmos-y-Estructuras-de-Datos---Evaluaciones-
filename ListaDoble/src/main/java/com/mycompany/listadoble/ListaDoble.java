package com.mycompany.listadoble;

public class ListaDoble {

    Nodo nodoInicio;
    
    public ListaDoble() {
        this.nodoInicio = null;
    }
    
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();
        
        // Agregar el primer nodo y mostrarlo
        Nodo primerNodo = new Nodo(10, "Arenas, Juan");
        if (lista.listaVacia()) {
            System.out.println("INSERTANDO EL PRIMER NODO DE LA LISTA");
            //primerNodo.nodoSiguiente = null;
            //primerNodo.nodoAnterior = null;
            lista.nodoInicio = primerNodo;
            lista.muestraLista();
        }
        
        // Insertamos nodos al inicio de la lista
        System.out.println("\nINSERTANDO NODOS AL INICIO DE LA LISTA");
        lista.insertaAlInicio(5, "Cabanillas, Julia");
        lista.insertaAlInicio(3, "Campuzano, Pablo");
        lista.muestraLista();

        // Insertamos entre nodos
        System.out.println("\nINSERTANDO ENTRE NODOS");
        lista.insertaEntreNodos(4, "Norabuena, Ana");
        lista.muestraLista();
        
        // Insertamos entre nodos
        System.out.println("\nINSERTANDO ENTRE NODOS");
        lista.insertaEntreNodos(7, "Egoavil, Carlos");
        lista.muestraLista();
        
        // Insertamos entre nodos, pero el nodo buscado no existe
        System.out.println("\nINSERTANDO ENTRE NODOS - NODO NO EXISTE");
        lista.insertaEntreNodos(15, "Torres, Juan");
        lista.muestraLista();

        // Insertamos entre nodos
        System.out.println("\nINSERTANDO ENTRE NODOS");
        lista.insertaEntreNodos(13, "Macuri, Antonio");
        lista.muestraLista();

        // Insertamos nodos al final de la lista
        System.out.println("\nINSERTANDO NODOS AL FINAL DE LA LISTA");
        lista.insertaAlFinal(20, "Castro, Rosa");
        lista.insertaAlFinal(30, "Matos, Carlos");
        lista.muestraLista();
     
        // Eliminamos el nodo inicial
        System.out.println("\nELIMINANDO EL NODO INICIAL");
        lista.eliminaNodoInicial();
        lista.muestraLista();
        
        // Eliminamos el nodo final
        System.out.println("\nELIMINANDO EL NODO FINAL");
        lista.eliminaNodoFinal();
        lista.muestraLista();
        
        // Eliminamos un nodo por su codigo
        System.out.println("\nELIMINANDO UN NODO POR SU CODIGO");
        lista.eliminaNodoCodigo(13);
        lista.muestraLista();
        
    }
    
    
    // MÉTODOS
    
    // Verifica si la lista está vacía
    public boolean listaVacia() {
        return nodoInicio == null;
    }
    
    // Muestra la lista
    public void muestraLista() {
        if (listaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo nodoActual = nodoInicio;
            while (nodoActual != null) {
                System.out.println(nodoActual.toString());
                nodoActual = nodoActual.nodoSiguiente;
            }
        }
    }

    // Inserta un nodo al inicio de la lista
    public void insertaAlInicio(int codigo, String nombre) {
        Nodo nodoNuevo = new Nodo(codigo, nombre);
        if (listaVacia()) {
            nodoInicio = nodoNuevo;
        } else {
            nodoNuevo.nodoSiguiente = nodoInicio;
            nodoInicio.nodoAnterior = nodoNuevo;
            nodoNuevo.nodoAnterior = null;
            nodoInicio = nodoNuevo;
        }
    }
    
    // Inserta un nodo entre dos nodos
    public void insertaEntreNodos(int codigo, String nombre) {
        Nodo nodoNuevo = new Nodo(codigo, nombre);
        
        if (listaVacia()) {
            nodoInicio = nodoNuevo;
        } else {
            Nodo nodoActual = nodoInicio;
            Nodo nodoPrevio = nodoInicio;
            while (nodoActual.codigo < nodoNuevo.codigo || nodoActual == null) {
                
                nodoPrevio = nodoActual;
                
                nodoActual = nodoActual.nodoSiguiente;
                if (nodoActual == null) {
                    nodoPrevio.nodoSiguiente = nodoNuevo;
                    nodoNuevo.nodoAnterior = nodoPrevio;    
                    return;
                }
            }
            nodoPrevio = nodoActual.nodoAnterior;
            nodoPrevio.nodoSiguiente = nodoNuevo;
            nodoNuevo.nodoAnterior = nodoPrevio;
            nodoNuevo.nodoSiguiente = nodoActual;
            nodoActual.nodoAnterior = nodoNuevo;
        }
    }
    
    // Inserta un nodo al final de la lista
    public void insertaAlFinal(int codigo, String nombre) {
        Nodo nodoNuevo = new Nodo(codigo, nombre);
        if (listaVacia()) {
            nodoInicio = nodoNuevo;
        } else {
            Nodo nodoActual = nodoInicio;
            while (nodoActual.nodoSiguiente != null) {
                nodoActual = nodoActual.nodoSiguiente;
            }
            nodoActual.nodoSiguiente = nodoNuevo;
            nodoNuevo.nodoAnterior = nodoActual;
            nodoNuevo.nodoSiguiente = null;
        }
    }

    // Elimina un nodo del inicio de la lista
    public void eliminaNodoInicial() {
        if (listaVacia()) {
            System.out.println("La lista está vacia");
        } else {
            nodoInicio = nodoInicio.nodoSiguiente;
        }
    }
    
    // Elimina un nodo del final de la lista
    public void eliminaNodoFinal() {
        if (listaVacia()) {
            System.out.println("La lista está vacia");
        } else {
            Nodo nodoActual = nodoInicio;
            while (nodoActual.nodoSiguiente.nodoSiguiente != null) {
                nodoActual = nodoActual.nodoSiguiente;
            }
            nodoActual.nodoAnterior = null;
            nodoActual.nodoSiguiente = null;
        }
    }
    
    // Elimina un nodo por su codigo
    public void eliminaNodoCodigo(int codigo) {
        Nodo nodoActual = nodoInicio;
        while (nodoActual.codigo < codigo) {
            nodoActual = nodoActual.nodoSiguiente;
        }
        if (nodoActual.codigo != codigo) {
            System.out.println("El nodo a eliminar no existe");
        } else {
            Nodo nodoPrevio = nodoActual.nodoAnterior;
            nodoPrevio.nodoSiguiente = nodoActual.nodoSiguiente;
            nodoActual.nodoSiguiente.nodoAnterior = nodoPrevio;
            nodoActual.nodoSiguiente = null;
            nodoActual.nodoAnterior = null;
        }
    }
    

}





