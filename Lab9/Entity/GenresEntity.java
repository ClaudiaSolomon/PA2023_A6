package org.example.Lab9.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "genres", schema = "java", catalog = "")
@NamedQueries({
        @NamedQuery(name = "GenresEntity.findAll",
                query = "select e from GenresEntity e order by e.name"),
        @NamedQuery(name = "GenresEntity.findById",
                query = "select e from GenresEntity e where e.id = :id"),
        @NamedQuery(name = "GenresEntity.findByName",
                query = "select e from GenresEntity e where e.name = :name"),
})
public class GenresEntity extends AbstractEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @ManyToMany
    private Set<ArtistsEntity> artistsEntitySet;
    @ManyToMany
    private Set<AlbumsEntity> albumsEntitySet;
    public GenresEntity() {
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

    public GenresEntity(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenresEntity that = (GenresEntity) o;

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
        return "GenresEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
