package ru.digitalleague.ocs.internship.lesson16;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("satire")
public class SatireBook16 extends Book16 {

    public SatireBook16() {
    }

    public SatireBook16(Long id, String title, Category16 category, String image, int year, List<Author16> authors, long price, int vat) {
        super(id, title, category, image, year, authors, price, vat);
    }

    @Override
    public String toString() {
        return super.toString() + ", type: satire";
    }
}
