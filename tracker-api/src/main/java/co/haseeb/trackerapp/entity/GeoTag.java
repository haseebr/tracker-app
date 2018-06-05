package co.haseeb.trackerapp.entity;

import java.util.Date;

//@Entity
public class GeoTag {
    private double longitude;
    private double latitude;
    //    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "GeoTag{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", time=" + timestamp +
                '}';
    }
}
