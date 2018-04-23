package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import WS.WSAdmin;
import model.Movie;
import model.Studio;
import model.Cinema;
import java.util.List;

public final class assignMovie_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Assign Movie Schedule</h1>\n");
      out.write("        <form action=\"\" method=\"post\">\n");
      out.write("            <table>\n");
      out.write("                <tr><td>Select Studio</td><td>\n");
      out.write("                        <select>\n");
      out.write("                            ");

                                List<Studio> studios = new WSAdmin().getAllStudio();

                                for (Studio s : studios) {
                                    out.println("<option value='" + s.getStudioName() + "'>" + s.getStudioName() + 
                                            " "+s.getCinema().getCinemaName()+"</option>");
                                }
                            
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td></tr>\n");
      out.write("                <tr><td>Select Movie</td><td>\n");
      out.write("                        <select>\n");
      out.write("                            ");

                                List<Movie> movies = new WSAdmin().getShowingMovies();

                                for (Movie m : movies) {
                                    out.println("<option value='" + m.getTitle() + "'>" + m.getTitle() + "</option>");
                                }
                            
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td></tr>\n");
      out.write("                <tr><td>Select Time</td><td>\n");
      out.write("                        <select>\n");
      out.write("                            <option>11:00</option>\n");
      out.write("                            <option>13:00</option>\n");
      out.write("                            <option>15:00</option>\n");
      out.write("                            <option>17:00</option>\n");
      out.write("                            <option>19:00</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td></tr>\n");
      out.write("                <tr><td>Price</td><td><input type=\"text\" name=\"price\"</td></tr>\n");
      out.write("                <tr><td colspan=\"2\"><input type=\"submit\" value=\"Assign\"></td></tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
