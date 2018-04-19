<%-- 
    Document   : showTest
    Created on : Mar 17, 2018, 12:49:25 PM
    Author     : Filipus
--%>

<%@page import="dao.ScheduleDAO"%>
<%@page import="model.Movie"%>
<%@page import="model.Schedule"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MovieDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" cellpadding="5">
            <tr><td>Title</td><td>Poster</td><td>Duration</td><td>Schedule</td></tr>
            <%
                MovieDAO _movieDAO = new MovieDAO();
                ScheduleDAO _scheduleDAO = new ScheduleDAO();
                ArrayList<Movie> movies = _movieDAO.getAll();
                ArrayList<Schedule> schedules = new ArrayList();

                for (Movie movie: movies) {
                    out.println("<tr>");
                    out.println("<td>" + movie.getTitle() + "</td>");
                    out.println("<td><img src='" + movie.getPoster() + "' width='182px' height='268px'></td>");
                    out.println("<td> " + movie.getDuration() + "minutes </td>");
                    out.println("<td><ul>");
                    schedules = _scheduleDAO.getAllScheduleByMovieId(movie.getMovieId());
                    for (Schedule s : schedules) {
                        out.println("<li><a href='pickSeats.jsp?m_id="+movie.getMovieId()+"&sch="+s.getId().getMovieStart()+""
                                + "&studioNumber="+s.getStudio().getStudioNumber()+"'>" + 
                                s.getId().getMovieStart()+"</a></li>");
                    }
                    out.println("</ul></td>");
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>
