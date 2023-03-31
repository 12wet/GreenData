package com.greendata.domain.client;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.greendata.domain.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Company extends BaseEntity {

    private String name;
    private String address;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "investor_id")
    private Investor personInCharge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Investor getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(Investor personInCharge) {
        this.personInCharge = personInCharge;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", personInCharge=" + personInCharge +
                '}';
    }
}