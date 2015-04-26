package ua.daywalk.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import ua.daywalk.model.Point;
import ua.daywalk.model.Route;
import ua.daywalk.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by vladislavposashkov on 26.04.15.
 */
public class RouteDAOImpl {
    private final static Logger LOGGER = Logger.getLogger(RouteDAOImpl.class.getSimpleName());

    public void addRoute(Route route) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(route);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            if (session != null) {
                session.getTransaction().rollback();
                throw ex;
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateRoute(Route route) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(route);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Point getRouteWithId(Integer id) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from dw_route where id = :id").setParameter("id", id);
            return (Point) query.uniqueResult();
        } catch (HibernateException ex) {
            LOGGER.warning(ex.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    public List<Route> getAllRoute() throws HibernateException {
        Session session = null;
        List<Route> routes = new ArrayList<Route>();
        try {
            LOGGER.info("INFO: RouteDAO Get list of Survey");
            session = HibernateUtil.getSessionFactory().openSession();
            routes = session.createCriteria(Route.class).list();
        } catch (HibernateException ex) {
            LOGGER.warning("Error in getAllRoute");
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return routes;
    }

    public void deleteRoute(Integer id) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("delete Route where id = :id");
            q.setParameter("id", id);
            q.executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            if (session != null) {
                session.getTransaction().rollback();
                throw ex;
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
