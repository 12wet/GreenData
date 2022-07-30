package greendata.domain.client;

import greendata.domain.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Company extends BaseEntity {

    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor personInCharge;
}