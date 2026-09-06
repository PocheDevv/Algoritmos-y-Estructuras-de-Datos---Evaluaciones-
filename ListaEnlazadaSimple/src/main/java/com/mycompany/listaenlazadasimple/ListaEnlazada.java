package com.mycompany.listaenlazadasimple;

public class ListaEnlazada {
    
    Nodo nodoInicio;
    
    public ListaEnlazada() {
        this.nodoInicio = null;
    }
    
    public static void main(String[] args) {
        
        // Creamos la lista enlazada
        ListaEnlazada lista = new ListaEnlazada();
        
        // Insertamos nodos a la lista enlazada
        lista.insertarFinal(100, "Leche");
        lista.insertarFinal(200, "Azucar");
        lista.insertarFinal(300, "Cafe");
        
        // Mostramos la lista
        System.out.println("\nLISTA INICIAL");
        lista.mostrarLista();
        
        // Insertamos al inicio de la lista enlazada
        // Pruebe primero con codigo 350
        // Luego pruebe con codigo 90
        lista.insertarInicio(350, "Queso");
        
        // Mostramos la lista
        System.out.println("\nINSERTANDO 350 AL INICIO");
        lista.mostrarLista();
        
        // Insertamos 250 al final
        lista.insertarFinal(250, "Arroz");
        
        // Mostramos la lista
        System.out.println("\nINSERTANDO 250 AL FINAL");
        lista.mostrarLista();
        
        // Insertamos 325 segun ordenamiento del codigo
        lista.insertarOrdenada(325, "Huevos");
        
        // Mostramos la lista
        System.out.println("\nINSERTANDO 325 SEGUN ORDEN CODIGO");
        lista.mostrarLista();
        
        // Buscamos por codigo
        // Probamos con 250 y 275
        System.out.println("\nBUSCANDO POR CODIGO");
        Nodo nodoBuscado = lista.buscarCodigo(275);
        if (nodoBuscado != null) {
            System.out.println(nodoBuscado.toString());
        } else {
            System.out.println("Elemento no registrado");
        }
        
        // Identificamos el nodo inicial de la lista enlazada
        System.out.println("\nNODO INICIAL");
        System.out.println(lista.nodoInicio.toString());
        
        // Modificamos el nombre del codigo 300 de Cafe a Manzanilla
        System.out.println("\nACTUALIZANDO NOMBRE");
        boolean nodoModificado = lista.actualizarNombre(900, "Manzanilla");
        if (nodoModificado) {
            System.out.println("Nombre actualizado");
        } else {
            System.out.println("Elemento no registrado");
        }
        lista.mostrarLista();
        
        // Eliminamos el nodo de codigo 100
        System.out.println("\nELIMINANDO NODO");
        boolean nodoEliminado = lista.eliminarCodigo(100);
        if (nodoEliminado) {
            System.out.println("Nodo eliminado");
        } else {
            System.out.println("Elemento no registrado");
        }
        lista.mostrarLista();
        
        // Contamos los nodos de la lista
        System.out.println("\nCONTANDO NODOS");
        System.out.println("Nodos: " + lista.cantidadNodos());
        
        // Eliminamos el nodo final
        System.out.println("\nELIMINANDO NODO FINAL");
        lista.eliminarFinal();
        lista.mostrarLista();
    }
    

    
    
    
    public void insertarFinal(int codigo, String nombre) {
        Nodo nodoNuevo = new Nodo(codigo, nombre);
        if (listaVacia()) {
            nodoInicio = nodoNuevo;
        } else {
            Nodo nodoActual = nodoInicio;
            while (nodoActual.nodoSiguiente != null) {
                nodoActual = nodoActual.nodoSiguiente;
            }
            nodoActual.nodoSiguiente = nodoNuevo;
        }
    }

    
    public boolean listaVacia() {
        return nodoInicio == null;
    }

    
    public void mostrarLista() {
        if (listaVacia()) {
            System.out.println("La lista está vacía");
        } else {
            Nodo nodoActual = nodoInicio;
            while (nodoActual != null) {
                System.out.println(nodoActual.toString());
                nodoActual = nodoActual.nodoSiguiente;
            }
        }
    }

    
    public void insertarInicio(int codigo, String nombre) {
        Nodo nodoNuevo = new Nodo(codigo, nombre);
        if (listaVacia()) {
            nodoInicio = nodoNuevo;
        } else {
            nodoNuevo.nodoSiguiente = nodoInicio;
            nodoInicio = nodoNuevo;
        }
    }

    
    public void insertarOrdenada(int codigo, String nombre) {
        Nodo nodoNuevo = new Nodo(codigo, nombre);
        if (listaVacia() || codigo < nodoInicio.codigo) {
            nodoNuevo.nodoSiguiente = nodoInicio;
            nodoInicio = nodoNuevo;
        } else {
            Nodo nodoActual = nodoInicio;
            while (nodoActual.nodoSiguiente != null && 
                            nodoActual.nodoSiguiente.codigo < codigo) {
                  nodoActual = nodoActual.nodoSiguiente;  
            }
            nodoNuevo.nodoSiguiente = nodoActual.nodoSiguiente;
            nodoActual.nodoSiguiente = nodoNuevo;
        }
    }
    
    
    public Nodo buscarCodigo(int codigo) {
        Nodo nodoActual = nodoInicio;
        while (nodoActual != null) {
            if (nodoActual.codigo == codigo) {
                return nodoActual;
            }
            nodoActual = nodoActual.nodoSiguiente;
        }
        return null;
    }
    
    
    public boolean actualizarNombre(int codigo, String nuevoNombre) {
        Nodo nodoActual = buscarCodigo(codigo);
        if (nodoActual != null) {
            nodoActual.nombre = nuevoNombre;
            return true;
        }
        return false;
    }
    
    
    public boolean eliminarCodigo(int codigo) {
        if (listaVacia()) {
            return false;
        }
        if (nodoInicio.codigo == codigo) {
            nodoInicio = nodoInicio.nodoSiguiente;
            return true;
        }
        Nodo nodoActual = nodoInicio;
        while (nodoActual.nodoSiguiente != null && 
                        nodoActual.nodoSiguiente.codigo != codigo) {
            nodoActual = nodoActual.nodoSiguiente;
        }
        if (nodoActual.nodoSiguiente != null) {
            nodoActual.nodoSiguiente = nodoActual.nodoSiguiente.nodoSiguiente;
            return true;
        }
        return false;
    }
    
    
    public void eliminarInicio() {
        if (listaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            nodoInicio = nodoInicio.nodoSiguiente;
        }
    }
    
    
    public void eliminarFinal() {
        if (listaVacia()) {
            System.out.println("La lista esta vacia");
        } else if (nodoInicio.nodoSiguiente == null) {
            nodoInicio = null;
        } else {
            Nodo nodoActual = nodoInicio;
            while (nodoActual.nodoSiguiente.nodoSiguiente != null) {
                nodoActual = nodoActual.nodoSiguiente;
            }
            nodoActual.nodoSiguiente = null;
        }
    }
    
       
    public int cantidadNodos() {
        int contador = 0;
        Nodo nodoActual = nodoInicio;
        while (nodoActual != null) {
            contador = contador + 1;
            nodoActual = nodoActual.nodoSiguiente;
        }
        return contador;
    }
    
    
    public void eliminarTodos() {
        nodoInicio = null;
    }
    

    
}
