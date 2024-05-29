package com.marcondes.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.marcondes.jpautil.JPAUtil;

public class DaoGeneric<E> {
    

    //APENAS SALVA
    public void salvar(E entidade){

        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(entidade);

        entityTransaction.commit();
        entityManager.close();
    }

    //SALVA OU ATUALIZA E RETONAR O OBJETO
    public E merge(E entidade){

        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        E retorno = entityManager.merge(entidade);

        entityTransaction.commit();
        entityManager.close();

        return retorno;
    }
}
