package model;
// Generated Apr 16, 2018 10:03:05 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Transaction generated by hbm2java
 */
public class Transaction  implements java.io.Serializable {


     private Integer transactionId;
     private Schedule schedule;
     private User user;
     private Integer status;
     private Date time;
     private Set<Ticket> tickets = new HashSet<Ticket>(0);

    public Transaction() {
    }

	
    public Transaction(Schedule schedule, Date time) {
        this.schedule = schedule;
        this.time = time;
    }
    public Transaction(Schedule schedule, User user, Integer status, Date time, Set<Ticket> tickets) {
       this.schedule = schedule;
       this.user = user;
       this.status = status;
       this.time = time;
       this.tickets = tickets;
    }
   
    public Integer getTransactionId() {
        return this.transactionId;
    }
    
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }
    public Schedule getSchedule() {
        return this.schedule;
    }
    
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }
    public Set<Ticket> getTickets() {
        return this.tickets;
    }
    
    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }




}


