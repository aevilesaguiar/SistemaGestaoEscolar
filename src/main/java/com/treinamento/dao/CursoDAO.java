package com.treinamento.dao;


import com.treinamento.model.Curso;


import javax.persistence.EntityManager;
import java.util.List;


public class CursoDAO {
    private  EntityManager em;

    public CursoDAO(EntityManager em){
        this.em=em;
    }

    /**
     * Método que salva e altera curso do banco de dados.
     * @param curso
     */

    public Curso save(Curso curso) {

        try{
            //inicia uma transação no banco de dados
            em.getTransaction().begin();
            System.out.println("Salvando Cursos");

            //verifica se curso está salva no BD
            if(curso.getId()==null){

                em.persist(curso);//persiste os dados no BD executa o insert
                System.out.println("Atualizando Curso:"+curso.getId() +" - "+curso.getNomeCurso());
            }else{
                //atualiza os dados do curso
                curso=em.merge(curso);
                System.out.println("Atualizando Curso: "+curso.getId() +" - "+curso.getNomeCurso());
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
        return curso;
    }

    /**
     * Método que apaga o curso do banco de dados.
     * @param id
     */
    public void delete(Long id) {


        try {
            //inicia uma transação no banco de dados
            em.getTransaction().begin();

            //Consulta o curso no BD através do ID
            Curso curso = em.find(Curso.class, id);

            System.out.println("Excluindo os dados de: " + curso.getNomeCurso());

            //remove o curso da base de dados
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
         * @return o objeto Curso
         */

        public Curso findById(Long id){


            Curso curso=null;

            try{
                //consulta uma curso por ID
                curso= em.find(Curso.class,id);

        }finally {
          //      em.close();
            }
        return curso;
    }

    /**
     * Consulta todas os cursos.
     * @param
     * @return o objeto Curso
     */

    public List<Curso> findAll(){

        List<Curso> cursos=null;

        try {
            cursos=em.createQuery("from Curso c").getResultList();//o e é o alias

        }catch (Exception e){
            System.err.println(e);
        }finally {

           // em.close();

        }
        return cursos;
    }



}
