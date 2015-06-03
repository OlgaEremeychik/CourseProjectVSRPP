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
public class TownDao extends AbstractDao<Town> {

    @Override
    public boolean creat(Town entity) {
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
    public List<Town> read() {
        Session session = null;
        List<Town> listTown = new ArrayList<Town>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            listTown = session.createQuery("from Town").list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return listTown;
    }

    @Override
    public boolean update(Town entity) {
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
    public boolean delete(Town entity) {
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
            Query query = session.createSQLQuery("delete from Town where id = :idTown");
            query.setParameter("idTown", id);
            session.getTransaction().commit();
            return true;
        }catch(HibernateException e){
            e.printStackTrace();
            return false;
        }
    }
    
}
