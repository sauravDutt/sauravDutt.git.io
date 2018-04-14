package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/request2")
public class RequestServlet2 extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String name=req.getParameter("username");
		String pass=req.getParameter("pass");
		Boolean login=(Boolean) req.getAttribute("login");
		String rb=(String) req.getAttribute("name");
		PrintWriter pw = res.getWriter();
		pw.write("<h1> User Name : "+name+"</h1>");
		pw.write("<h1> User Password : "+pass+"</h1>");
		pw.write("<h1> Login : "+login+"</h1>");
		pw.write("<h1> RJ : "+rb+"</h1>");
		pw.close();
	}

}
