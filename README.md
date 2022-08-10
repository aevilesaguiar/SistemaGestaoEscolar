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
@Entity: a tabela


@Transient: é quando eu quero que um atributo não seja persistido pelo o banco de dados

EntityMangerFactory o seu papel é criar o EntityManger (fabrica de Entity manger)

EntityManger é o gerente das entidades, ele é responsável por inserir, excluir, atualizar...
EntityManger encapsula a conexão, e podemos criar varias unidades de persistencia.O entityManger ele 
tem encapsulado dentro dele uma conexão com o banco de dados


## Relacionamentos

@OneToOne
@OneToMany  - @ManyToOne  (bidirecional)
List

@ManyToMany - bidirecional


@JoinColumn(name = "assento_id", unique = true) : é usado para mapear campos que representam uma junção de tabela

## tipos de cascade

O atributo cascade pode receber um array de dados, o cascade faz uma operação cascata;

PERSIST: Ele propaga a operação de persistir um objeto Pai para um objeto Filho, assim quando salvar a Entidade Cliente, também será salvo todas as Entidades Telefone associadas.

MERGE: Ele propaga a operação de atualização de um objeto Pai para um objeto Filho, assim quando atualizadas as informações da Entidade Cliente, também será atualizado no banco de dados todas as informações das Entidades Telefone associadas.

REMOVE: Ele propaga a operação de remoção de um objeto Pai para um objeto Filho, assim quando remover a Entidade Cliente, também será removida todas as entidades Telefone associadas.

REFRESH: Ele propaga a operação de recarregar de um objeto Pai para um objeto Filho, assim, quando houver atualização no banco de dados na Entidade Cliente, todas as entidades Telefone associadas serão recarregadas do banco de dados.

ALL: Corresponde a todas as operações acima (MERGE, PERSIST, REFRESH e REMOVE).

DETACH: "A operação de desanexação remove a entidade do contexto persistente. Quando usamos CascaseType.DETACH, a entidade filha também é removida do contexto persistente".


## Operação Bidirecional

    @OneToOne(mappedBy = "assento")//dentro da classe cliente o atributo que mapeia a operação é assento, ou seja ele não cria uma tabela nova e sim uma coluna
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.PERSIST) //ele faz a operação apenas quando estivermos persistindo
    @JoinColumn(name = "assento_id", unique = true)
    private Assento assento;






