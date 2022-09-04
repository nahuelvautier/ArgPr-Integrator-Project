package com.portfolio.nahuelvautier.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String proName;
    private String proDescription;
    private String proApiUsed;
    private String proExpedition;
    private String proHref;

    public Project() {
    }

    public Project(String proName,
            String proDescription,
            String proApiUsed,
            String proExpedition,
            String proHref
    ) {
        this.proName = proName;
        this.proDescription = proDescription;
        this.proApiUsed = proApiUsed;
        this.proExpedition = proExpedition;
        this.proHref = proHref;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public String getProApiUsed() {
        return proApiUsed;
    }

    public void setProApiUsed(String apiUsed) {
        this.proApiUsed = apiUsed;
    }

    public String getProExpedition() {
        return proExpedition;
    }

    public void setProExpedition(String proExpedition) {
        this.proExpedition = proExpedition;
    }

    public String getProHref() {
        return proHref;
    }

    public void setProHref(String proHref) {
        this.proHref = proHref;
    }
}
