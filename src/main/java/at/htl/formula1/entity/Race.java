package at.htl.formula1.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Formula1 - Race
 *
 * The id's are not assigned by the database. The id's are given.
 */
public class Race {

    private Long id;
    private String country;
    private LocalDate date;

    //region Constructors
    public Race() {
    }

    public Race(Long id, String country, LocalDate date) {
        this.id = id;
        this.country = country;
        this.date = date;
    }
    //endregion

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    //endregion


    @Override
    public String toString() {
        return String.format("%d: %s (%te.%tm,%tY)",id,country,date,date,date);
    }
}
