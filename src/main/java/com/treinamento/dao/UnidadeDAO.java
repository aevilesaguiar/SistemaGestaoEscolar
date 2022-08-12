package com.treinamento.dao;


import com.treinamento.model.Empresa;
import com.treinamento.model.Unidade;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import javax.persistence.EntityManager;
import java.util.List;


public class UnidadeDAO {
    private  EntityManager em;

    public UnidadeDAO(EntityManager em){
        this.em=em;
    }

    /**
     * Método que salva e altera unidade do banco de dados.
     * @param unidade
     */

    public Unidade save(Unidade unidade) {

        try{
            //inicia uma transação no banco de dados
            em.getTransaction().begin();
            System.out.println("Salvando Unidade");

            //verifica se a unidade está salva no BD
            if(unidade.getId()==null){

                em.persist(unidade);//persiste os dados no BD executa o insert
            }else{
                //atualiza os dados da unidade
                unidade=em.merge(unidade);
            }
            em.getTransaction().commit();

        } catch (Exception e){
            em.getTransaction().rollback(); //usamos quando temos vários deletes e updates
             System.err.println(e);
        }
        finally{
         //   em.close();
        }
        return unidade;
    }

    /**
     * Método que apaga a unidade do banco de dados.
     * @param id
     */
    public void delete(Long id) {


        try {
            //inicia uma transação no banco de dados
            em.getTransaction().begin();

            //Consulta a unidade no BD através do ID
            Unidade unidade = em.find(Unidade.class, id);

            System.out.println("Excluindo os dados de: " + unidade.getNome());

            //remove a unidade da base de dados
            em.remove(unidade);

            //finalizar a transação
            em.getTransaction().commit();

        } finally {
           // em.close();
        }
    }
        /**
         * Consulta unidade pelo ID.
         * @param id
         * @return o objeto Unidade
         */

        public Unidade findById(Long id){


            Unidade unidade=null;

            try{
                //consulta uma unidade por ID
                unidade= em.find(Unidade.class,id);
                System.out.println("Nome Unidade: "+unidade.getNome()+" Id: "+unidade.getId()+" Endereco: "+unidade.getEndereco());

        }catch(Exception e){
                System.err.println(e);
                System.out.println("Não existe esse Id!");
            }
        finally {
               // em.close();
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
            unidades=em.createQuery("from Unidade u").getResultList();//o u é o alias

        }catch (Exception e){
            System.err.println(e);
        }finally {

           // em.close();

        }
        return unidades;
    }



}
