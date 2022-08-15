package com.portfolio.nahuelvautier.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String expName;
    private String expDescription;
    private String expReference;
    private String expImage;
    private String expSupplier;

    public Experience() {
    }

    public Experience(
            String expName,
            String expDescription,
            String expReference,
            String expImage,
            String expSupplier
        ) {
            this.expName = expName;
            this.expDescription = expDescription;
            this.expReference = expReference;
            this.expImage = expImage;
            this.expSupplier = expSupplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getExpDescription() {
        return expDescription;
    }

    public void setExpDescription(String expDescription) {
        this.expDescription = expDescription;
    }

    public String getExpReference() {
        return expReference;
    }

    public void setExpReference(String expReference) {
        this.expReference = expReference;
    }

    public String getExpImage() {
        return expImage;
    }

    public void setExpImage(String expImage) {
        this.expImage = expImage;
    }

    public String getExpSupplier() {
        return expSupplier;
    }

    public void setExpSupplier(String expSupplier) {
        this.expSupplier = expSupplier;
    }
}
