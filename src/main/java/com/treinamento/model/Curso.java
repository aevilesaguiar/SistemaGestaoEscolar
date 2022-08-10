package com.treinamento.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "curso")
public class Curso {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_curso",nullable = false)
    private String nomeCurso;



    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "curso_unidade")
    private List<Unidade> unidade;


    @OneToMany(mappedBy = "disciplinas",cascade = CascadeType.PERSIST)
    private List<Semestre> semestreList= new ArrayList<>();

    public Curso() {
    }

    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public List<Unidade> getUnidade() {
        return unidade;
    }

    public void setUnidade(List<Unidade> unidade) {
        this.unidade = unidade;
    }


    public List<Semestre> getSemestreList() {
        return semestreList;
    }

    public void setSemestreList(List<Semestre> semestreList) {
        this.semestreList = semestreList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
