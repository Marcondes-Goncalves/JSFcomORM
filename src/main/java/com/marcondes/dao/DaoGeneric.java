package com.marcondes.dao;

import java.util.List;

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

    public void deletar(E entidade){

        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.remove(entidade);

        entityTransaction.commit();
        entityManager.close();
    }

    public void deletarPorId(E entidade){

        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Object id = JPAUtil.getPrimaryKey(entidade);

        entityManager.createQuery("DELETE FROM " + entidade.getClass().getCanonicalName() + " WHERE id = " + id).executeUpdate();

        entityTransaction.commit();
        entityManager.close();
    }

    public List<E> getListEntity(Class<E> entidade){

        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        @SuppressWarnings("unchecked")
        List<E> retorno = entityManager.createQuery("FROM " + entidade.getName()).getResultList();


        entityTransaction.commit();
        entityManager.close();

        return retorno;
    }
}
