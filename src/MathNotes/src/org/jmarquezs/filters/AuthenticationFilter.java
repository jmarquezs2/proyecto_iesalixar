package org.jmarquezs.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);
		System.out.println("He entrado en el filtro");
		if (session == null || session.getAttribute("Rol") == null) { // checking whether the session exists
			this.context.log("Unauthorized access request");
			res.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
			System.out.println("He entrado en el filtro 2");
		} else {
			// pass the request along the filter chain
			if (session.getAttribute("Rol").equals("user")) {
				res.sendRedirect("/MathNotes/Notes");
				System.out.println("He entrado en el filtro 3");
			} else {
				res.sendRedirect("/MathNotes/Moderacion");
				System.out.println("He entrado en el filtro 4");
			}

		}
	}

	public void destroy() {
		// close any resources here
	}
}