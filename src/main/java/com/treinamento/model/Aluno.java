package com.treinamento.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @Column(name = "cod_aluno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo_aluno", nullable = false)
    private String nomeCompleto;

    @Column(name = "matricula", nullable = false, length = 10)
    private String matricula;

    @Column(name = "sexo_aluno")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;



    @ManyToMany(mappedBy = "alunos") //
    private List<Unidade> unidades;


    public Aluno() {
    }

    public Aluno(String nomeCompleto, String matricula, Sexo sexo) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.sexo = sexo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
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


    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
