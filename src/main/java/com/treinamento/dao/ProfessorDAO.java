package com.treinamento.dao;


import com.treinamento.model.Aluno;
import com.treinamento.model.Professor;

import javax.persistence.EntityManager;
import java.util.List;


public class ProfessorDAO {
    private  EntityManager em;

    public ProfessorDAO(EntityManager em){
        this.em=em;
    }

    /**
     * Método que salva e altera curso do banco de dados.
     * @param professor
     */

    public Professor save(Professor professor) {

        try{
            //inicia uma transação no banco de dados
            em.getTransaction().begin();
            System.out.println("Salvando Professor");

            //verifica se curso está salva no BD
            if(professor.getId()==null){

                em.persist(professor);//persiste os dados no BD executa o insert
                System.out.println("Atualizando Professor:"+professor.getId()+"- "+professor.getMatricula()+" - "+professor.getNomeCompleto());
            }else{
                //atualiza os dados do curso
                professor=em.merge(professor);
                System.out.println("Atualizando Professor: "+professor.getId()+"- "+professor.getMatricula()+" - "+professor.getNomeCompleto());
            }
            em.getTransaction().commit();

        } catch (Exception e){
            System.out.println("Erro de saida");
           em.getTransaction().rollback(); //usamos quando temos vários deletes e updates
             System.err.println(e);

        }
        finally{
          // em.close();
        }
        return professor;
    }

        /**
         * Consulta curso pelo ID.
         * @param id
         * @return o objeto Aluno
         */

        public Professor findById(Long id){


            Professor professor=null;

            try{
                //consulta um professor por ID
                professor= em.find(Professor.class,id);

        }finally {
          //      em.close();
            }
        return professor;
    }

    /**
     * Consulta todos os professores.
     * @param
     * @return o objeto Professor
     */

    public List<Professor> findAll(){

        List<Professor> professores=null;

        try {
            professores=em.createQuery("from Professores p").getResultList();//o p é o alias

        }catch (Exception e){
            System.err.println(e);
        }finally {

           // em.close();

        }
        return professores;
    }



}
