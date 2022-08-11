package com.treinamento.dao;


import com.treinamento.model.Curso;
import com.treinamento.model.Disciplina;
import com.treinamento.model.PeriodoCurso;

import javax.persistence.EntityManager;
import java.util.List;


public class PeriodoCursoDAO {
    private  EntityManager em;

    public PeriodoCursoDAO(EntityManager em){
        this.em=em;
    }

    /**
     * Método que salva e altera o periodo do curso no banco de dados.
     * @param periodoCurso
     */

    public PeriodoCurso save(PeriodoCurso periodoCurso) {

        try{
            //inicia uma transação no banco de dados
            em.getTransaction().begin();
            System.out.println("Salvando Disciplinas");

            //verifica se curso está salva no BD
            if(periodoCurso.getId()==null){

                em.persist(periodoCurso);//persiste os dados no BD executa o insert
                System.out.println("Atualizando Disciplina:"+periodoCurso.getId() +" - "+periodoCurso.getPeriodo()+" - "+periodoCurso.getCurso());
            }else{
                //atualiza os dados do curso
                periodoCurso=em.merge(periodoCurso);
                System.out.println("Atualizando Disciplina: "+periodoCurso.getId()+" - "+periodoCurso.getPeriodo()+" - "+periodoCurso.getCurso());
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
        return periodoCurso;
    }

    /**
     * Método que apaga o periodoCurso do banco de dados.
     * @param id
     */
    public void delete(Long id) {


        try {
            //inicia uma transação no banco de dados
            em.getTransaction().begin();

            //Consulta o periodo do curso no BD através do ID
            PeriodoCurso periodoCurso = em.find(PeriodoCurso.class, id);

            System.out.println("Excluindo os dados de: " + periodoCurso.getId()+periodoCurso.getCurso());

            //remove o periodo do curso da base de dados
            em.remove(periodoCurso);

            //finalizar a transação
            em.getTransaction().commit();

        } finally {
        //    em.close();
        }
    }
        /**
         * Consulta curso pelo ID.
         * @param id
         * @return o objeto Disciplina
         */

        public PeriodoCurso findById(Long id){


            PeriodoCurso periodoCurso=null;

            try{
                //consulta um periodo do curso por ID
                periodoCurso= em.find(PeriodoCurso.class,id);

        }finally {
          //      em.close();
            }
        return periodoCurso;
    }

    /**
     * Consulta todas os periodos do curso.
     * @param
     * @return o objeto Disciplina
     */

    public List<PeriodoCurso> findAll(){

        List<PeriodoCurso> periodoCursos=null;

        try {
            periodoCursos=em.createQuery("from PeriodoCurso p").getResultList();//o p é o alias

        }catch (Exception e){
            System.err.println(e);
        }finally {

           // em.close();

        }
        return periodoCursos;
    }



}
