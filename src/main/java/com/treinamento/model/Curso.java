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

    @ManyToMany(mappedBy = "cursos")
    private List<Unidade> unidades;


    @OneToMany(mappedBy = "curso", cascade = CascadeType.PERSIST)
    private List<Semestre> semestres;



    public Curso() {
    }



    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }
}
