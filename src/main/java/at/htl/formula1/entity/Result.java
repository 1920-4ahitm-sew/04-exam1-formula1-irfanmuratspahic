package at.htl.formula1.entity;

import javax.persistence.*;

/**
 * Formula1 - Result
 * <p>
 * The id's are assigned by the database.
 */
public class Result {

    @Transient
    public int[] pointsPerPosition = {0, 25, 18, 15, 12, 10, 8, 6, 4, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    Long id;
    @ManyToOne
    private Race race;
    private int position;
    private int points;
    @ManyToOne
    private Driver driver;


    //region Constructors
    public Result() {
    }

    public Result(Race race, int position, Driver driver) {
        this.setRace(race);
        this.setPosition(position);
        this.setDriver(driver);
    }
    //endregion


    //region Getter and Setter

    public Long getId() {
        return id;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
        this.points = pointsPerPosition[position];
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    //endregion


    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", race=" + race.getCountry() +
                ", position=" + position +
                ", points=" + points +
                ", driver=" + driver.getName() +
                '}';
    }
}
