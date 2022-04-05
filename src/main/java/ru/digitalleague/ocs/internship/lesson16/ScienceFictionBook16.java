package ru.digitalleague.ocs.internship.lesson16;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("science-fiction")
public class ScienceFictionBook16 extends Book16 {

    @Column(name = "genre")
    private String genre;

    public ScienceFictionBook16() {
    }

    public ScienceFictionBook16(Long id, String title, Category16 category, String image, int year, List<Author16> authors, long price, int vat, String genre) {
        super(id, title, category, image, year, authors, price, vat);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + ", type: science fiction";
    }
}
