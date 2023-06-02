package com.utap.library;

public class students {

    private int Id;
    private String Nombre;
    private String Apellido;
    private String Materia;
    private int Nota;

    public students(int Id, String nombre, String apellido, String materia, int nota) {
        this.Id = Id;
        Nombre = nombre;
        Apellido = apellido;
        Materia = materia;
        Nota = nota;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        Materia = materia;
    }

    public int getNota() {
        return Nota;
    }

    public void setNota(int nota) {
        Nota = nota;
    }
}
