package at.htl.formula1.entity;

import javax.persistence.*;

/**
 * Formula1 - Team
 * <p>
 * The id's are assigned by the database.
 */
public class Team {

    private Long id;
    private String name;

    //region Constructors
    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }
    //endregion

    //region Getter and Setter

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%d: %s", id, name);
    }
}
