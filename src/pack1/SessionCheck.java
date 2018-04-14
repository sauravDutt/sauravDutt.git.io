package pack1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/home.html")
public class SessionCheck implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain f)
			throws IOException, ServletException {
		HttpServletRequest http=(HttpServletRequest) req;
		HttpSession session=http.getSession();
		String username=(String) session.getAttribute("username");
		System.out.println("filter "+username);
		if(username!=null) {
			RequestDispatcher rd= http.getRequestDispatcher("google.html");
			rd.forward(req, res);
		}else {
			f.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

}
