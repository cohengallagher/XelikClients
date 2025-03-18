// Cohen Gallagher 3/7/25

// Client class
public class Client {
    private String firstName;
    private String lastName;
    private String initial;
    private String phoneNumber;
    private int zipcode;
    private String state;
    private String city;
    private String planType;

    public Client(String firstName, String lastName, String initial, String phoneNumber, int zipcode, String state, String city, String planType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.initial = initial;
        this.phoneNumber = phoneNumber;
        this.zipcode = zipcode;
        this.state = state;
        this.city = city;
        this.planType = planType;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInitial() {
        return initial;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getPlanType() {
        return planType;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    // Override toString()

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", initial='" + initial + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", planType=" + planType +
                '}';
    }
}
