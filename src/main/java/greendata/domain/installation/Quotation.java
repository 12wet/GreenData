package greendata.domain.installation;

import greendata.domain.client.Investor;
import greendata.domain.model.BaseEntity;

import javax.persistence.*;

@Entity
public class Quotation extends BaseEntity{

    private String description;
    private String quotation;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;

    @ManyToOne
    private Installation installation;
}
