package com.chnu.zno.dto;

import java.sql.Date;

public class EntrantDto {

    private Integer studentId;

    private String name;

    private String surname;

    private Date dateOfBirth;

    private String passport_id;

    private Integer schoolId;

    private Integer userId;

    public Integer getStudentId() {
        return studentId;
    }

    public EntrantDto setStudentId(Integer studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getName() {
        return name;
    }

    public EntrantDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public EntrantDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public EntrantDto setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getPassport_id() {
        return passport_id;
    }

    public EntrantDto setPassport_id(String passport_id) {
        this.passport_id = passport_id;
        return this;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public EntrantDto setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public EntrantDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
}
