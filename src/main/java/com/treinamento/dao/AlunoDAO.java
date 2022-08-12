package com.treinamento.dao;


import com.treinamento.model.Aluno;


import javax.persistence.EntityManager;
import java.util.List;


public class AlunoDAO {
    private  EntityManager em;

    public AlunoDAO(EntityManager em){
        this.em=em;
    }

    /**
     * Método que salva e altera curso do banco de dados.
     * @param aluno
     */

    public Aluno save(Aluno aluno) {

        try{
            //inicia uma transação no banco de dados
            em.getTransaction().begin();
            System.out.println("Salvando Alunos");

            //verifica se curso está salva no BD
            if(aluno.getId()==null){

                em.persist(aluno);//persiste os dados no BD executa o insert
                System.out.println("Atualizando Aluno:"+aluno.getId() +" - "+aluno.getNomeCompleto()+" - "+aluno.getMatricula());
            }else{
                //atualiza os dados do curso
                aluno=em.merge(aluno);
                System.out.println("Atualizando Aluno: "+aluno.getId() +" - "+aluno.getNomeCompleto()+" - "+aluno.getMatricula());
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
        return aluno;
    }

        /**
         * Consulta curso pelo ID.
         * @param id
         * @return o objeto Aluno
         */

        public Aluno findById(Long id){


            Aluno aluno=null;

            try{
                //consulta uma disciplina por ID
                aluno= em.find(Aluno.class,id);

        }finally {
          //      em.close();
            }
        return aluno;
    }

    /**
     * Consulta todos os alunos.
     * @param
     * @return o objeto Aluno
     */

    public List<Aluno> findAll(){

        List<Aluno> alunos=null;

        try {
            alunos=em.createQuery("from Alunos a").getResultList();//o a é o alias

        }catch (Exception e){
            System.err.println(e);
        }finally {

           // em.close();

        }
        return alunos;
    }



}
