package com.treinamento.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cadastro_unidade_escolar")
public class UnidadeEscolar {

    @Id
    @Column(name = "id_unidade_escolar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;

    @Column(name = "nome_unidade_escolar", length = 180)
    private String nome;

    @Column(name = "nome_diretor", length = 100)
    private String nomeDiretor;

    @Column(name = "telefone_unidade_escolar", length = 11)
    private String telefone;

    @Column(name = "endereço_unidade_escola", length = 160)
    private String endereco;

    @Column(name = "email_empresa", length = 80)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "empresa_unidade_escolar")
    private Empresa empresa;

    @ManyToMany(mappedBy = "unidadesEscolares")
    private List<Aluno> alunos;

    @ManyToMany(mappedBy = "unidEscolares")
    private List<Professor> professores;





    public UnidadeEscolar() {
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

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
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
        UnidadeEscolar that = (UnidadeEscolar) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}