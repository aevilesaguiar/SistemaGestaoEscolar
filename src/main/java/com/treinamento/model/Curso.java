package com.treinamento.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;

    @Column(name = "nome_curso",nullable = false)
    private String nomeCurso;

    @ManyToMany(mappedBy = "cursos")
    private List<Unidade> unidades;


    @OneToMany(mappedBy = "curso", cascade = CascadeType.PERSIST)
    private List<PeriodoCurso> periodoCursos;



    public Curso() {
    }

    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }

    public List<PeriodoCurso> getPeriodoCursos() {
        return periodoCursos;
    }

    public void setPeriodoCursos(List<PeriodoCurso> periodoCursos) {
        this.periodoCursos = periodoCursos;
    }

}
