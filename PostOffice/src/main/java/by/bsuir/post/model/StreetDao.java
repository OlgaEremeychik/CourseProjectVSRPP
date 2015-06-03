/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.model;

import by.bsuir.post.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author notepad
 */
public class StreetDao extends AbstractDao<Street> {

    @Override
    public boolean creat(Street entity) {
        Session session  = null;
        int result = 0;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            return true;
        }catch(HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Street> read() {
        Session session = null;
        List<Street> listStreet = new ArrayList<Street>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            listStreet = session.createQuery("from Street").list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return listStreet;
    }

    @Override
    public boolean update(Street entity) {
        Session session  = null;
        int result = 0;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            return true;
        }catch(HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Street entity) {
        Session session  = null;
        int result = 0;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            return true;
        }catch(HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        Session session  = null;
        int result = 0;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("delete from Street where id = :idStreet");
            query.setParameter("idStreet", id);
            result = query.executeUpdate();
            session.getTransaction().commit();
            return true;
        }catch(HibernateException e){
            e.printStackTrace();
            return false;
        }
    }
    
}
