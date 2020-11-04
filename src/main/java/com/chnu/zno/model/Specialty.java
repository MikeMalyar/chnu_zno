package com.chnu.zno.model;

import javax.persistence.*;

@Entity
@Table(name = "specialties")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialty_id")
    private Integer specialtyId;

    private String name;

    private Double min_gpa;

    @OneToOne
    @JoinColumn(name = "school_id", referencedColumnName = "school_id", nullable = false)
    private School school;

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public Specialty setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Specialty setName(String name) {
        this.name = name;
        return this;
    }

    public Double getMin_gpa() {
        return min_gpa;
    }

    public Specialty setMin_gpa(Double min_gpa) {
        this.min_gpa = min_gpa;
        return this;
    }

    public School getSchool() {
        return school;
    }

    public Specialty setSchool(School school) {
        this.school = school;
        return this;
    }
}
