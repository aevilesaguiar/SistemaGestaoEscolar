package com.treinamento.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(name = "id_empresa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;

    @Column(name = "nome_empresa",length = 120)
    private String nome;

    // lado forte do relacionamento
   // chave estrangeira fica do outro lado
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy ="empresa" )//se remover a empresa remove todas as unidades
    private List<Unidade> unidades;


    public Empresa() {
    }

    public Empresa(String nome, List<Unidade> unidades) {
        this.nome = nome;
        this.unidades = unidades;
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


    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
