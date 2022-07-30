package greendata.domain.client;

import greendata.domain.installation.Installation;
import greendata.domain.installation.Quotation;
import greendata.domain.model.BaseEntity;

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

    private String comment;
    private String response;

    @Enumerated(value = EnumType.STRING)
    private InterestStatus clientInterest;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personInCharge")
    private Set<Company> company;

    @OneToMany(mappedBy = "investor")
    private Set<Quotation> quotations;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investor")
    private Set<Installation> installations;

}
