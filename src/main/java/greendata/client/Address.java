package greendata.client;

import java.util.Objects;

public class Address {

    private String country;
    private String voivodeship;
    private String postalCode;
    private String streetName;
    private int houseNumber;

    public Address(String country, String voivodeship, String postalCode, String streetName, int houseNumber) {
        this.country = country;
        this.voivodeship = voivodeship;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber && Objects.equals(country, address.country) && Objects.equals(voivodeship, address.voivodeship) && Objects.equals(postalCode, address.postalCode) && streetName.equals(address.streetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, voivodeship, postalCode, streetName, houseNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", voivodeship='" + voivodeship + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
