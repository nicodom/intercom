package question3.util;

import static com.google.common.base.Preconditions.*;

/**
 * The class {@code DistanceUtil} contains methods for performing
 * distance calculations.
 *
 * @author  Domenico Fioravanti
 */

public class DistanceUtil {

    private static final int EARTH_RADIUS_IN_KM = 6371;

    /**
     * This method calculates distance between points in different units.
     * <p>Using double insteaf of BigDecimal because we do not need meter precision</p>
     * @param lat1 latitude of point 1 in Decimal degrees (DD)
     * @param lon1 longitude of point 1 in Decimal degrees (DD)
     * @param lat2 latitude of point 2 in Decimal degrees (DD)
     * @param lon2 longitude of point 2 in Decimal degrees (DD)
     * @param unit unit: Kilometers | Miles | Nautical Miles
     * @return distance between points in units.
     */
    public static double distanceBetweenPoints(double lat1, double lon1, double lat2, double lon2, DistanceUnit unit) {
        checkNotNull(unit, "unit cannot be null");

        //degrees to radians conversion
        double lonDiffInRadians = Math.toRadians(lon1 - lon2);
        double lat1InRadians = Math.toRadians(lat1);
        double lat2InRadians = Math.toRadians(lat2);

        //applying spherical law of cosines formula to get distance in radians
        double distanceInRadians = applySphericalLawOfCosines(lat1InRadians, lat2InRadians, lonDiffInRadians);

        //applying unit conversion: degrees --> Kilometers | Miles | Nautical Miles
        return distanceInRadians * EARTH_RADIUS_IN_KM * unit.getFromKmConversionFactor();
    }

    private static double applySphericalLawOfCosines(double lat1InRadians, double lat2InRadians, double lonDiffInRadians) {
        return Math.acos(Math.sin(lat1InRadians) * Math.sin(lat2InRadians)
                + Math.cos(lat1InRadians) * Math.cos(lat2InRadians) * Math.cos(lonDiffInRadians));
    }

}
