package com.group2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private long userId;
    private long transportId;

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public long getTransportId() {
        return transportId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setTransportId(long transportId) {
        this.transportId = transportId;
    }
}
