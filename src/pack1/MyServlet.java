package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet extends GenericServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String username=req.getParameter("username");
		String password=req.getParameter("pass");
		
		Enumeration<String> param=req.getParameterNames();
		
		while(param.hasMoreElements()) {
			System.out.println(param.nextElement());
		}
		
		ServletConfig config=getServletConfig();
		
		Enumeration<String> e=config.getInitParameterNames();
		while(e.hasMoreElements()) {
			out.write("<h5>"+config.getInitParameter(e.nextElement())+"</h5>");
		}

		String[] s=req.getParameterValues("tm");
		for(String s1:s) {
			System.out.println(s1);
		}
		out.write("<h2>Welcome "+username+" your password is : "+password+"</h2>");
		out.write("<a href='genric'>Go to Generic</a>");
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy method invoked");
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return null;
	}
}
