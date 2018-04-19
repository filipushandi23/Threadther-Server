package model;
// Generated Apr 16, 2018 10:03:05 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer userId;
     private String firstName;
     private String lastName;
     private String email;
     private String password;
     private String profilePicture;
     private Customer customer;
     private Set<Transaction> transactions = new HashSet<Transaction>(0);
     private Admin admin;
     private Cashier cashier;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, String profilePicture, Customer customer, Set<Transaction> transactions, Admin admin, Cashier cashier) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.password = password;
       this.profilePicture = profilePicture;
       this.customer = customer;
       this.transactions = transactions;
       this.admin = admin;
       this.cashier = cashier;
    }
    
    public User(String firstName, String lastName, String email, String password, String profilePicture) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.password = password;
       this.profilePicture = profilePicture;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getProfilePicture() {
        return this.profilePicture;
    }
    
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Set<Transaction> getTransactions() {
        return this.transactions;
    }
    
    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
    public Admin getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public Cashier getCashier() {
        return this.cashier;
    }
    
    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }




}


