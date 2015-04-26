package ua.daywalk.model;

import java.util.List;

public class Tour {
    private Route route;
    private List<Point> points;

    public Tour() {
    }

    public Tour(Route route, List<Point> points) {
        this.route = route;
        this.points = points;
    }


    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> pointss) {
        this.points = points;
    }
}
