package com.treinamento.dao;


import com.treinamento.model.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class EmpresaDAO {
    private  EntityManager em;

    public EmpresaDAO(EntityManager em){
        this.em=em;
    }

    /**
     * Método que salva e altera empresa do banco de dados.
     * @param empresa
     */

    public Empresa save(Empresa empresa) {

        try{
            //inicia uma transação no banco de dados
            em.getTransaction().begin();
            System.out.println("Salvando empresa");

            //verifica se a empresa está salva no BD
            if(empresa.getId()==null){

                em.persist(empresa);//persiste os dados no BD executa o insert
                System.out.println("Atualizando Empresa:"+empresa.getId() +" - "+empresa.getNome());
            }else{
                //atualiza os dados da empresa
                empresa=em.merge(empresa);
                System.out.println("Atualizando empresa: "+empresa.getId() +" - "+empresa.getNome());
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
        return empresa;
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
            Empresa empresa = em.find(Empresa.class, id);

            System.out.println("Excluindo os dados de: " + empresa.getNome());

            //remove a empresa da base de dados
            em.remove(empresa);

            //finalizar a transação
            em.getTransaction().commit();

        } finally {
        //    em.close();
        }
    }
        /**
         * Consulta empresa pelo ID.
         * @param id
         * @return o objeto Empresa
         */

        public Empresa findById(Long id){


            Empresa empresa=null;

            try{
                //consulta uma empresa por ID
                empresa= em.find(Empresa.class,id);

        }finally {
          //      em.close();
            }
        return empresa;
    }

    /**
     * Consulta todas as empresas.
     * @param
     * @return o objeto Empresa
     */

    public List<Empresa> findAll(){

        List<Empresa> empresas=null;

        try {
            empresas=em.createQuery("from Empresa e").getResultList();//o e é o alias

        }catch (Exception e){
            System.err.println(e);
        }finally {

           // em.close();

        }
        return empresas;
    }



}
