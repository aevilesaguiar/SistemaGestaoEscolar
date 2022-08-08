package com.treinamento.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    /*criando um objeto do tipo Entity manger Factory que cria uma fabrica de conexão com o banco*/
    private  EntityManagerFactory entityManagerFactory;

    //sempre que precisar da entitymanager chamaremos o método abaixo, isso garante que ele não seja criado mais de uma vez
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public JPAUtil(){
        entityManagerFactory= Persistence.createEntityManagerFactory("sistema");//É COMO SE FOSSE UMA CONEXÃO COM O BANCO
    }

}
