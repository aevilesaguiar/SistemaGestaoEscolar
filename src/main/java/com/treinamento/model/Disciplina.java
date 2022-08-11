package com.treinamento.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_disciplina", nullable = false)
    private String disciplina;


    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;



    public Disciplina() {
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

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
}
