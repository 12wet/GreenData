package com.greendata.domain.installation;

import com.greendata.domain.client.Investor;
import com.greendata.domain.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Quotation extends BaseEntity {

    private String description;
    private String quotation;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;

    @ManyToOne
    private Installation installation;
}
