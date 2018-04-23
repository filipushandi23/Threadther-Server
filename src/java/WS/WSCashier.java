/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import controller.CustomerCtrl;
import controller.MovieCtrl;
import dao.StudioDAO;
import dao.UserDAO;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Movie;
import model.Schedule;
import model.Seat;
import model.Studio;
import model.User;

/**
 *
 * @author Jovin Angelico
 */
@WebService(serviceName = "WSCashier")
public class WSCashier {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        return new CustomerCtrl().login(email, password);
    }
    @WebMethod(operationName = "getUserByEmail")
    public User getUserByEmail(@WebParam(name = "email") String email){
        return new UserDAO().findById(email);
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
