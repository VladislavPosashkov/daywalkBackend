package ua.daywalk.model;

import java.util.List;

/**
 * Created by vladislavposashkov on 26.04.15.
 */
public class Tour {
    private Route route;
    private List<Point> pointList;

    public Tour(Route route, List<Point> pointList) {
        this.route = route;
        this.pointList = pointList;
    }
}
