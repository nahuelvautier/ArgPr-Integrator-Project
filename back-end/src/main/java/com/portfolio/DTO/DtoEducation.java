package com.portfolio.DTO;

import javax.validation.constraints.NotBlank;

public class DtoEducation {
    @NotBlank
    private String eduName;
    @NotBlank
    private String eduCareer;
    @NotBlank
    private String eduExpedition;
    @NotBlank
    private String eduDescription;
    @NotBlank
    private String eduImage;

    public DtoEducation() {
    }

    public DtoEducation(
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
