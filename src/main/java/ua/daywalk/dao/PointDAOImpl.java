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


public class PointDAOImpl {

    private final static Logger LOGGER = Logger.getLogger(PointDAOImpl.class.getSimpleName());


    public List<Point> getAllPoint() throws HibernateException {
        Session session = null;
        List<Point> points = new ArrayList<Point>();
        try {
            LOGGER.info("INFO: RouteDAO Get list of Survey");
            session = HibernateUtil.getSessionFactory().openSession();
            points = session.createCriteria(Point.class).list();
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

        return points;
    }

    public void addPoint(Point point) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(point);
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

    public void updatePoint(Point point) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(point);
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

    public Point getPointWithId(Integer id) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from dw_point where id = :id").setParameter("id", id);
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

    public List<Route> getPointForRoute(Integer routeId) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from dw_point where routeId = :id");
            query.setParameter("id", routeId);
            return query.list();
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
        return null;
    }

    public void deletePoint(Integer id) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("delete dw_point where id = :id");
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
