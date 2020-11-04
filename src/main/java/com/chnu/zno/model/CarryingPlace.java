package com.chnu.zno.model;

import javax.persistence.*;

@Entity
@Table(name = "carrying_place")
public class CarryingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Integer classId;

    private Integer number;

    private Integer count;

    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id", nullable = false)
    private Teacher teacher;

    @OneToOne
    @JoinColumn(name = "school_id", referencedColumnName = "school_id", nullable = false)
    private School school;

    public Integer getClassId() {
        return classId;
    }

    public CarryingPlace setClassId(Integer classId) {
        this.classId = classId;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public CarryingPlace setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public CarryingPlace setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public CarryingPlace setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    public School getSchool() {
        return school;
    }

    public CarryingPlace setSchool(School school) {
        this.school = school;
        return this;
    }
}
