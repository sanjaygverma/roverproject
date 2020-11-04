package com.mars.rover;

import java.util.Objects;

public class Rover {

    private final String roverId;

    private final String roverName;

    //features can be added

    @Override
    public String toString() {
        return "Rover{" +
                "roverId='" + roverId + '\'' +
                ", roverName='" + roverName + '\'' +
                '}';
    }

    public Rover(final String roverId, final String roverName)
    {
        this.roverId = roverId;
        this.roverName = roverName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(roverId, rover.roverId) &&
                Objects.equals(roverName, rover.roverName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roverId, roverName);
    }
}
