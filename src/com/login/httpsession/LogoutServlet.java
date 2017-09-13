package com.login.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
			out.println("<body bgcolor='#f2e0a9'>");
			out.print("You're Successfully Logged Out!!!");
		} else {
			out.println("You were not Logged In!!! Please Login In!!!!");
			req.getRequestDispatcher("login.html").include(req, resp);

		}
		req.getRequestDispatcher("logoutlink.html").include(req, resp);
	}
}
