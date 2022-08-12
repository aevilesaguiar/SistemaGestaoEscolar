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
- Maven

## Java Persistence API  e Hibernate

AJava Persistence API (JPA) ou Jakarta Persistence (novo nome adotado pelo Jakarta EE) é uma especificação que oferece uma API de mapeamento objeto-relacional, ou seja, é a tecnologia padrão em Java para trabalhar com ORM.

## Informações projeto inicial

- pom: arquivo criado no diretório raiz do projeto.Esse arquivo contém informações sobre o projeto e detalhes de configurações usadas para o Maven fazer build do projeto.

Para trabalhar com JPA temos que adicionar algumas dependencias no pom.xml.

Devemos incluí-las nas tags dependencies:

```

<dependencies>

    <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.30</version>
    </dependency>

    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-entitymanager</artifactId>
        <version>5.4.27.Final</version>
    </dependency>

</dependencies>


```

O Maven baixa automaticamente os JARs das dependências pela internet, do repositório central.

Ao adicionar a implementação do Hibernate como dependência, estamos automaticamente adicionando também o JPA, que é uma dependência transitiva do Hibernate (o Hibernate depende do JPA, portanto “carrega” junto essa dependência, que é chamada de dependência transitiva).

## Criando o Domain Model

Modelos de domínio para o sistema de gestão escolar.

Serão Criadas 7 classes POJO:

- Aluno
- Curso
- Disciplina
- Empresa
- PeriodoCurso
- Professor
- Unidade

Todas essas classes possuirão um atributo identificador.

O atributo identificador (chamado de id) é referente a chave primária das tabelas.

As classes de entidades podem seguir o estilo JavaBeans, com métodos getters e setteres. é obrigatório que essas

classes tenham um construtor sem argumentos.

Todas essas classes são POJO(Plain Old **Java** Object ), ou seja podemos instanciá-las sem necessidade de containers especiais.

## Implementando o equals() e hashCode()

Para que os objetos das entidades sejam diferenciados uns de outros, precisamos implementar os métodos equals() e hashCode().

Nobanco de dados, as chaves primárias diferenciam registros distintos. Quando mapeamos uma entidade para uma tabela, devemos criar os métodos equals() e hashCode(), levando em consideração a forma em que os registros são diferenciados no banco de dados.

## Mapeamento básico

Para que o mapeamento objeto-relacional funcione, é encessário implementar do JPA mais detalhes sobre como objetos das classes devem se tornar persistentes, ou seja como as instancias dessas  classe podem ser  gravadas e consultadas no BD. Podemos anotar os getters ou atributos, ou até mesmo a própria classe, com anotações do JPA.

As anotações são padronizadas são importadas do javax.persistence. Dentro desse pacote estão todas as anotações padronizadas pela JPA.

Exemplos anotações:

- @Entity: diz que a classe é uma entidade JPA, que representa uma tabela do banco de dados.

  As anotações nos atributos configuram a relação com as colunas da tabela do banco de dados.
- @Id: é usada para declarar o identificador da entidade, ou seja, representa a chave primária na tabela do banco de dados.
- @GeneratedValue:especifica que um valor será gerado automaticamente para este atributo.

  - GenerationType.AUTO: Valor padrão, deixa com o provedor de persistência a escolha da estratégia mais adequada de acordo com o banco de dados.
  - GenerationType.IDENTITY:Informamos ao provedor de persistência que os valores a serem atribuídos ao identificador único serão gerados pela coluna de auto incremento do banco de dados. Assim, um valor para o identificador é gerado para cada registro inserido no banco. Alguns bancos de dados podem não suportar essa opção.
  - GenerationType.SEQUENCE: Informamos ao provedor de persistência que os valores serão gerados a partir de uma sequence. Caso não seja especificado um nome para a sequence, será utilizada uma sequence padrão, a qual será global, para todas as entidades. Caso uma sequence seja especificada, o provedor passará a adotar essa sequence para criação das chaves primárias. Alguns bancos de dados podem não suportar essa opção.
  - GenerationType.TABLE: Com a opção TABLE é necessário criar uma tabela para gerenciar as chaves primárias. Por causa da sobrecarga de consultas necessárias para manter a tabela atualizada, essa opção é pouco recomendada.
- @Colun:especifica que a propriedade da classe representa uma coluna na tabela do banco de dados.
- @Table:podemos especificar o nome da tabela, senão especificarmos ela considera o nome da classe.
- @Column(length = 60, nullable = false):Definimos o tamanho da coluna com 60 e com restrição not null.

Ao omitir a anotação Column nas outras propriedades, o JPA faz o mapeamento automaticamente, o que significa que todas as propriedades da classe estão mapeadas para colunas.

## O arquivo persistence.xml

O persistence.xml é um arquivo de configuração padrão da JPA. Ele deve ser criado no diretório META-INF da aplicação ou do módulo que contém as classes de entidade.

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.2"
             xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">

    <persistence-unit name="sistema" >
        <provider>org.hibernate.ejb.HibernatePersistence</provider>


        <properties>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/sistema?serverTimezone=UTC"/>
            <property name="javax.persistence.jdbc.user" value="root"/>
            <property name="javax.persistence.jdbc.password" value="123456"/>

            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.format_sql" value="true" />
        </properties>
    </persistence-unit>

</persistence>
```

Onomedaunidadedepersistênciafoidefinido como sistema.

## Criação de Tabelas

O JPA pode criar as tabelas devido a inclusão da propriedade javax.persistence.schemageneration.database.action com valor drop-and-create, que incluímos no arquivo persistence.xml.

Nesse caso eu exclui a properti porque não tenho schema :

```
<property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
```

Precisamos apenas obter uma instância de EntityManagerFactory para dar um start no mecanismo do JPA. Assim, todas as tabelas mapeadas pelas entidades serão criadas.

```
public class JPAUtil {

    /**
     * Método utilizado para obter o entity manager.
     * @return
     */
    private static EntityManagerFactory factory;
    static {
        factory = Persistence.createEntityManagerFactory("sistema");
    }
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
    public static void close() {
        factory.close();
    }

}
```

O parâmetro do método createEntityManagerFactory deve ser o mesmo nome que informamos no atributo name da tag persistence-unit, no arquivo persistence.xml.

Quando executarmos esse código a tabela é criada

- Podemosdefinir melhor os detalhes físicos no mapeamento de nossa entidade, definindo quantidade de caracteres, se é nulo e outros
- length: quantidade de caracteres
- nullable: que o campo pode ou não ser nulo.

## EntityManager

Os sistemas que usam JPA precisam de apenas uma instância de EntityManagerFactory, que pode ser criada durante a inicialização da aplicação. Esta única instância pode ser usada por qualquer código que queira obter um EntityManager.

Um EntityManager é responsável por gerenciar entidades no contexto de persistência. Através dos métodos dessa interface, é possível persistir, pesquisar e excluir objetos do banco de dados.

Criamos um bloco estático para inicializar a fábrica de Entity Manager. Isso ocorrerá apenas uma vez, no carregamento da classe. Agora, sempre que precisarmos de uma EntityManager, podemos chamar: EntityManager manager = JPAUtil.getEntityManager();

public class JPAUtil {

/**

* Método utilizado para obter o entity manager.
* @return
  */
  private static EntityManagerFactory factory;
  static {
  factory = Persistence.createEntityManagerFactory("sistema");
  }
  public static EntityManager getEntityManager() {
  return factory.createEntityManager();
  }
  public static void close() {
  factory.close();
  }
  }

## Persistindo Objetos

Exemplo de código:

```
public class PersisntindoEmpresa {
    public static void main(String[] args) {

        EntityManager em= JPAUtil.getEntityManager();
        EntityTransaction tx=em.getTransaction();
        tx.begin();

        Unidade unidade= new Unidade();
        unidade.setNome("Centro");
        unidade.setEndereco("Rua Francisco de Assis");
        Empresa empresa= new Empresa("Etapa", Arrays.asList(unidade));

        em.persist(empresa);

        tx.commit();

        em.close();
        JPAUtil.close();
    }
}

```

O Hibernate gera o SQL de inserção por que incluimos a configuração no persistence.xml

O código abaixo obtém um EntityManager, que é responsável por gerenciar o ciclo de vida das entidades.

EntityManager manager = JpaUtil.getEntityManager();

Agora iniciamos uma nova transação.

EntityTransaction tx = manager.getTransaction();

tx.begin();

Instanciamos os objetos e atribuimos valores, chamando getteres e setters.

Executamos o método persist, passando a instância da empresa como parâmetro. Isso fará com que o JPA insira o objeto no banco de dados.

```
 em.persist(empresa);
```

Agora fazemos commit da transação, para efetivar a inserção da empresa no banco de dados.

tx.commit();

fechamos o EntityManager e o EntityManagerFactory.

manager.close();

JpaUtil.close();

SQL e JDBC continuam sendo usados por baixo dos panos, pela implementação do JPA.

## Buscando objetos pelo identificador

Podemos recuperar objetos através do identificador (chave primária) da entidade.

consultamos a instância da empresa usando o método find, de EntityManager, passando como argumento o tipo da entidade e também o código da empresa.

```




        public Empresa findById(Long id){


            Empresa empresa=null;

            try{
                //consulta uma empresa por ID
                empresa= em.find(Empresa.class,id);
                System.out.println("Dados empresa:"+empresa.getId()+ "- "+empresa.getNome());

        }finally {
          //      em.close();
            }
        return empresa;
    }
```

```
disciplinaDAO.findById(1l);
```

Se rodarmos o código o SQL gerado possui a cláusula where, para filtrar apenas o veículo de código igual a 1.

- Podemos também buscar um objeto pelo identificador usando o método getReference.

  ```

      public Empresa findById2(Long id){

          Empresa empresa=null;

          try {
             empresa=em.getReference(Empresa.class,id);
              System.out.println("Id:"+ empresa.getId()+" Nome: "+empresa.getNome());
          }catch (Exception e){
              System.err.println(e);
              System.out.println("Id :"+id + " não localizado no nosso BD!");
          }finally {

          }
          return empresa;
      }

  ```

```
    empresaDAO.findById2(2L);

```

O resultado na console é o mesmo, deixando a impressão que os métodos find e getReference fazem a mesma coisa, mas na verdade, esses métodos possuem comportamentos um pouco diferentes.

O método find busca o objeto imediatamente no banco de dados, enquanto getReference só executa o SQL quando o objeto for usado pela primeira vez, ou O método find busca o objeto imediatamente no banco de dados, enquanto getReference só executa o SQL quando o objeto for usado pela primeira vez.

Note que o SQL foi executado apenas quando um getter foi invocado, e não na chamada de getReference.

A JPQL é uma extensão da SQL, porém com características da orientação a objetos. Com essa linguagem, não referenciamos tabelas do banco de dados, mas apenas entidades de nosso modelo.

SELECT * FROM empresa

Fica da seguinte forma em JPQL:

SELECT e from Empresa e

## Listando objetos

consultas simples de entidades com a linguagem JPQL (Java Persistence Query Language).

A JPQL é uma extensão da SQL, porém com características da orientação a objetos. Com essa linguagem, não referenciamos tabelas do banco de dados, mas apenas entidades de nosso modelo.

## Atualizando Objetos

Os atributos de entidades podem ser manipulados diretamente ou através dos métodos da classe e todas as alterações serão detectadas e persistidas automaticamente, quando o contexto de persistência for “descarregado” para o banco de dados.

```



    public Empresa update(Long id, String empre) {

        Empresa empresa =null;

        try{
            //inicia uma transação no banco de dados
            em.getTransaction().begin();



            System.out.println("Atualizando empresa");
            empresa=em.find(Empresa.class,id);

            System.out.println("Dado atual :"+empresa.getId()+" - "+empresa.getNome());
            empresa.setNome(empre);
            System.out.println("Dado Novo: "+empresa.getId()+" - "+empresa.getNome());

            em.getTransaction().commit();

        } catch (Exception e){
            System.out.println("Erro na atualização!");
            System.err.println(e);

        }
        finally{
            // em.close();
        }
        return empresa;
    }

```

O código acima executa o comando select no banco de dados para buscar a empresa pelo id, imprime o nome atual da empresa e atribui um novo nome a empresa.

não precisamos chamar nenhum método para a atualização no banco de dados. A alteração foi identificada automaticamente e refletida no banco de dados, através do comando SQL update.

Atualizando empresa
Hibernate:
select
empresa0_.id_empresa as id_empre1_4_0_,
empresa0_.nome_empresa as nome_emp2_4_0_
from
tab_empresa empresa0_
where
empresa0_.id_empresa=?
Dado atual :2 - Juscelino Kubtheck
Dado Novo: 2 - Flavio Tavares
Hibernate:
update
tab_empresa
set
nome_empresa=?
where
id_empresa=?

## Excluindo objetos


A exclusão de objetos é feita chamando o método remove de EntityManager, passando como parâmetro o objeto da entidade.


- Estados e ciclo de vida

## Gerenciando Objetos


Objetos de entidades são instâncias de classes mapeadas usando JPA, que ficam na memória e representam registros do banco de dados. Essas instâncias possuem um ciclo de vida, que é gerenciado pelo JPA.


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

## Lazy loading e eager loading

Lazy loading e eager loading Podemos definir a estratégia de carregamento de relacionamentos de entidades, podendo ser lazy (tardia) ou eager (ansiosa).

Todos os relacionamentos qualquer-coisa-para-muitos, ou seja, one-to-many e manyto-many, possuem o lazy loading como estratégia padrão. Os demais relacionamentos

(que são qualquer-coisa-para-um) possuem a estratégia eager loading como padrão.

Todos os relacionamentos qualquer-coisa-para-muitos, ou seja, one-to-many e manyto-many, possuem o lazy loading como estratégia padrão. Os demais relacionamentos

(que são qualquer-coisa-para-um) possuem a estratégia eager loading como padrão.

## Relacionamentos

@OneToOne
@OneToMany  - @ManyToOne  (bidirecional)
List

@ManyToMany - bidirecional

@JoinColumn(name = "assento_id", unique = true) : é usado para mapear campos que representam uma junção de tabela

## tipos de cascade

O atributo cascade pode receber um array de dados, o cascade faz uma operação cascata;

PERSIST: Ele propaga a operação de persistir um objeto Pai para um objeto Filho, assim quando salvar a Entidade Cliente, também será salvo todas as Entidades Telefone associadas.

MERGE: Ele propaga a operação de atualização de um objeto Pai para um objeto Filho, assim quando atualizadas as informações da Entidade Cliente, também será atualizado

no banco de dados todas as informações das Entidades Telefone associadas.

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

## Referencias

- https://www.devmedia.com.br/jpa-como-usar-a-anotacao-generatedvalue/38592
