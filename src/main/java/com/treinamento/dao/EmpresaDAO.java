package com.treinamento.dao;


import com.treinamento.model.Empresa;
import com.treinamento.model.Unidade;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


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

                em.persist(empresa);//persiste os dados no BD executa o insert
                System.out.println("Incluído Empresa:"+empresa.getId() +" - "+empresa.getNome());
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
     * Método que atualiza a empresa do banco de dados.
     * @param id,empre
     */

    public Empresa update(Long id, String empre) {

        Empresa empresa =null;

        try{
            //inicia uma transação no banco de dados
            em.getTransaction().begin();



            System.out.println("Atualizando empresa");
            empresa=em.find(Empresa.class,id);

            System.out.println("Dado atual :"+empresa.getId()+" - "+empresa.getNome());
            empresa.setNome(empre);
            System.out.println("Dado Novo: "+empresa.getId()+" - "+empresa.getNome());

            em.getTransaction().commit();

        } catch (Exception e){
            System.out.println("Erro na atualização!");
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

            System.out.println("Excluindo: " +empresa.getId() +" - "+empresa.getNome());

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
                System.out.println("Dados empresa:"+empresa.getId()+ "- "+empresa.getNome());

        }finally {
          //      em.close();
            }
        return empresa;
    }

    /**
     * Consulta empresa usando getReference.
     * @param
     * @return o id
     */

    public Empresa findById2(Long id){

        Empresa empresa=null;

        try {
           empresa=em.getReference(Empresa.class,id);
            System.out.println("Id:"+ empresa.getId()+" Nome: "+empresa.getNome());
        }catch (Exception e){
            System.err.println(e);
            System.out.println("Id :"+id + " não localizado no nosso BD!");
        }finally {

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

            System.out.println("Buscar todas as empresas: ");
            for (Empresa empresa:empresas
                 ) {
                System.out.println(
                "Id:"+empresa.getId()+" Nome:"+empresa.getNome()+"");

            }

        }catch (Exception e){
            System.err.println(e);
            System.out.println("Não existem empresas cadastradas");
        }finally {

           // em.close();

        }
        return empresas;
    }

    public List<Empresa> findAll2(){

        List<Empresa> empresas=null;

        try {
            //não se usa muito o query, e sim o TypedQuery
            Query query=em.createQuery("select e from Empresa e");
            empresas=query.getResultList();

            for (Empresa empresa:empresas
            ) {
                System.out.println(
                        "Id:"+empresa.getId()+" Nome:"+empresa.getNome()+"");

            }

        }catch (Exception e){
            System.err.println(e);
            System.out.println("Não existem empresas cadastradas");
        }finally {

            // em.close();

        }
        return empresas;
    }

    public List<Empresa> findAll3(){

        String jpql ="select e from Empresa e";//"e" é o alias

        List<Empresa> empresas=null;

        try {
            //não se usa muito o query, e sim o TypedQuery
            TypedQuery<Empresa> typedQuery=em.createQuery(jpql, Empresa.class);

            empresas=typedQuery.getResultList();

            empresas.forEach(e-> System.out.println(e.getId()+" - "+ e.getNome()));

        }catch (Exception e){
            System.err.println(e);
            System.out.println("Não existem empresas cadastradas");
        }finally {

            // em.close();

        }
        return empresas;
    }



}
