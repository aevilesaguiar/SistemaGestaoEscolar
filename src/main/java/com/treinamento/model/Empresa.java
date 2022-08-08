package com.treinamento.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cadastro_empresa")
public class Empresa {

    @Id
    @Column(name = "id_empresa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;

    @Column(name = "nome_empresa",length = 120)
    private String nome;

    @Column(name = "cnpj", length = 19)
    private String cnpj;

    @Column(name = "telefone_empresa", length = 11)
    private String telefone;

    @Column(name = "email_empresa", length = 80)
    private String email;

    @Column(name = "responsavel_empresa" , length = 160)
    private String responsavelEmpresa;

    @Column(name = "endereço_empresa" , length = 160)
    private String endereco;


    public Empresa() {
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getResponsavelEmpresa() {
        return responsavelEmpresa;
    }

    public void setResponsavelEmpresa(String responsavelEmpresa) {
        this.responsavelEmpresa = responsavelEmpresa;
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
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
