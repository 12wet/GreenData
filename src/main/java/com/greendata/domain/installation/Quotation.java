package com.greendata.domain.installation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.greendata.domain.client.Investor;
import com.greendata.domain.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Quotation extends BaseEntity {

    @Lob
    private String description;
    @Lob
    private byte[] quotation;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "investor_id")
    private Investor investor;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "installation_id")
    private Installation installation;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getQuotation() {
        return quotation;
    }

    public void setQuotation(byte[] quotation) {
        this.quotation = quotation;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Installation getInstallation() {
        return installation;
    }

    public void setInstallation(Installation installation) {
        this.installation = installation;
    }

    @Override
    public String toString() {
        return "Quotation{" +
                "description='" + description + '\'' +
                ", investor=" + investor +
                ", installation=" + installation +
                '}';
    }
}
