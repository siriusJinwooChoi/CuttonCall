package siri.apisiri.model.Route;

public class Route {
    // 0 : Walking 1 : Bus 2 : Subway
    private int moveMode = 0;
    private int durationHour = 0;
    private int durationMinute = 0;
    private double distance = 0.0;

    public Route(int moveMode, int duration) {
        this.moveMode = 0;
        this.durationHour = duration / 60;
        this.durationMinute = duration % 60;
    }

}
