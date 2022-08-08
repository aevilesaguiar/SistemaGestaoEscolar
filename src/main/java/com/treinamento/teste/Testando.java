package com.treinamento.teste;

import com.treinamento.dao.EmpresaDAO;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Empresa;

import javax.persistence.EntityManager;


public class Testando {

    public static void main(String[] args) {

        Empresa e= new Empresa();
        e.setCnpj("12.105.235/0001-01");
        e.setEmail("email@email.com");
        e.setEndereco("Rua José da silva, 02, Santa Helena, Diadema-SP");
        e.setNome("Objetivo");
        e.setTelefone("(11)1256-8589");
        e.setResponsavelEmpresa("Maria da Silva");

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        EmpresaDAO empresaDAO= new EmpresaDAO(em);
        empresaDAO.save(e);


        em.close();
        JPAUtil.close();












    }
}
