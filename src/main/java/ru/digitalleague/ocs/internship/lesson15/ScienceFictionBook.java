package ru.digitalleague.ocs.internship.lesson15;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("science-fiction")
public class ScienceFictionBook extends Book {

    @Column(name = "genre")
    private String genre;

    public ScienceFictionBook() {
    }

    public ScienceFictionBook(Long id, String title, Category category, String image, String genre) {
        super(id, title, category, image);
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
