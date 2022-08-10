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

    @Column(name = "endereco", length = 180)
    private String enderecoo;

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

    public Unidade(String enderecoo) {
        this.enderecoo = enderecoo;
    }

    public Unidade(String enderecoo, Empresa empresa, List<Aluno> alunos, List<Professor> professores, List<Curso> cursos) {
        this.enderecoo = enderecoo;
        this.empresa = empresa;
        this.alunos = alunos;
        this.professores = professores;
        this.cursos = cursos;
    }

    public String getEnderecoo() {
        return enderecoo;
    }

    public void setEnderecoo(String enderecoo) {
        this.enderecoo = enderecoo;
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