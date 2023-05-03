package org.example.Lab9.Repos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Lab9.Entity.AbstractEntity;
import org.example.Lab9.Entity.GenresEntity;

import java.io.Serializable;
import java.util.List;

public abstract class DataRepository
        <T extends AbstractEntity, ID extends Serializable> {
    public static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");
    public static EntityManager em=emf.createEntityManager();
    private Class<T> type;

    public DataRepository(Class<T> type) {
        this.type = type;
    }

    public T findById(int id) {
        String string=type.getSimpleName()+".findById";
        return (T) em.createNamedQuery(string)
                .setParameter("id",id)
                .getSingleResult();
    }
    public List<T> findByName(String name)
    {
        String string=type.getSimpleName()+".findByName";
        return em.createNamedQuery(string)
                .setParameter("name", name)
                .getResultList();
    }
    public void create(T entity) {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
    }
}

