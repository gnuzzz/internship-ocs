package ru.digitalleague.ocs.internship.lesson15;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("satire")
public class SatireBook extends Book {

    public SatireBook() {
    }

    public SatireBook(Long id, String title, Category category, String image) {
        super(id, title, category, image);
    }

    @Override
    public String toString() {
        return super.toString() + ", type: satire";
    }
}
