package com.treinamento.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cadastro_professor")
public class Professor {

    @Id
    @Column(name = "cod_professor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo_professor")
    private String nomeCompleto;

    @Column(name = "sexo_professor", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "formacao", nullable = false)
    @Enumerated(EnumType.STRING)
    private Graduacao formacaoBasica;

    @Column(name = "especializacao", nullable = true)
    @Enumerated(EnumType.STRING)
    private Especializacao formacaoPlus;


    @Column(name = "endereco_professor", length = 150)
    private String endereco;

    @Column(name = "email_professor")
    private  String email;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "professor_unidade")
    private List<Unidade> unidades=new ArrayList<>();


    public Professor() {
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

    public Graduacao getFormacaoBasica() {
        return formacaoBasica;
    }

    public void setFormacaoBasica(Graduacao formacaoBasica) {
        this.formacaoBasica = formacaoBasica;
    }

    public Especializacao getFormacaoPlus() {
        return formacaoPlus;
    }

    public void setFormacaoPlus(Especializacao formacaoPlus) {
        this.formacaoPlus = formacaoPlus;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
