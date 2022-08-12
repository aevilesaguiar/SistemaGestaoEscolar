package com.treinamento.teste;

import com.treinamento.dao.EmpresaDAO;
import com.treinamento.dao.JPAUtil;

import javax.persistence.EntityManager;

public class Excluindo {
    public static void main(String[] args) {
        EntityManager em= JPAUtil.getEntityManager();

        EmpresaDAO empresaDAO=new EmpresaDAO(em);

        empresaDAO.delete(6L);

    }
}
