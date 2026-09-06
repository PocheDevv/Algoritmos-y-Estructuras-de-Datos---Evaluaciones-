package com.trust.pa2_rosas_del_aguila;
import java.util.HashSet;

public class PA2_Rosas_Del_Aguila {

    HashSet<Curso> hashSet;

    public PA2_Rosas_Del_Aguila() {
        this.hashSet = new HashSet<>();
    }

    public static void main(String[] args) {

        PA2_Rosas_Del_Aguila app = new PA2_Rosas_Del_Aguila();

        // R01: Crear el HashSet
        System.out.println("R01: Crear el HashSet");
        // R02: Crear los cursos
        System.out.println("\nR02: Crear los cursos");
        Curso curso1 = new Curso("PG101", "Programacion I");
        Curso curso2 = new Curso("PG102", "Programacion II");
        Curso curso3 = new Curso("BD201", "Bases de Datos I");
        Curso curso4 = new Curso("BD202", "Bases de Datos II");
        Curso curso5 = new Curso("SI301", "Analisis de Sistemas");

        // R03: Agregar los cursos al HashSet
        System.out.println("\nR03: Agregar los cursos al HashSet");
        app.hashSet.add(curso1);
        app.hashSet.add(curso2);
        app.hashSet.add(curso3);
        app.hashSet.add(curso4);
        app.hashSet.add(curso5);

        // R04: Agregar nuevamente el curso 3 al HashSet y validar la operacion
        System.out.println("\nR04: Agregar nuevamente el curso 3 al HashSet y validar la operacion");
        boolean agregado = app.hashSet.add(curso3);
        if (agregado) {
            System.out.println("El curso se agrego correctamente");
        } else {
            System.out.println("El curso no se agrego porque ya fue registrado");
        }
        app.mostrarHashSet();

        // R05: Mostrar el contenido del HashSet
        System.out.println("\nR05: Mostrar el contenido del HashSet");
        app.mostrarHashSet();

        // R06: Mostrar la cantidad de cursos registrados en el HashSet
        System.out.println("\nR06: Mostrar la cantidad de cursos registrados en el HashSet");
        System.out.println("Cantidad de cursos: " + app.hashSet.size());

        // R07: Buscar un curso por su codigo y mostrarlo (BD201)
        System.out.println("\nR07: Buscar un curso por su codigo y mostrarlo");
        Curso cursoBuscado = app.buscarCurso("BD201");
        if (cursoBuscado != null) {
            System.out.println(cursoBuscado.toString());
        } else {
            System.out.println("Curso no registrado");
        }

        // R08: Buscar un curso no registrado (BD701)
        System.out.println("\nR08: Buscar un curso no registrado");
        Curso cursoNoRegistrado = app.buscarCurso("BD701");
        if (cursoNoRegistrado != null) {
            System.out.println(cursoNoRegistrado.toString());
        } else {
            System.out.println("Curso no registrado");
        }

        // R09: Actualizar el nombre del curso SI301
        System.out.println("\nR09: Actualizar el nombre de un curso y validar la operacion");
        boolean actualizado = app.actualizarNombre("SI301", "Introduccion al Analisis de Sistemas");
        if (actualizado) {
            System.out.println("Nombre actualizado correctamente");
        } else {
            System.out.println("Curso no registrado, no se pudo actualizar");
        }
        app.mostrarHashSet();

        // R10: Eliminar un curso ubicandolo por su codigo
        System.out.println("\nR10: Eliminar un curso ubicandolo por su codigo");
        boolean eliminado = app.eliminarCurso("PG102");
        if (eliminado) {
            System.out.println("Curso eliminado correctamente");
        } else {
            System.out.println("Curso no registrado, no se pudo eliminar");
        }
        app.mostrarHashSet();
    }

    // Mostrar el contenido del HashSet
    public void mostrarHashSet() {
        for (Curso curso : hashSet) {
            System.out.println(curso.toString());
        }
    }

    // Buscar un curso por su codigo: retorna el curso
    public Curso buscarCurso(String codigo) {
        for (Curso curso : hashSet) {
            if (curso.codigo.equals(codigo)) {
                return curso;
            }
        }
        return null;
    }

    // Actualizar el nombre de un curso: retorna true si se actualizo
    public boolean actualizarNombre(String codigo, String nuevoNombre) {
        Curso curso = buscarCurso(codigo);
        if (curso != null) {
            curso.nombre = nuevoNombre;
            return true;
        }
        return false;
    }

    // Eliminar un curso: retorna true si se elimino
    public boolean eliminarCurso(String codigo) {
        Curso curso = buscarCurso(codigo);
        if (curso != null) {
            hashSet.remove(curso);
            return true;
        }
        return false;

    }
}