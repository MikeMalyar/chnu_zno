package com.chnu.zno.model;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teacherId;

    private String name;

    private String surname;

    private String subjectName;

    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
    private Subject subject;

    @OneToOne
    @JoinColumn(name = "school_id", referencedColumnName = "school_id", nullable = false)
    private School school;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    public Integer getTeacherId() {
        return teacherId;
    }

    public Teacher setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Teacher setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Teacher setSubjectName(String subjectName) {
        this.subjectName = subjectName;
        return this;
    }

    public Subject getSubject() {
        return subject;
    }

    public Teacher setSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public School getSchool() {
        return school;
    }

    public Teacher setSchool(School school) {
        this.school = school;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Teacher setUser(User user) {
        this.user = user;
        return this;
    }
}
