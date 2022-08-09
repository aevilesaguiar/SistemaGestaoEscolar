package com.treinamento.teste;



import com.treinamento.dao.EmpresaDAO;
import com.treinamento.dao.JPAUtil;

import com.treinamento.model.Empresa;
import com.treinamento.model.Unidade;


import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


public class Testando {

    public static void main(String[] args) {



        // obtém o entity manager
        EntityManager em = JPAUtil.getEntityManager();


        em.close();
        JPAUtil.close();








    }
}
