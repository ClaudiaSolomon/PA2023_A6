package org.example.Lab9.Repos;

import jakarta.persistence.*;
import org.example.Lab9.Entity.ArtistsEntity;

import java.sql.SQLException;
import java.util.List;

public class ArtistRepository extends DataRepository<ArtistsEntity, Integer> {
   public static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");
    public static EntityManager em=emf.createEntityManager();

    public ArtistRepository(Class<ArtistsEntity> type) {
        super(type);
    }

//    public List<ArtistsEntity> findByName(String name) {
//        return em.createNamedQuery("ArtistsEntity.findByName")
//                .setParameter("name", name)
//                .getResultList();
//
//    }
//    public ArtistsEntity findById(Integer id)
//    {
//        return (ArtistsEntity) em.createNamedQuery("ArtistsEntity.findById")
//                .setParameter("id",id)
//                .getSingleResult();
//    }
//    public void create(ArtistsEntity artist) {
//        em.getTransaction().begin();
//        em.persist(artist);
////        System.out.printf(artist.getName());
//        em.getTransaction().commit();
////        em.close();
////        emf.close();
//    }
}