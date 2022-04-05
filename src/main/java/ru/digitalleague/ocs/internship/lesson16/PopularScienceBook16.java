package ru.digitalleague.ocs.internship.lesson16;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("popular-science")
public class PopularScienceBook16 extends Book16 {

    @Column(name = "science_field")
    private String scienceField;

    public PopularScienceBook16() {
    }

    public PopularScienceBook16(Long id, String title, Category16 category, String image, int year, List<Author16> authors, long price, int vat, String scienceField) {
        super(id, title, category, image, year, authors, price, vat);
        this.scienceField = scienceField;
    }

    public String getScienceField() {
        return scienceField;
    }

    public void setScienceField(String scienceField) {
        this.scienceField = scienceField;
    }

    @Override
    public String toString() {
        return super.toString() + ", type: popular science";
    }
}
