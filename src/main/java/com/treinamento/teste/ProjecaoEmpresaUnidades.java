package com.treinamento.teste;

import com.treinamento.dao.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProjecaoEmpresaUnidades {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        EmpresaDAO empresaDAO= new EmpresaDAO(em);
        UnidadeDAO unidadeDAO=new UnidadeDAO(em);
        CursoDAO cursoDAO= new CursoDAO(em);
        DisciplinaDAO disciplinaDAO=new DisciplinaDAO(em);
        PeriodoCursoDAO periodoCursoDAO=new PeriodoCursoDAO(em);
        AlunoDAO alunoDAO= new AlunoDAO(em);
        ProfessorDAO professorDAO=new ProfessorDAO(em);

        



    }
}
