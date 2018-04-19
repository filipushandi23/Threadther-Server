<%-- 
    Document   : pickSeats
    Created on : Apr 17, 2018, 8:48:46 PM
    Author     : Filipus
--%>

<%@page import="model.Studio"%>
<%@page import="model.Seat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.SeatDAO"%>
<%@page import="dao.StudioDAO"%>
<%@page import="dao.MovieDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .col-seat{
            background-color: #4CAF50; /* Green */
            color: white;
            width: 50px;
            height: 50px;
            text-align: center;
            border-radius: 10px;
        }
        .button:hover {
            background-color: #f44336;
            color: white;
        }
    </style>
    <body>
    <center>
        <h1>Pick Seats</h1>
        <%
            String m_id = request.getParameter("m_id");
            String sch = request.getParameter("sch");
            String studioNumber = request.getParameter("studioNumber");
            Studio studio = new StudioDAO().findById(studioNumber);

            out.println("Movie: " + new MovieDAO().findById(m_id).getTitle() + "<br>");
            out.println("Schedule: " + sch);
            out.println("Studio  : " + studio.getStudioName() + " at " + studio.getCinema().getCinemaName());
            SeatDAO _seatDAO = new SeatDAO();
            ArrayList<Seat> seats = _seatDAO.getSeatByStudioNumber(Integer.parseInt(studioNumber));
            for (int idx = 0; idx < seats.size(); idx++) {
                if (idx % 7 == 0) {
                    out.println("<br>");
                }
                out.println("<button class='button col-seat'>"
                        + seats.get(idx).getId().getSeatPosition() + "</button>");
            }
            out.println("<br><br><br><button>Book Now</button");
        %>
    </center>
</body>
</html>
