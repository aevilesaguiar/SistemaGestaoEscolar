package com.treinamento.dao;


import com.treinamento.model.Empresa;
import com.treinamento.model.Unidade;

import javax.persistence.EntityManager;
import java.util.List;


public class UnidadeDAO {
    private  EntityManager em;

    public UnidadeDAO(EntityManager em){
        this.em=em;
    }

    /**
     * Método que salva e altera empresa do banco de dados.
     * @param unidade
     */

    public Unidade save(Unidade unidade) {

        try{
            //inicia uma transação no banco de dados
            em.getTransaction().begin();
            System.out.println("Salvando empresa");

            //verifica se a empresa está salva no BD
            if(unidade.getId()==null){

                em.persist(unidade);//persiste os dados no BD executa o insert
            }else{
                //atualiza os dados da empresa
                unidade=em.merge(unidade);
            }
            em.getTransaction().commit();

        } catch (Exception e){
            em.getTransaction().rollback(); //usamos quando temos vários deletes e updates
             System.err.println(e);
        }
        finally{
            em.close();
        }
        return unidade;
    }

    /**
     * Método que apaga a empresa do banco de dados.
     * @param id
     */
    public void delete(Long id) {


        try {
            //inicia uma transação no banco de dados
            em.getTransaction().begin();

            //Consulta a empresa no BD através do ID
            Unidade unidade = em.find(Unidade.class, id);

            System.out.println("Excluindo os dados de: " + unidade.getNome());

            //remove a empresa da base de dados
            em.remove(unidade);

            //finalizar a transação
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
        /**
         * Consulta empresa pelo ID.
         * @param id
         * @return o objeto Empresa
         */

        public Unidade findById(Long id){


            Unidade unidade=null;

            try{
                //consulta uma empresa por ID
                unidade= em.find(Unidade.class,id);

        }finally {
                em.close();
            }
        return unidade;
    }

    /**
     * Consulta todas as unidades.
     * @param
     * @return o objeto Unidade
     */

    public List<Unidade> findAll(){

        List<Unidade> unidades=null;

        try {
            unidades=em.createQuery("from Unidades e").getResultList();//o e é o alias

        }catch (Exception e){
            System.err.println(e);
        }finally {

            em.close();

        }
        return unidades;
    }



}
