package com.treinamento.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "unidade")
public class Unidade {

    @Id
    @Column(name = "id_unidade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;

    @Column(name = "nome_unidade", length = 180)
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "unidade_aluno")
    private List<Aluno> alunos;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "unidade_professor")
    private List<Professor> professores;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "cursos")
    private List<Curso> cursos;

    public Unidade() {
    }

    public Unidade(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }


}