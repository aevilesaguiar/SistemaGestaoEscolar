package com.treinamento.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    /**
     * Método utilizado para obter o entity manager.
     * @return
     */
    private static EntityManagerFactory factory;
    static {
        factory = Persistence.createEntityManagerFactory("sistema");
    }
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
    public static void close() {
        factory.close();
    }

}
