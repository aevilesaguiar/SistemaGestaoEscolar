package com.treinamento.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @Column(name = "cod_professor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_professor")
    private String nomeCompleto;

    @Column(name = "matricula_professor")
    private String matricula;

    @Column(name = "sexo_professor", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;


    @ManyToMany(mappedBy = "professores")
    private List<Unidade> unidade;



    public Professor() {
    }

    public Professor(String nomeCompleto, String matricula, Sexo sexo) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public List<Unidade> getUnidade() {
        return unidade;
    }

    public void setUnidade(List<Unidade> unidade) {
        this.unidade = unidade;
    }
}
