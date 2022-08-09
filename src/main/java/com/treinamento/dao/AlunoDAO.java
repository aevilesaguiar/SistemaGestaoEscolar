package com.treinamento.dao;

import com.treinamento.model.Aluno;

import javax.persistence.EntityManager;

public class AlunoDAO extends JPAUtil{

    private EntityManager em;

    public AlunoDAO (EntityManager em){
        this.em=em;
    }

    /**
     * Método que salva e altera empresa do banco de dados.
     * @param aluno
     */

    public Aluno save(Aluno aluno){

        try{
            em.getTransaction();

            if(aluno.getId()==null){
                em.persist(aluno);
            }else{
               aluno= em.merge(aluno);
            }
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            System.err.println(e);
        }finally {
            em.close();
        }
        return aluno;
    }






}
