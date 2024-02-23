public class Address {
    private String houseNumber;
    private String streetName;
    private String aptNumber;
    private String city;
    private String state;
    private int zipCode;

    public Address(String houseNumber, String streetName, String aptNumber, String city, String state, int zipCode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.aptNumber = aptNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(Address address) {
        this(address.getHouseNumber(), address.getStreetName(), address.getAptNumber(), address.getCity(), address.getState(), address.zipCode);
    }

    public Address(String address) {
        this.houseNumber = address.substring(0, address.indexOf(" "));
        address = address.substring(address.indexOf(" ") + 1);

        if (!address.contains(" Apt ")) {
            this.streetName = address.substring(0, address.indexOf(","));
            address = address.substring(address.indexOf(",") + 2);
        } else {
            this.streetName = address.substring(0, address.indexOf(" Apt "));
            this.aptNumber = address.substring(address.indexOf("Apt") + 4, address.indexOf(","));
            address = address.substring(address.indexOf(",") + 2);
        }

        this.city = address.substring(0, address.indexOf(","));
        address = address.substring(address.indexOf(",") + 2);

        this.state = address.substring(0, address.indexOf(" "));

        this.zipCode = Integer.parseInt(address.substring(address.indexOf(" ") + 1));
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String toString() {
        return houseNumber + " " + streetName + " Apt " + aptNumber + ", " + city + ", " + state + " " + zipCode;
    }
}
