package com.portfolio.nahuelvautier.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String personName;
    private String personTitle;
    private String personDescription;
    private String personPicture;
    private String personBanner;

    public Person() {
    }
    
    public Person(
            String personName,
            String personTitle,
            String personDescription,
            String personPicture,
            String personBanner
    ) {
        this.personName = personName;
        this.personTitle = personTitle;
        this.personDescription = personDescription;
        this.personPicture = personPicture;
        this.personBanner = personBanner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonTitle() {
        return personTitle;
    }

    public void setPersonTitle(String personTitle) {
        this.personTitle = personTitle;
    }

    public String getPersonDescription() {
        return personDescription;
    }

    public void setPersonDescription(String personDescription) {
        this.personDescription = personDescription;
    }

    public String getPersonPicture() {
        return personPicture;
    }

    public void setPersonPicture(String personPicture) {
        this.personPicture = personPicture;
    }

    public String getPersonBanner() {
        return personBanner;
    }

    public void setPersonBanner(String personBanner) {
        this.personBanner = personBanner;
    }
}
