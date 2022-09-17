package com.portfolio.nahuelvautier.DTO;

import javax.validation.constraints.NotBlank;


public class DtoPerson {
    @NotBlank
    private String personName;
    @NotBlank
    private String personTitle;
    @NotBlank
    private String personDescription;
    @NotBlank
    private String personPicture;
    @NotBlank
    private String personBanner;

    public DtoPerson() {
    }

    public DtoPerson(
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
