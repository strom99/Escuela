package Modelo;

import java.util.Objects;

public class Estudiante {
    private String name;
    private int edad;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Estudiante(String name) {
        this.name = name;
    }

    public Estudiante(String name, int edad) {
        this.name = name;
        this.edad = edad;
    }
    // hash(funcion de resumen) , transformacion a bytes
    // hascode ->
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (!Objects.equals(this.hashCode(), other.hashCode())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "name=" + name + ", edad=" + edad + '}';
    }
    
    
    
    
    
    
}
