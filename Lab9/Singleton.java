package org.example.Lab9;

import org.example.Entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Lab9.Entity.ArtistsEntity;

import java.sql.SQLException;

public class Singleton {
    public void testJPA() throws SQLException {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        ArtistsEntity artist = new ArtistsEntity("Beatles");
        em.persist(artist);

        ArtistsEntity a = (ArtistsEntity)em.createQuery(
                        "select e from ArtistsEntity e where e.name='Beatles'")
                .getSingleResult();
        a.setName("The Beatles");
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
