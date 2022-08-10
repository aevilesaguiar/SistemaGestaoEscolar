package com.treinamento.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "unidade")
public class Unidade {

    @Id
    @Column(name = "id_unidade_escolar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;

    @Column(name = "nome_unidade_escolar", length = 180)
    private String nome;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "empresa_id" )
    private Empresa empresa;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "aluno_unidade")
    private List<Aluno>alunos;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "professor_unidade")
    private List<Professor> professores;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "curso_unidade")
    private List<Curso> cursos;

    public Unidade() {
    }

    public Unidade(String nome, Empresa empresa) {
        this.nome = nome;
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }



    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unidade that = (Unidade) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}