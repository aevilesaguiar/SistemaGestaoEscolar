package com.treinamento.model;

import javax.persistence.*;
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

    @Column(name = "data_de_aniversario", length = 10)
    private String dataAniversario;

    @Column(name = "registro_geral", length = 12)
    private String rg;

    @Column(name = "cpf_professor", length = 14)
    private String cpf;

    @Column(name = "endereco_professor", length = 150)
    private String endereco;

    @Column(name = "telefone_professor")
    private  String telefone;

    @Column(name = "email_professor")
    private  String email;

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

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
