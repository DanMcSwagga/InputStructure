package ua.kpi.model;

public class Address {
    private String zipCode;
    private String cityOfResidence;
    private String street;
    private String houseNumber;
    private String apartmentNumber;

    public Address(String zipCode, String cityOfResidence, String street, String houseNumber, String apartmentNumber) {
        this.zipCode = zipCode;
        this.cityOfResidence = cityOfResidence;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public String getZipCode() { return zipCode; }
    public String getCityOfResidence() { return cityOfResidence; }
    public String getStreet() { return street; }
    public String getHouseNumber() { return houseNumber; }
    public String getApartmentNumber() { return apartmentNumber; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setCityOfResidence(String cityOfResidence) { this.cityOfResidence = cityOfResidence;  }
    public void setStreet(String street) { this.street = street; }
    public void setHouseNumber(String houseNumber) { this.houseNumber = houseNumber; }
    public void setApartmentNumber(String apartmentNumber) { this.apartmentNumber = apartmentNumber; }

    @Override
    public String toString() {
        return "\nZip code: " + zipCode + ';' +
                "\nAddress: " + cityOfResidence + ", " +
                street + " str. " + ' ' + houseNumber + ", " + apartmentNumber;
    }
}
