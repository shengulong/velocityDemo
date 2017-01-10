/**
 * Created by shendepu on 2017/1/4.
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.VelocityContext;
import java.util.Properties;
import java.util.Vector;

public class MyVelocity01 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Properties properties=new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        //properties.setProperty("input.encoding", "UTF-8");
        //properties.setProperty("output.encoding", "UTF-8");
        properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        VelocityEngine velocityEngine = new VelocityEngine(properties);
        VelocityContext context=new VelocityContext();
        Vector v = new Vector();
        v.addElement("Harry");
        v.addElement("John");
        String[] names = {"Harry", "John"};
        context.put("names1", v);
        context.put("names2", names);
        context.put("name", "test");
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //这样就会出现两次
        out.println(sw.toString());
    }
}
