package ru.digitalleague.ocs.internship.lesson16;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "authors")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Author16 extends AbstractAuthor {

    public Author16() {
    }

    public Author16(Long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "id: " + getId() + ", name: " + getName();
    }
}
