package com.chnu.zno.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "entrant")
public class Entrant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    private String name;

    private String surname;

    private Date dateOfBirth;

    private String passport_id;

    @OneToOne
    @JoinColumn(name = "school_id", referencedColumnName = "school_id", nullable = false)
    private School school;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    public Integer getStudentId() {
        return studentId;
    }

    public Entrant setStudentId(Integer studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Entrant setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Entrant setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Entrant setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getPassport_id() {
        return passport_id;
    }

    public Entrant setPassport_id(String passport_id) {
        this.passport_id = passport_id;
        return this;
    }

    public School getSchool() {
        return school;
    }

    public Entrant setSchool(School school) {
        this.school = school;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Entrant setUser(User user) {
        this.user = user;
        return this;
    }
}
