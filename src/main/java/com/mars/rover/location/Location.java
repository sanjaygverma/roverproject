
package com.mars.rover.location;

import java.util.Objects;

public class Location {

    private int longitude; //y

    private int latitude; //x

    private String direction;


    public Location(int latitude, int longitude, String direction)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return longitude == location.longitude &&
                latitude == location.latitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude);
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", direction='" + direction + '\'' +
                '}';
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public String getDirection() {
        return direction;
    }

    public Location updateLongitude(int longitude) {
        return new Location(this.latitude,longitude,this.direction);
    }

    public Location updateLatitude(int latitude) {
        return new Location(latitude,this.longitude,this.direction);
    }

    public Location updateDirection(String direction) {
        return new Location(this.latitude,this.longitude,direction);
    }
}

