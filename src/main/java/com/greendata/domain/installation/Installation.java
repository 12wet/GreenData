package com.greendata.domain.installation;

import com.greendata.domain.client.Investor;
import com.greendata.domain.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
public class Installation extends BaseEntity {

    private String description;
    private String address;
    private int installedPower;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;
    private Set<Quotation> quotations;
}