package com.chnu.zno.dto;

public class CarryingPlaceDto {

    private Integer classId;

    private Integer number;

    private Integer count;

    private Integer teacherId;

    private Integer schoolId;

    public Integer getClassId() {
        return classId;
    }

    public CarryingPlaceDto setClassId(Integer classId) {
        this.classId = classId;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public CarryingPlaceDto setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public CarryingPlaceDto setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public CarryingPlaceDto setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public CarryingPlaceDto setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }
}
