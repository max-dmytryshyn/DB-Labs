package ua.lviv.iot.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.model.dao.AbstractDao;
import ua.lviv.iot.util.HibernateUtil;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractDaoImpl<E> implements AbstractDao<E> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final Class<E> eClass;

    public AbstractDaoImpl(Class<E> eClass) {
        this.eClass = eClass;
    }

    @Override
    public List<E> getAll() {
        List<E> entityList = new LinkedList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            entityList = session.createQuery("from " + eClass.getSimpleName()).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entityList;
    }

    @Override
    public E get(Integer id) {
        E entity = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            entity = session.get(eClass, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public void create(E entity) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, E entity) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            E entity = session.get(eClass, id);
            if (entity != null) {
                session.delete(entity);
            }
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
