package org.example.Lab9.Repos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Lab9.Entity.AlbumsEntity;

import java.sql.SQLException;
import java.util.List;

public class AlbumRepository {
    public static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");
    public static EntityManager em=emf.createEntityManager();
    public List<AlbumsEntity> findByName(String name) {
        return em.createNamedQuery("Album.findByName")
                .setParameter("name", name)
                .getResultList();

    }
    public AlbumsEntity findById(Integer id)
    {
        return (AlbumsEntity) em.createNamedQuery("Album.findById")
                .setParameter("id",id)
                .getSingleResult();
    }
    public void create(AlbumsEntity album) throws SQLException {
        em.getTransaction().begin();
        em.persist(album);
//        System.out.printf(album.getName());
        em.getTransaction().commit();
//        em.close();
//        emf.close();
    }
}
