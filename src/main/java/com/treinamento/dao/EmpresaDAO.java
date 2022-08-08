package com.treinamento.dao;

import com.treinamento.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmpresaDAO extends JPAUtil{
    /*instancio uma EntityManger que vou ter a possibilidade de manipular uma entidade */
    public void salvar (Cliente cliente){//ele recebe um objeto POJO

        //toda vez tem que iniciar a transação
        EntityManager entityManager=getEntityManager();//getEntityManager() é um metodo da classe DAO que retorna uma instancia do banco

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);//persistir o objeto no banco
            entityManager.getTransaction().commit();//tenho que commitar senão ele não envia para o banco
        }catch (Exception e){
            entityManager.getTransaction().rollback();//caso tenha algum problema eu dou um rollback na transação e ele reverte
        }
    }

      public List<Cliente> exibir(){
        EntityManager manager=getEntityManager();
        try {
            Query query= manager.createQuery("SELECT object(c) from Cliente as c");
            return query.getResultList();


        }finally {
            manager.close();

        }
      }
}
