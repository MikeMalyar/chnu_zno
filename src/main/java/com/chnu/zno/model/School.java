package com.chnu.zno.model;

import javax.persistence.*;

@Entity
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private Integer schoolId;

    private String name;

    private String address;

    private String phone;

    public Integer getSchoolId() {
        return schoolId;
    }

    public School setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }

    public String getName() {
        return name;
    }

    public School setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public School setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public School setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
