package com.chnu.zno.model;

import javax.persistence.*;

@Entity
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Integer certificateId;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    private Entrant student;

    @OneToOne
    @JoinColumn(name = "session_id", referencedColumnName = "session_id", nullable = false)
    private Session session;

    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
    private Subject subject;

    @OneToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id", nullable = false)
    private CarryingPlace carryingPlace;

    public Integer getCertificateId() {
        return certificateId;
    }

    public Certificate setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
        return this;
    }

    public Entrant getStudent() {
        return student;
    }

    public Certificate setStudent(Entrant student) {
        this.student = student;
        return this;
    }

    public Session getSession() {
        return session;
    }

    public Certificate setSession(Session session) {
        this.session = session;
        return this;
    }

    public Subject getSubject() {
        return subject;
    }

    public Certificate setSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public CarryingPlace getCarryingPlace() {
        return carryingPlace;
    }

    public Certificate setCarryingPlace(CarryingPlace carryingPlace) {
        this.carryingPlace = carryingPlace;
        return this;
    }
}
