package com.treinamento.teste;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Empresa;
import com.treinamento.model.Unidade;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import java.util.Arrays;

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
