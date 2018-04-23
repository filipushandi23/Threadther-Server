/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import controller.CustomerCtrl;
import controller.MovieCtrl;
import dao.StudioDAO;
import dao.CustomerDAO;
import dao.UserDAO;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Customer;
import model.Movie;
import model.Schedule;
import model.Seat;
import model.Studio;
import model.User;

/**
 *
 * @author Jovin Angelico
 */
@WebService(serviceName = "WSCustomer")
public class WSCustomer {

    @WebMethod(operationName = "register")
    public Boolean register(@WebParam(name = "first_name") String first_name, @WebParam(name = "last_name") String last_name, @WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "profile_picture") String profile_picture, @WebParam(name = "phone_number") Integer phone_number, @WebParam(name = "birth_date") Date birth_date) {
        User user = new User(first_name, last_name, email, password, profile_picture);
        return new CustomerCtrl().register(user);
    }
    
    @WebMethod(operationName = "insertAsCustomer")
    public boolean insertCustomer(@WebParam(name="user")User user,@WebParam(name="phone")int phone,
            @WebParam(name="birthDate")Date birthDate){
        return new CustomerDAO().insertToCustomer(user,phone,birthDate);
    }

    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        return new CustomerCtrl().login(email, password);
    }
    
    @WebMethod(operationName = "updateUser")
    public boolean updateUser(@WebParam(name = "user") User user) {
        return new CustomerCtrl().editProfile(user);
    }
    
    @WebMethod(operationName = "getUserByEmail")
    public User getUserByEmail(@WebParam(name = "email") String email){
        return new UserDAO().findById(email);
    }
    
    @WebMethod(operationName = "topUp")
    public boolean topUp(@WebParam(name = "userId") int userId, @WebParam(name = "balance") int balance){
        return new CustomerCtrl().topUp(userId, balance);
    }
    
    @WebMethod(operationName = "getCustomer")
    public Customer getCustomer(@WebParam(name = "id") String id){
        return new CustomerCtrl().getCustomer(id);
    }
    

    @WebMethod(operationName = "getShowingMovies")
    public ArrayList<Movie> getShowingMovies() {
        return new MovieCtrl().showShowingMovies();
    }

    @WebMethod(operationName = "getMovieById")
    public Movie getMovieById(@WebParam(name = "movieId")String movieId) {
        return new MovieCtrl().getMovie(movieId);
    }

    @WebMethod(operationName = "getComingSoonMovies")
    public ArrayList<Movie> getComingSoonMovies() {
        return new MovieCtrl().showComingSoonMovies();
    }

    @WebMethod(operationName = "getAllScheduleByMovieId")
    public ArrayList<Schedule> getAllScheduleByMovieId(@WebParam(name = "movieId") int movieId) {
        return new MovieCtrl().showScheduleByMovie(movieId);
    }

    @WebMethod(operationName = "getSeatByStudioNumber")
    public ArrayList<Seat> getSeatByStudioNumber(@WebParam(name = "studioNumber") int studioNumber) {
        return new MovieCtrl().showSeatByStudioNumber(studioNumber);
    }

    @WebMethod(operationName = "getStudioByStudioNumber")
    public Studio getStudioByStudioNumber(@WebParam(name = "studioNumber") String studioNumber) {
        return new StudioDAO().findById(studioNumber);
    }
    
    

}
