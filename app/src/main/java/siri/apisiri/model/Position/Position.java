package siri.apisiri.model.Position;

public class Position {
    private double latitude;
    private double logitude;

    public Position(double latitude, double logitude) {
        this.latitude = latitude;
        this.logitude = logitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLogitude() {
        return logitude;
    }
}
