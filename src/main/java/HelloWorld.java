/**
 * Created by shendepu on 2017/1/4.
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HelloWorld extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hi!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!!!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}