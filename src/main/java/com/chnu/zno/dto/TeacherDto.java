package com.chnu.zno.dto;

public class TeacherDto {

    private Integer teacherId;

    private String name;

    private String surname;

    private String subjectName;

    private Integer schoolId;

    private Integer subjectId;

    private Integer userId;

    public Integer getTeacherId() {
        return teacherId;
    }

    public TeacherDto setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public String getName() {
        return name;
    }

    public TeacherDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public TeacherDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public TeacherDto setSubjectName(String subjectName) {
        this.subjectName = subjectName;
        return this;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public TeacherDto setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public TeacherDto setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public TeacherDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
}
