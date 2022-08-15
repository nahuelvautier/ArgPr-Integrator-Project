package com.portfolio.DTO;

import javax.validation.constraints.NotBlank;

public class DtoExperience {
    @NotBlank
    private String expName;
    @NotBlank
    private String expDescription;
    @NotBlank
    private String expReference;
    @NotBlank
    private String expImage;
    @NotBlank
    private String expSupplier;

    public DtoExperience() {
    }

    public DtoExperience(
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
