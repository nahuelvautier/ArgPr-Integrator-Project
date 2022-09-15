package com.portfolio.nahuelvautier.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HardSoftSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int hsPercent;
    private String hsTitle;
    private String hsImage;

    public HardSoftSkill() {
    }

    public HardSoftSkill(int hsPercent, String hsTitle, String hsImage) {
        this.hsPercent = hsPercent;
        this.hsTitle = hsTitle;
        this.hsImage = hsImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHsPercent() {
        return hsPercent;
    }

    public void setHsPercent(int hsPercent) {
        this.hsPercent = hsPercent;
    }

    public String getHsTitle() {
        return hsTitle;
    }

    public void setHsTitle(String hsTitle) {
        this.hsTitle = hsTitle;
    }

    public String getHsImage() {
        return hsImage;
    }

    public void setHsImage(String hsImage) {
        this.hsImage = hsImage;
    }
}