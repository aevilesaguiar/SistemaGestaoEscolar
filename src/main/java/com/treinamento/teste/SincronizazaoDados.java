package com.treinamento.teste;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class SincronizazaoDados {
    public static void main(String[] args) {

        EntityManager em= JPAUtil.getEntityManager();
        EntityTransaction tx=em.getTransaction();
        tx.begin();

        Empresa empresa= em.find(Empresa.class, 1L);

        System.out.println("Valor atual: "+ empresa.getNome());
    }
}
