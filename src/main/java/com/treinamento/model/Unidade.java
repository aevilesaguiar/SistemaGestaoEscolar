package com.treinamento.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cadastro_unidade_escolar")
public class Unidade {

    @Id
    @Column(name = "id_unidade_escolar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;

    @Column(name = "nome_unidade_escolar", length = 180)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "unidades", nullable = false )
    private Empresa empresa=new Empresa();

    @ManyToMany(mappedBy = "unidadeList", cascade = CascadeType.PERSIST)
    private List<Curso> cursos=new ArrayList<>();

    @ManyToMany(mappedBy = "unidades")
    private List<Professor> professores=new ArrayList<>();



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