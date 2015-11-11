package question3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import question3.util.DistanceUnit;

import static com.google.common.base.Preconditions.checkNotNull;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Customer implements Comparable<Customer> {

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("name")
    private String name;

    public Customer() {
    }

    private Location location = new Location();

    public Customer(Integer userId, String name, Location location) {
        checkNotNull(userId, "userId cannot be null");
        checkNotNull(name, "name cannot be null");
        checkNotNull(location, "location cannot be null");

        this.userId = userId;
        this.name = name;
        this.location = location;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("latitude")
    public double getLatitude() {
        return location.getLatitude();
    }

    public void setLatitude(double latitude) {
        this.location.setLatitude(latitude);
    }

    @JsonProperty("longitude")
    public double getLongitude() {
        return location.getLongitude();
    }

    public void setLongitude(double longitude) {
        this.location.setLongitude(longitude);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int compareTo(Customer compareCustomer) {
        return this.userId.compareTo(compareCustomer.userId);
    }

    public double distanceFrom(Location otherLocation, DistanceUnit distanceUnit) {
        return location.distanceFrom(otherLocation, distanceUnit);
    }
    public boolean isInRangeFromLocation(Location otherLocation, Integer distanceInKm, DistanceUnit distanceUnit) {
        return location.isInRangeFromLocation(otherLocation, distanceInKm, distanceUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!userId.equals(customer.userId)) return false;
        return name.equals(customer.name);

    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}

