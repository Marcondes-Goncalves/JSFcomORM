package com.marcondes.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    
    private static EntityManagerFactory factory = null;

    // Acessa o arquivo que contém as configurações do banco de dados e cria uma conexão com o mesmo
    static {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("JSFcomORM");
        }
    }

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

}
