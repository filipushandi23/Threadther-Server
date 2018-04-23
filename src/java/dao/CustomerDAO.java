package dao;

import java.util.ArrayList;
import java.util.Date;
import model.Customer;
import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/* @author Jovin Angelico */
public class CustomerDAO extends AbstractDAOClass<Customer> {
    
    public boolean insertToCustomer(User user,int phone, Date date) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Customer c = new Customer(user, 0, phone, date);
        try {
            session.save(c);
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
    public boolean update(Customer updObj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        try {
            Customer customer = (Customer) session.get(
                    Customer.class,
                    updObj.getUserId());
            customer.setBalance(updObj.getBalance());
            customer.setPhoneNumber(updObj.getPhoneNumber());
            customer.setBirthDate(updObj.getBirthDate());
            
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
    public boolean delete(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        try {
            Customer customer = (Customer) session.get(Customer.class, Integer.parseInt(objId));
            session.delete(customer);
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
    public ArrayList<Customer> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Customer> result;
        
        try {
            Query q = session.createQuery("FROM Customer");
            result = (ArrayList<Customer>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
        
        return result;
    }
    
    @Override
    public Customer findById(String objId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer result;
        
        try {
            Query q = session.createQuery("FROM Customer WHERE userId = :u_id");
            int uId = Integer.parseInt(objId);
            q.setParameter("u_id", uId);
            result = (Customer) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
        
        return result;
    }
    
    public boolean topUpSaldo(int userId, int balance){
        Session session = HibernateUtil.getSessionFactory().openSession();
        int result=0;
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("Update Customer set balance = balance + :balance where userId = :userId");
        q.setParameter("userId", userId);
        q.setParameter("balance", balance);
        result = q.executeUpdate();
        tx.commit();
        session.close();
        return result > 0;
    }
}
