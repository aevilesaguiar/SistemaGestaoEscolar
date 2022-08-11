package com.treinamento.model;


import javax.persistence.*;

@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;

    @Column(name = "nome_disciplina", nullable = false)
    private String disciplina;


    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private PeriodoCurso periodoCurso;



    public Disciplina() {
    }

    public Disciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public PeriodoCurso getSemestre() {
        return periodoCurso;
    }

    public void setSemestre(PeriodoCurso periodoCurso) {
        this.periodoCurso = periodoCurso;
    }

    public PeriodoCurso getPeriodoCurso() {
        return periodoCurso;
    }

    public void setPeriodoCurso(PeriodoCurso periodoCurso) {
        this.periodoCurso = periodoCurso;
    }
}
