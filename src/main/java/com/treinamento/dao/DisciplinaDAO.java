package com.treinamento.dao;


import com.treinamento.model.Curso;
import com.treinamento.model.Disciplina;

import javax.persistence.EntityManager;
import java.util.List;


public class DisciplinaDAO {
    private  EntityManager em;

    public DisciplinaDAO(EntityManager em){
        this.em=em;
    }

    /**
     * Método que salva e altera curso do banco de dados.
     * @param disciplina
     */

    public Disciplina save(Disciplina disciplina) {

        try{
            //inicia uma transação no banco de dados
            em.getTransaction().begin();
            System.out.println("Salvando Disciplinas");

            //verifica se curso está salva no BD
            if(disciplina.getId()==null){

                em.persist(disciplina);//persiste os dados no BD executa o insert
                System.out.println("Atualizando Disciplina:"+disciplina.getId() +" - "+disciplina.getDisciplina()+" - "+disciplina.getPeriodoCurso());
            }else{
                //atualiza os dados do curso
                disciplina=em.merge(disciplina);
                System.out.println("Atualizando Disciplina: "+disciplina.getId() +" - "+disciplina.getDisciplina()+" - "+disciplina.getPeriodoCurso());
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
        return disciplina;
    }

    /**
     * Método que apaga a disciplina do banco de dados.
     * @param id
     */
    public void delete(Long id) {


        try {
            //inicia uma transação no banco de dados
            em.getTransaction().begin();

            //Consulta o curso no BD através do ID
            Curso curso = em.find(Curso.class, id);

            System.out.println("Excluindo os dados de: " + curso.getNomeCurso());

            //remove as disciplinas da base de dados
            em.remove(curso);

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

        public Disciplina findById(Long id){


            Disciplina disciplina=null;

            try{
                //consulta uma disciplina por ID
                disciplina= em.find(Disciplina.class,id);
                System.out.println("ID Disciplina: "+disciplina.getDisciplina()+" Nome disciplina: "+disciplina.getDisciplina());

        }finally {
          //      em.close();
            }
        return disciplina;
    }

    /**
     * Consulta todas as disciplinas.
     * @param
     * @return o objeto Disciplina
     */

    public List<Disciplina> findAll(){

        List<Disciplina> disciplinas=null;

        try {
            disciplinas=em.createQuery("from Disciplina c").getResultList();//o c é o alias

        }catch (Exception e){
            System.err.println(e);
        }finally {

           // em.close();

        }
        return disciplinas;
    }



}
