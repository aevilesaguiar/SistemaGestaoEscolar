package com.treinamento.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cadastro_curso")
public class Curso {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_curso",nullable = false)
    private String nomeCurso;

    @Column(name = "hora_aula", nullable = false)
    private String horas;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "unidade_id")
    private List<Unidade> unidadeList;

    @ManyToMany(mappedBy = "curso",cascade = CascadeType.PERSIST)//quando eu sal
    private List<Aluno> alunos=new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "curso_semestre")
    List <Semestre> semestres;

    public Curso() {
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

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
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
