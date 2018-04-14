package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class MyGenericServlet extends GenericServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		ServletConfig config=getServletConfig();
		String p=config.getInitParameter("p1");
		pw.write("<h1><mark>Generic Servlet</mark></h1>");
		pw.write("<h1>parameter value <mark>"+p+"</mark></h1>");
		
		ServletContext context=getServletContext();
		System.out.println(context.getInitParameter("c1"));
		pw.close();
		
	}

}
