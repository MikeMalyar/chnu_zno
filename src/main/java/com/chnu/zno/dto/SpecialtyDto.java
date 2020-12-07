package com.chnu.zno.dto;

public class SpecialtyDto {

    private Integer specialtyId;

    private String name;

    private Double min_gpa;

    private Integer schoolId;

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public SpecialtyDto setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
        return this;
    }

    public String getName() {
        return name;
    }

    public SpecialtyDto setName(String name) {
        this.name = name;
        return this;
    }

    public Double getMin_gpa() {
        return min_gpa;
    }

    public SpecialtyDto setMin_gpa(Double min_gpa) {
        this.min_gpa = min_gpa;
        return this;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public SpecialtyDto setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }
}
