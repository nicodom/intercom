package question3.util;

public enum DistanceUnit {

    KM("Kilometers", 1),
    MI("Miles", 0.621371),
    NM("Nautical Miles", 0.539957);

    private String description;
    private double fromKmConversionFactor;

    DistanceUnit(String description, double fromKmConversionFactor) {
        this.description = description;
        this.fromKmConversionFactor = fromKmConversionFactor;
    }

    public double getFromKmConversionFactor() {
        return fromKmConversionFactor;
    }

    public String getDescription() {
        return description;
    }
}
