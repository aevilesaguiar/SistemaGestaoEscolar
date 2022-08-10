package com.treinamento.dao;

import com.treinamento.model.Unidade;

import javax.persistence.EntityManager;
import java.util.List;

public class UnidadeDAO {

    private EntityManager em;

   public UnidadeDAO(EntityManager em){

        this.em=em;
   }

   public Unidade save(Unidade unidade){

       try{
           em.getTransaction().begin();

       if(unidade ==null){

           em.persist(unidade);

       }else {

          unidade = em.merge(unidade);
       }

       em.getTransaction().commit();

       }catch (Exception e){

           System.err.println(e);

           em.getTransaction().rollback();

       }finally {
           em.close();
       }


       return unidade;


   }

   public void delete(Long id){

       try{
           em.getTransaction().begin();

          Unidade unidade =em.find(Unidade.class,id);
           System.out.println("Excluindo os dados de: " + unidade.getEmpresa());

           em.remove(unidade);

           em.getTransaction().commit();
       }finally {
           em.close();
       }

   }


   public Unidade findById(Long id){

       Unidade unidade =null;

       try{
           unidade =em.find(Unidade.class,id);
       }finally {
           em.close();
       }
       return unidade;
   }


   public List<Unidade> findAll(){

       List<Unidade> unidadesEscolares=null;
       try{
           unidadesEscolares=em.createQuery("from UnidadeEscolar u").getResultList();
       }catch (Exception e){
           System.err.println(e);
       }finally {
           em.close();
       }
       return  unidadesEscolares;
   }










}
