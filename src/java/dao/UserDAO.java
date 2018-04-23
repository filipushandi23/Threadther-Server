package dao;

import java.util.ArrayList;
import util.HibernateUtil;
import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/* @author Jovin Angelico */
public class UserDAO extends AbstractDAOClass<User> {

    public static boolean login(String email, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction t = session.beginTransaction();
        Query q = session.createQuery("FROM User WHERE email = :email AND password = :password");
        q.setParameter("email", email);
        q.setParameter("password", password);
        t.commit();

        User user = (User) q.uniqueResult();
        session.close();

        return (user != null);

    }

    @Override
    public boolean update(User updObj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        int result = 0;
        Query q = session.createQuery("UPDATE User set firstName = :fn, lastName = :ln, password = :pwd,"
                + " email = :em, profilePicture = :pic WHERE email = :em");
        q.setParameter("fn", updObj.getFirstName());
        q.setParameter("ln", updObj.getLastName());
        q.setParameter("pwd", updObj.getPassword());
        q.setParameter("em", updObj.getEmail());
        q.setParameter("pic", updObj.getProfilePicture());
        
        result = q.executeUpdate();
        tx.commit();
        return result > 0;
    }

    @Override
    public boolean delete(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            User user = (User) session.get(User.class, Integer.parseInt(objId));
            session.delete(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }

        return true;
    }

    @Override
    public ArrayList<User> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<User> result;

        try {
            Query q = session.createQuery("FROM User");
            result = (ArrayList<User>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public User findById(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User result=null;

        try {
            Query q = session.createQuery("FROM User WHERE email = :em");
            q.setParameter("em", email);
            result = (User) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return result;
    }

}
