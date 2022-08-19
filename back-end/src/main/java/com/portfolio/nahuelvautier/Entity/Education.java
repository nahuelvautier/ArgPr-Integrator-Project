package com.portfolio.nahuelvautier.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eduName;
    private String eduCareer;
    private String eduExpedition;
    private String eduDescription;
    private String eduImage;

    public Education() {
    }

    public Education(
            String eduName,
            String eduCareer,
            String eduExpedition,
            String eduDescription,
            String eduImage
    ) {
        this.eduName = eduName;
        this.eduCareer = eduCareer;
        this.eduExpedition = eduExpedition;
        this.eduDescription = eduDescription;
        this.eduImage = eduImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    public String getEduCareer() {
        return eduCareer;
    }

    public void setEduCareer(String eduCareer) {
        this.eduCareer = eduCareer;
    }

    public String getEduExpedition() {
        return eduExpedition;
    }

    public void setEduExpedition(String eduExpedition) {
        this.eduExpedition = eduExpedition;
    }

    public String getEduDescription() {
        return eduDescription;
    }

    public void setEduDescription(String eduDescription) {
        this.eduDescription = eduDescription;
    }

    public String getEduImage() {
        return eduImage;
    }

    public void setEduImage(String eduImage) {
        this.eduImage = eduImage;
    }
}
