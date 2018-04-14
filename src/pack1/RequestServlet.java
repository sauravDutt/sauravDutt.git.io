package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/request1")
public class RequestServlet extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String name=req.getParameter("username");
		String pass=req.getParameter("pass");
		req.setAttribute("login", true);
		req.setAttribute("name", "rajababu");
		if(name.equals("vikas") && pass.equals("niit")){
			RequestDispatcher rd= req.getRequestDispatcher("/request2");
			rd.forward(req,res);
		}else{
			pw.write("<h3 style='color:red'>Wrong Id and Password !</h3>");
			RequestDispatcher rd= req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}
	}
}
