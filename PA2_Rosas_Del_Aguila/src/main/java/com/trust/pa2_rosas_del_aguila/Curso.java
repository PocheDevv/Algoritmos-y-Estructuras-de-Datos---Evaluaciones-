package com.trust.pa2_rosas_del_aguila;
import java.util.Objects;
public class Curso {

    String codigo;
    String nombre;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // HashSet usa equals y hashCode para detectar duplicados
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Curso curso = (Curso) obj;
        return Objects.equals(codigo, curso.codigo);
    }

    public int hashCode() {
        return Objects.hash(codigo);
    }

    public String toString() {
        return codigo + " - " + nombre;
    }
}
