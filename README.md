# Criar um sistema para gestão Escolar

## Criar POJO [ok]/DAO[?]

- Empresa [ok][ok]
- unidades escolares [ok]
- Aluno[ok]
- Professor[ok]
- Cursos oferecidos [ok]
- Períodos dos cursos [ok]
- Disciplinas oferecidas [ok]

## Criar 

## Tecnologias

- Java
- JPA
- Hibernate
- MySQL

## Observações

O lado forte/dominante é o lado que ira ter a chave estrangeira do outro no banco de dados.

Em relacionamentos OneToOne, qualquer um dos lados pode ser o dominante.

Em relacionamentos ManyToOne/ OneToMany o lado dominante é sempre o do Many

Em relacionamentos ManyToMany, qualquer um dos lados pode ser dominante , porém ira existir uma nova tabela que liga a 
chave primaria de uma classe com a outra, portanto nenhuma das duas classes tera a chave estrangeira da outra.

O mappedBy você deve colocar sempre na classe que NÃO é dona do relacionamento (lado fraco), para indicar que aquele 
atributo é da classe do lado inverso do relacionamento(lado fraco). Ou seja, se Pessoa é a classe dominante, você deve 
colocar o atributo na classe Perfil.



Por padrão, um mapeamento com @ManyToMany cria a tabela de associação com os nomes das entidades relacionadas, 
separados por underscore, com as colunas com nomes também gerados automaticamente.


ORM: Object Relation Mapper

Classe -> ClasseDao -> Entidade(Relacionamento)

Conceito de Anotations:
@Table: nome da tabela -> defino o essa anotação para alterar o nome da tabela Ex: tb_dados, senão usar o table será o nome da classe
@Id: um determinado atributo é a chave primária
@Column: alterar o nome do atributo, ou seja o nome da coluna.Ex: @Column(name:"nome_aluno") private String name; 
@Entity: é um entidade no banco de dados



