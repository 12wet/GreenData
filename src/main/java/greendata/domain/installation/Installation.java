package greendata.domain.installation;

import greendata.domain.client.Investor;
import greendata.domain.model.BaseEntity;
import org.apache.tomcat.websocket.pojo.PojoMessageHandlerWholeBase;

import javax.persistence.*;
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