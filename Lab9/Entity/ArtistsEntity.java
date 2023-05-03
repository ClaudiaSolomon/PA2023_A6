package org.example.Lab9.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "artists", schema = "java", catalog = "")
@NamedQueries({
        @NamedQuery(name = "ArtistsEntity.findAll",
                query = "select e from ArtistsEntity e order by e.name"),
        @NamedQuery(name = "ArtistsEntity.findById",
                query = "select e from ArtistsEntity e where e.id = :id"),
        @NamedQuery(name = "ArtistsEntity.findByName",
                query = "select e from ArtistsEntity e where e.name = :name"),
})
public class ArtistsEntity extends AbstractEntity {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany
    private Set<AlbumsEntity> albumsEntitySet;
    @ManyToMany
    private Set<GenresEntity> genresEntitySet;

    public ArtistsEntity() {

    }

    public ArtistsEntity(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistsEntity that = (ArtistsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArtistsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
