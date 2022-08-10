package com.treinamento.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "semestre")
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "periodo_curso", nullable = false)
    private String periodo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "curso_semestre")
    private Curso curso;



    @OneToMany(mappedBy = "semestre")
    private List<Disciplina> disciplinas=new ArrayList<>();


    public Semestre() {
    }

    public Semestre(String periodo, Curso curso, List<Disciplina> disciplinas) {
        this.periodo = periodo;
        this.curso = curso;
        this.disciplinas = disciplinas;
    }

    public Semestre(String periodo, List<Disciplina> disciplinas) {
        this.periodo = periodo;
        this.disciplinas = disciplinas;
    }

    public Semestre(String periodo) {
        this.periodo = periodo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semestre that = (Semestre) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
