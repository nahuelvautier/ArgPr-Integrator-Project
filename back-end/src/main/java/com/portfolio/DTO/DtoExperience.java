package com.portfolio.DTO;

import javax.validation.constraints.NotBlank;

public class DtoExperience {
    @NotBlank
    private String expName;
    @NotBlank
    private String ExpDescription;

    public DtoExperience() {
    }

    public DtoExperience(String expName, String ExpDescription) {
        this.expName = expName;
        this.ExpDescription = ExpDescription;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getExpDescription() {
        return ExpDescription;
    }

    public void setExpDescription(String ExpDescription) {
        this.ExpDescription = ExpDescription;
    }
}
