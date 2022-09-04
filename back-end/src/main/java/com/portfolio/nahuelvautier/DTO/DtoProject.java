package com.portfolio.nahuelvautier.DTO;

import javax.validation.constraints.NotBlank;

public class DtoProject {
    @NotBlank
    private String proName;
    @NotBlank
    private String proDescription;
    private String proApiUsed;
    @NotBlank
    private String proExpedition;
    @NotBlank
    private String proHref;

    public DtoProject() {
    }

    public DtoProject(String proName,
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

    public void setApiUsed(String apiUsed) {
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
