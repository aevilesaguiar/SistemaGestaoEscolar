package com.treinamento.model;


import javax.persistence.*;

@Entity
@Table(name = "tab_disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_disciplina", nullable = false, length = 150)
    private String disciplina;


    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private PeriodoCurso periodoCurso;



    public Disciplina() {
    }

    public Disciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
