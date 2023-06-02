package com.utap.library;

public class materiasEstudiantes {

    private int Id;

    private int IdMateria;

    private boolean nota1;

    private boolean nota2;
    private boolean nota3;
    private boolean notaf;

    public materiasEstudiantes(int id, int idMateria, boolean nota1, boolean nota2, boolean nota3, boolean notaf) {
        Id = id;
        IdMateria = idMateria;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.notaf = notaf;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(int idMateria) {
        IdMateria = idMateria;
    }

    public boolean isNota1() {
        return nota1;
    }

    public void setNota1(boolean nota1) {
        this.nota1 = nota1;
    }

    public boolean isNota2() {
        return nota2;
    }

    public void setNota2(boolean nota2) {
        this.nota2 = nota2;
    }

    public boolean isNota3() {
        return nota3;
    }

    public void setNota3(boolean nota3) {
        this.nota3 = nota3;
    }

    public boolean isNotaf() {
        return notaf;
    }

    public void setNotaf(boolean notaf) {
        this.notaf = notaf;
    }
}
