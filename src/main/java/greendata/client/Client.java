package greendata.client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Client {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;

    private InterestStatus clientInterest;
    private Address clientAddress;
    private List<Address> installationAddresses;
    private List<Quotation> quotations;

    private String comment;
    private String response;

    public Client() {}

    public Client(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public InterestStatus getClientInterest() {
        return clientInterest;
    }

    public void setClientInterest(InterestStatus clientInterest) {
        this.clientInterest = clientInterest;
    }

    public Address getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }

    public List<Address> getInstallationAddresses() {
        return installationAddresses;
    }

    public void setInstallationAddresses(List<Address> installationAddresses) {
        this.installationAddresses = installationAddresses;
    }

    public List<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(List<Quotation> quotations) {
        this.quotations = quotations;
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
}
