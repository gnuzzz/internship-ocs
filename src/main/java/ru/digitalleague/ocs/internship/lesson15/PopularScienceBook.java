package ru.digitalleague.ocs.internship.lesson15;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("popular-science")
public class PopularScienceBook extends Book {

    @Column(name = "science_field")
    private String scienceField;

    public PopularScienceBook() {
    }

    public PopularScienceBook(Long id, String title, Category category, String image, String scienceField) {
        super(id, title, category, image);
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
