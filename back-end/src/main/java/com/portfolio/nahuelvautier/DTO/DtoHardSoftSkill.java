package com.portfolio.nahuelvautier.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DtoHardSoftSkill {
    @NotBlank
    @NotNull
    private int hsPercent;
    @NotBlank
    private String hsTitle;
    
    private String hsImage;

    public DtoHardSoftSkill() {
    }

    public DtoHardSoftSkill(int hsPercent, String hsTitle, String hsImage) {
        this.hsPercent = hsPercent;
        this.hsTitle = hsTitle;
        this.hsImage = hsImage;
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