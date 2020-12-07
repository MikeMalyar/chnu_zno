package com.chnu.zno.dto;

public class IntroductionDto {

    private Integer introductionId;

    private Integer schoolId;

    private Integer specialtyId;

    private Integer subjectId;

    public Integer getIntroductionId() {
        return introductionId;
    }

    public IntroductionDto setIntroductionId(Integer introductionId) {
        this.introductionId = introductionId;
        return this;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public IntroductionDto setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public IntroductionDto setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
        return this;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public IntroductionDto setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
        return this;
    }
}
