package question3.model;

import question3.util.DistanceUnit;
import question3.util.DistanceUtil;

import static com.google.common.base.Preconditions.checkArgument;

public class Location {

    private double latitude;
    private double longitude;

    public Location() {
    }

    public Location(double latitude, double longitude) {
        checkArgument(-90.0 <= latitude && latitude <= 90.0, "The latitude of the location may range from -90.0 to 90.0.");
        checkArgument(-180.0 <= longitude && longitude <= 180.0, "The longitude of the location may range from -180.0 to 180.0.");

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        checkArgument(-90.0 <= latitude && latitude <= 90.0, "The latitude of the location may range from -90.0 to 90.0.");

        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        checkArgument(-180.0 <= longitude && longitude <= 180.0, "The longitude of the location may range from -180.0 to 180.0.");

        this.longitude = longitude;
    }

    public double distanceFrom(Location otherLocation, DistanceUnit distanceUnit) {
        return DistanceUtil.distanceBetweenPoints(this.latitude, this.longitude,
                otherLocation.latitude, otherLocation.longitude, distanceUnit);
    }

    public boolean isInRangeFromLocation(Location otherLocation, Integer distance, DistanceUnit distanceUnit) {

        return distanceFrom(otherLocation, distanceUnit) <= distance.intValue();
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
