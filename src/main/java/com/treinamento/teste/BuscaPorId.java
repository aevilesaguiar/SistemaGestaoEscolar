package com.treinamento.teste;


import com.treinamento.dao.*;

import javax.persistence.EntityManager;

public class BuscaPorId {

    public static void main(String[] args) {
        // obtém o entity manager
        EntityManager em = JPAUtil.getEntityManager();

        EmpresaDAO empresaDAO= new EmpresaDAO(em);
        UnidadeDAO unidadeDAO=new UnidadeDAO(em);
        CursoDAO cursoDAO= new CursoDAO(em);
        DisciplinaDAO disciplinaDAO=new DisciplinaDAO(em);
        PeriodoCursoDAO periodoCursoDAO=new PeriodoCursoDAO(em);
        AlunoDAO alunoDAO= new AlunoDAO(em);
        ProfessorDAO professorDAO=new ProfessorDAO(em);


        //  empresaDAO.findById(1l);
        // unidadeDAO.findById(1L);
        //cursoDAO.findById(2L);
       // disciplinaDAO.findById(1l);

        empresaDAO.findById2(2L);




        em.close();














    }
}
