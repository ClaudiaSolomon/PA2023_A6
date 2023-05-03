package org.example.Lab9.Repos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Lab9.Entity.GenresEntity;

import java.sql.SQLException;
import java.util.List;

public class GenreRepository extends DataRepository<GenresEntity, Integer> {
    public static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");
    public static EntityManager em=emf.createEntityManager();

    public GenreRepository(Class<GenresEntity> type) {
        super(type);
    }

//    public List<GenresEntity> findByName(String name) {
//        return em.createNamedQuery("GenresEntity.findByName")
//                .setParameter("name", name)
//                .getResultList();
//
//    }
//    public GenresEntity findById(Integer id)
//    {
//        return (GenresEntity) em.createNamedQuery("GenresEntity.findById")
//                .setParameter("id",id)
//                .getSingleResult();
//    }
//    public void create(GenresEntity genre) {
//        em.getTransaction().begin();
//        em.persist(genre);
////        System.out.printf(genre.getName());
//        em.getTransaction().commit();
////        em.close();
////        emf.close();
//    }
}
