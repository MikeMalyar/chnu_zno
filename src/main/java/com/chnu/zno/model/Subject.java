package com.chnu.zno.model;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer subjectId;

    private String name;

    private String program;

    private Boolean necessarily;

    public Integer getSubjectId() {
        return subjectId;
    }

    public Subject setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Subject setName(String name) {
        this.name = name;
        return this;
    }

    public String getProgram() {
        return program;
    }

    public Subject setProgram(String program) {
        this.program = program;
        return this;
    }

    public Boolean getNecessarily() {
        return necessarily;
    }

    public Subject setNecessarily(Boolean necessarily) {
        this.necessarily = necessarily;
        return this;
    }
}
