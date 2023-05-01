package org.example.Lab9.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "genres", schema = "java", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Genre.findAll",
                query = "select e from GenresEntity e order by e.name"),
        @NamedQuery(name = "Genre.findById",
                query = "select e from GenresEntity e where e.id = :id"),
        @NamedQuery(name = "Genre.findByName",
                query = "select e from GenresEntity e where e.name = :name"),
})
public class GenresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

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
