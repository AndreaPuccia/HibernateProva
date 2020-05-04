package com.andrea.puccia;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matricola;
    private String nome;
    private String cognome;

    public long getMatricola() {
        return matricola;
    }

    public void setMatricola(long matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public String toString() {
        return "Student{" +
                "matricola=" + matricola +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return matricola == student.matricola &&
                Objects.equals(nome, student.nome) &&
                Objects.equals(cognome, student.cognome);
    }

}

