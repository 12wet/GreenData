package com.greendata.domain.installation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.greendata.domain.client.Investor;
import com.greendata.domain.model.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Installation extends BaseEntity {

    private String address;
    private int installedPower;

    @Lob private String comment;
    @Lob private String response;

    @Enumerated(value = EnumType.STRING)
    private InstallationStatus installationStatus;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "investor_id")
    private Investor investor;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "installation")
    private Set<Quotation> quotations;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getInstalledPower() {
        return installedPower;
    }

    public void setInstalledPower(int installedPower) {
        this.installedPower = installedPower;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public InstallationStatus getInstallationStatus() {
        return installationStatus;
    }

    public void setInstallationStatus(InstallationStatus installationStatus) {
        this.installationStatus = installationStatus;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Set<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(Set<Quotation> quotations) {
        this.quotations = quotations;
    }
}