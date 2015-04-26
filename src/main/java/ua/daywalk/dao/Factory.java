package ua.daywalk.dao;

public class Factory {
    private static PointDAOImpl pointDAO = null;
    private static RouteDAOImpl routeDAO = null;
    private static Factory instance = null;


    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public static PointDAOImpl getPointDAO() {
        if (pointDAO == null) {
            pointDAO = new PointDAOImpl();
        }
        return pointDAO;
    }

    public static RouteDAOImpl getRouteDAO() {
        if (routeDAO == null) {
            routeDAO = new RouteDAOImpl();
        }
        return routeDAO;
    }
}
