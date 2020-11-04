package com.chnu.zno.model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Integer sessionId;

    private Date date;

    private Time time;

    public Integer getSessionId() {
        return sessionId;
    }

    public Session setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Session setDate(Date date) {
        this.date = date;
        return this;
    }

    public Time getTime() {
        return time;
    }

    public Session setTime(Time time) {
        this.time = time;
        return this;
    }
}
