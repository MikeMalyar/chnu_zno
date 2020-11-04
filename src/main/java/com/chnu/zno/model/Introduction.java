package com.chnu.zno.model;

import javax.persistence.*;

@Entity
@Table(name = "introduction")
public class Introduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "possibility_id")
    private Integer possibilityId;

    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
    private Subject subject;

    @OneToOne
    @JoinColumn(name = "specialty_id", referencedColumnName = "specialty_id", nullable = false)
    private Specialty specialty;

    @OneToOne
    @JoinColumn(name = "school_id", referencedColumnName = "school_id", nullable = false)
    private School school;

    public Integer getPossibilityId() {
        return possibilityId;
    }

    public Introduction setPossibilityId(Integer possibilityId) {
        this.possibilityId = possibilityId;
        return this;
    }

    public Subject getSubject() {
        return subject;
    }

    public Introduction setSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public Introduction setSpecialty(Specialty specialty) {
        this.specialty = specialty;
        return this;
    }

    public School getSchool() {
        return school;
    }

    public Introduction setSchool(School school) {
        this.school = school;
        return this;
    }
}
