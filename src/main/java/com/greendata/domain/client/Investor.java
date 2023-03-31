package com.greendata.domain.client;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.greendata.domain.installation.Installation;
import com.greendata.domain.installation.Quotation;
import com.greendata.domain.model.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Investor extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

    private LocalDate firstVisit;
    private LocalDate awaitedContact;

    @Lob private String comment;
    @Lob private String response;

    @Enumerated(value = EnumType.STRING)
    private InterestStatus interestStatus;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personInCharge")
    private Set<Company> companies;

    @JsonManagedReference
    @OneToMany(mappedBy = "investor")
    private Set<Quotation> quotations;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investor")
    private Set<Installation> installations;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getFirstVisit() {
        return firstVisit;
    }

    public void setFirstVisit(LocalDate firstVisit) {
        this.firstVisit = firstVisit;
    }

    public LocalDate getAwaitedContact() {
        return awaitedContact;
    }

    public void setAwaitedContact(LocalDate awaitedContact) {
        this.awaitedContact = awaitedContact;
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

    public InterestStatus getInterestStatus() {
        return interestStatus;
    }

    public void setInterestStatus(InterestStatus interestStatus) {
        this.interestStatus = interestStatus;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(Set<Quotation> quotations) {
        this.quotations = quotations;
    }

    public Set<Installation> getInstallations() {
        return installations;
    }

    public void setInstallations(Set<Installation> installations) {
        this.installations = installations;
    }
}
